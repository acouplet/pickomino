#ifndef DEF_GAME
#define DEF_GAME

#include <iostream>
#include <vector>
#include <set>
#include "include/Player.h"
#include "include/Dice.h"
#include "include/Tile.h"

class Game {
	public:
		Game(vector<string> names);
		void print_players();
	
	private:
		int nb_players;
		std::vector<Player> players;
		// std::vector<Dice> dices;
		std::set<Tile> tiles;
};

#endif
