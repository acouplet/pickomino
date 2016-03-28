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
		Game(std::vector<std::string> names);
		void print_players();
	
	private:
		int nb_players;
		int nb_dices;
		std::vector<Player> players;
		// std::vector<Dice> dices;
		std::set<Tile> tiles;
};

std::ostream &operator<<(std::ostream &os, Tile const &m);

#endif
