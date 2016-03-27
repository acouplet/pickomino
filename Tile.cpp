#include "Tile.h"

using namespace std;

Tile::Tile(int arg_number) {
	number = arg_number;
}

int Tile::get_number() const{
	return number;
}

int Tile::get_value() const{
	if (number>=33)
		return 4;
	if (number>=29)
		return 3;
	if (number>=25)
		return 2;
	return 1;
}

