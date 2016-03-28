#include "AI.h"

using namespace std;

/* Class variables
 * 		std::vector<int> score;
 * 		std::vector< stack<Tile> > tile_stacks;
 *		int nb_players;
 *		std::set<Tile> game_tiles;
 * 		int id;
 *		int score;
 *		std::string name;
 *		std::stack<Tile> tile_stack;
 *		std::multiset<Dice> dice;
 */

long long fact(long long i) {
    if(i == 0) return 1;
    return i * fact(i-1);
}

int binom(long long n, long long k) {
    return fact(n) / (fact(k) * fact(n-k));
}

int nb_rolls(int n) {
    return binom(n + NB_FACES - 1, n);
}

map< multiset<int>, double > memo;
map< multiset<int>, bool > roll_or_stop_decision;
map< multiset<int>, Tile > choose_tile_decision;
map< multiset<int>, map< multiset<int>, int > choose_dice_decision;

int first_p, second_p;

void process_first_players() {
    first_p = 0; second_p = -1;
    for(int p = 1; p < nb_players-1; ++p)
        if(scores[p] > scores[first_p]) {
            second_p = first_p;
            first_p = i;
        }
}

int failure_value() {
    return score - ((tile_stack.empty()) ? 0 : tile_stack.top().get_value()) - score[first_p];
}

int dice_value(multiset<int> dice) {
    int points = 0; bool has_worm = false;
    for(auto it : dice) {
        points += min(it, WORM-1);
        if(it == WORM)
            has_worm = true;
    }

    int best_value = failure_value();
    Tile best_decision;

    if(!has_worm)
        return best_value;

    auto it = game_tiles.upper_bound(points);
    if(it != game_tiles.begin()) {
        Tile t = *(--it), cand = score + t.get_value() - scores[first_p];
        if(cand > best_value) {
            best_value = cand;
            best_decision = t;
        }
    }

    for(int p = 0; p < nb_players-1; ++p)
        if(!tile_stacks[p].empty() && tile_stacks[p].top().get_number() == points) {
            int cand = score + tile_stacks[p].top().get_value();
            if(p == first_p)
                cand -= max(scores[p] - tile_stacks[p].top().get_value(), (second_p == -1) ? 0 : scores[second_p]);
            else
                cand -= scores[first_p];
            if(cand > best_value) {
                best_value = cand;
                best_decision = tile_stacks[p].top();
            }
        }

    choose_tile_decision[dice] = best_decision;
    return best_value;
}

double transition(multiset<int> dice, multiset<int> roll) {
    if(dice.size() + roll.size() == NB_DICE) {
        double best_value = failure_value();
        int best_decision = 0;
        for(int f = 1; f <= NB_FACES; ++f) {
            int k = roll.count(f);
            if(k > 0 && dice.count(f) == 0) {
                while(k--)
                    dice.insert(f);
                double cand = dp(dice);
                if(cand > best_value) {
                    best_value = cand;
                    best_decision = f;
                }
                state.erase(f);
            }
        }
        
        choose_dice_decision[dice][roll] = best_decision;
        return best_value;
    } else {
        double sum = 0;
        for(int i = ((roll.size() == 0) ? 1 : *roll.rbegin()); i <= NB_FACES; ++i) {
            roll.insert(i);
            sum += transition(dice, roll);
            roll.erase(roll.find(i));
        }
        return sum;
    }
}

double dp(multiset<int> dice) {
    if(memo.count(dice))
        return memo[dice];
    if(dice.size() == NB_DICE)
        return memo[dice] = dice_value(dice);
    else {
        double stop = dice_value(dice);
        multiset<int> roll; 
        double go_on = transition(dice, roll) / nb_rolls(NB_DICE - dice.size());
        roll_or_stop_decision[dice] = (go_on > stop);
        return memo[state] = max(stop, go_on);
    }
}

void turn_start() {
	process_first_players();
    multiset<int> empty_dice; dp(empty_dice);
}

bool roll_or_stop() {
	return roll_or_stop_decision[dice];
}

Tile choose_tile() {
    return choose_tile_decision[dice];
}

int choose_dice(std::multiset<Dice> roll) {
	return choose_dice_decision[dice][roll];
}

void turn_end() {
    memo.clear();
    roll_or_stop_decision.clear();
    choose_tile_decision.clear();
    choose_dice_decision.clear();
}
