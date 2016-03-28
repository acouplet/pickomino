#ifndef DEF_GAME
#define DEF_GAME

#include <iostream>
#include <vector>
#include <set>
#include "Player.h"
#include "Dice.h"
#include "Tile.h"

class Game {
	public:
		Game(std::vector<Player> p);
		
		void print_players();
	
	private:
		int nb_players;
		std::vector<Player> players;
		std::vector<Dice> dices;
		std::set<Tile> tiles;
};

#endif
