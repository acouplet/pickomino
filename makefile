CC=g++
CFLAGS=-I.
DEPS = Player.h Tile.h Dice.h Game.h
OBJ = Player.o Tile.o Dice.o Game.o main.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

pickomino: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)
