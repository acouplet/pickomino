#include "Dice.h"

using namespace std;

Dice::Dice() {
	value = rand() % 6 + 1;
}

int Dice::get_value(){
	return value;
}


