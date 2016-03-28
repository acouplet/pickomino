#include "include/Player.h"
using namespace std;

Player::Player(int id, std::string name) {
	this.id = id;
	this.name = name;
	this.score = 0;
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

Tile get_top() const {
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
	
std::ostream &operator<<(std::ostream &os, Player const &p) { 
    os << "[id:" << p.get_id() << ", " << p.get_name() << "] " << p.get_nb_tiles() << " tiles. ";
    if (p.get_nb_tiles() != 0)
		os << "Last tile : number = " << p.get_tile().get_number() << "; value = " << p.get_tile().get_value();
	return os;
}

