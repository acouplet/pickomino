class Human extends Intelligence {
    public void gameStart() {
    	
    }

    public void turnStart() {
		System.out.format("==== GAME INFORMATION ===%n%n");
		System.out.format("Available tiles : ");
		for(Tile t : gameTiles){
			System.out.format("%s ", t);
		}
		System.out.format("%n%n");	
		System.out.format("Opponent's score and upper tile : %n");
		for(int i = 0; i<nbPlayers-1; i++){
			if (tileStacks[i].length != 0)
				System.out.format("\t%s : [score = %02d]%n", names[i], scores[i]);
			else
				System.out.format("\t%s : [score = %02d ; upper tile = %s]%n", names[i], scores[i], tileStacks[i][0]);
			
			
    }

    public boolean rollOrStop(Map<Die, Integer> dice) {
    	
        return false;
    }

    public Tile chooseTile(Map<Die, Integer> dice) {
        return null;
    }

    public Die chooseDice(Map<Die, Integer> dice, Map<Die, Integer> roll) {
        return null;
    }

    public void turnEnd() {

    }

    public void gameEnd() {

    }
}
