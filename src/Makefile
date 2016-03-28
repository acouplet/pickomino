TARGET = pickomino
INCDIR = ../include
BINDIR = ../bin
SRCDIR = .
OBJDIR = ../obj
LIBDIR = ../lib

CC=g++
CFLAGS=-std=c++11 -Wall -I$(INCDIR)

LIBS=-lm

_DEPS = Dice.h Game.h Player.h Tile.h
DEPS = $(patsubst %,$(INCDIR)/%,$(_DEPS))

_OBJ = Dice.o Game.o Player.o Tile.o main.o
OBJ = $(patsubst %,$(OBJDIR)/%,$(_OBJ))


$(OBJDIR)/%.o: $(SRCDIR)/%.cpp $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

$(BINDIR)/$(TARGET): $(OBJ)
	g++ -o $@ $^ $(CFLAGS) $(LIBS)

.PHONY: clean

clean:
	rm -f $(ODIR)/*.o *~ core $(INCDIR)/*~ 
