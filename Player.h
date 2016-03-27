#ifndef DEF_PLAYER
#define DEF_PLAYER

#include <string>
#include <vector>
#include <stack>
#include <iostream>
#include "Tile.h"
#include "Dice.h"


class Player {
	public:
		Player(int id, std::string name);
		int get_id() const;
		std::string get_name() const;
		Tile get_tile() const;
		int get_score() const;
		int get_nb_tiles() const;
		void push_tile(Tile t);
		void pop_tile();
	
	private:
		int id;
		int score;
		std::string name;
		std::stack<Tile> tiles;
		std::vector<Dice> dices;
		
	
};

std::ostream &operator<<(std::ostream &os, Player const &m);

#endif
