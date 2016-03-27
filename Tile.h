#ifndef DEF_TILE
#define DEF_TILE

class Tile {
	public:
		Tile(int arg_number);
		int get_number() const;
		int get_value() const;
	
	private:
		int number;
};

#endif
