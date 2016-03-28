#ifndef DEF_DICE
#define DEF_DICE

#include <stdlib.h> 
#include <time.h>
#include "constants.h"

class Dice {
	public:
		Dice();
		int get_face();
	    void roll();
	private:
		int face;
};

#endif
