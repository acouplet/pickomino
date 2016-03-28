#ifndef DEF_PLAYER
#define DEF_PLAYER

#include <string>
#include <vector>
#include <stack>
#include <iostream>
#include "include/Tile.h"
#include "include/Dice.h"


class Player {
	public:
		Player(int id, std::string name);
		int get_id() const;
		std::string get_name() const;
		int get_score() const;
        Tile get_top() const;
		// int get_nb_tiles() const; utile ?
		void push_tile(Tile t);
		Tile pop_tile();
	private:
		int id;
		int score;
		std::string name;
		std::stack<Tile> tiles;
		std::multiset<Dice> dice;
};

std::ostream &operator<<(std::ostream &os, Player const &m);

#endif
