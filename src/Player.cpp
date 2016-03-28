#include "Player.h"
using namespace std;

Player::Player(int arg_id, string arg_name) {
	id = arg_id;
	name = arg_name;
	score = 0;
}

int  Player::get_id() const{
	return id;
}

std::string Player::get_name() const{
	return name;
}

int Player::get_score() const{
	return score;
}

Tile Player::get_top() const {
    return tiles.top();
}

int Player::get_nb_tiles() const{
	return tiles.size();
}

void Player::push_tile(Tile t){
	tiles.push(t);
}

Tile Player::pop_tile() {
    Tile t = tiles.top();
	tiles.pop();
    return t;
}
	
ostream &operator<<(ostream &os, Player const &p) { 
    os << "[id:" << p.get_id() << ", " << p.get_name() << "] " << p.get_nb_tiles() << " tiles. ";
    if (p.get_nb_tiles() != 0)
		os << "Last tile : number = " << p.get_top().get_number() << "; value = " << p.get_top().get_value();
	return os;
}

