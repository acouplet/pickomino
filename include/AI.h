#ifndef DEF_AI
#define DEF_AI
 
#include <vector>
#include <set>
#include "Player.h"
 
class AI : public Player{
	public:
		void turn_start();
		void turn_end();
		int roll_or_stop();
		int choose_dice(std::multiset<Dice> roll);
		
	private:
		std::vector<int> score;
		std::vector<int> top_tiles;
		int nb_players;
		std::set<Tile> tiles;		
};
 
#endif
