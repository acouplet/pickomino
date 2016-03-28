#include <iostream>
#include "Player.h"
#include "Tile.h"
#include "Dice.h"
#include "Game.h"



using namespace std;

int main() {
	vector<Player> p;
	Player p1(1,"Adrien");
	Player p2(2,"Mattéo");
	
	Tile t(32);
	
	p1.push_tile(t);
	
	cout << p1 << endl;
	cout << p2 << endl;
	
	p.push_back(p1);
	p.push_back(p2);
	Game g(p);

	
}
