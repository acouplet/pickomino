#include "Game.h"

using namespace std;

Game::Game(vector<string> names) {
	nb_players = names.size();
    for(int id = 0; id < nb_players; ++id)
        players.push_back(Player(id, names[id]));
    tiles.clear();
    for(int number = FIRST_TILE; number <= LAST_TILE; number++){
		tiles.insert(Tile(number));
	}
}

void print_players(){
	//for(int i = 0; i<players.size(); i++){
		
}

