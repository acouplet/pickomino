#ifndef DEF_TILE
#define DEF_TILE

#include <iostream>

class Tile {
	public:
		Tile(int arg_number);
		int get_number() const;
		int get_value() const;
		
	
	private:
		int number;
};

bool operator< (const Tile &left, const Tile &right);
std::ostream &operator<<(std::ostream &os, Tile const &m);

#endif
