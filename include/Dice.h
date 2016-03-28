#ifndef DEF_DICE
#define DEF_DICE

#include <stdlib.h> 
#include <time.h>
#include "constants.h"

class Dice {
	public:
		// Constructor
		Dice();
		
		// Get functions
		int get_face();
		
		// Modifiers
	    void roll();
	    
	private:
		int face;
};

#endif
