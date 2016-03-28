
#include "Dice.h"

using namespace std;

Dice::Dice() {
    roll();
}

int Dice::get_face() {
	return face;
}

void Dice::roll() {
    face = rand() % NB_FACES + 1;
}

