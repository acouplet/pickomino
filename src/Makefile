TARGET = pickomino
IDIR =../include
BINDIR = ../bin
CC=g++
CFLAGS=-Wall -I$(IDIR)

ODIR=../obj
LDIR =../lib

LIBS=-lm

_DEPS = Dice.h Game.h Player.h Tile.h
DEPS = $(patsubst %,$(IDIR)/%,$(_DEPS))

_OBJ = Dice.o Game.o Player.o Tile.o main.o
OBJ = $(patsubst %,$(ODIR)/%,$(_OBJ))


$(ODIR)/%.o: %.cpp $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

$(BINDIR)/$(TARGET): $(OBJ)
	g++ -o $@ $^ $(CFLAGS) $(LIBS)

.PHONY: clean

clean:
	rm -f $(ODIR)/*.o *~ core $(INCDIR)/*~ 
