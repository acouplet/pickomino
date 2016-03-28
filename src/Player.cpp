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

string Player::get_name() const{
	return name;
}

int Player::get_score() const{
	return score;
}

int Player::get_nb_tiles() const{
	return tiles.size();
}

Tile Player::get_tile() const{
	return tiles.top();
}

void Player::push_tile(Tile t){
	tiles.push(t);
}

void Player::pop_tile() {
	tiles.pop();
}
	
std::ostream &operator<<(std::ostream &os, Player const &p) { 
    os << "[id:" << p.get_id() << ", " << p.get_name() << "] " << p.get_nb_tiles() << " tiles. ";
    if (p.get_nb_tiles() != 0)
		os << "Last tile : number = " << p.get_tile().get_number() << "; value = " << p.get_tile().get_value();
	return os;
}
