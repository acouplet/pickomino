JFLAGS = -g
JC = javac
BINDIR = ../bin

sources = $(wildcard *.java) $(wildcard **/*.java)
classes = $(sources:.java=.class)

all: $(classes)

clean :
	rm -f $(BINDIR)/*.class

%.class : %.java
	$(JC) -d $(BINDIR) $<

