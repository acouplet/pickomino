import java.util.Scanner;

class Human extends Intelligence {
	private Scanner sc = new Scanner(System.in);

    public void gameStart() {
    	
    }

    public void turnStart() {
		System.out.format("==== GAME INFORMATION ===%n");
		System.out.format("Available tiles : ");
		for(Tile t : gameTiles){
			System.out.format("%s ", t);
		}
		System.out.format("%n");	
		System.out.format("Opponent's score and upper tile : %n");
		for(int i = 0; i<nbPlayers-1; i++){
			if (tileStacks[i].length != 0)
				System.out.format("\t%s : [score = %02d]%n", names[i], scores[i]);
			else
				System.out.format("\t%s : [score = %02d ; upper tile = %s]%n", names[i], scores[i], tileStacks[i][0]);
		}
		System.out.format("%n%n");
    }

    public boolean rollOrStop(TreeMap<Die, Integer> dice) {
    	int dice_sum = 0;
    	
    	System.out.format("You currently have : [");
    	for (Map.Entry<Die, Integer> entry : dice.entrySet()){
    		System.out.format("%dx%d ", entry.getValue(), entry.getKey().getValue());
    		dice_sum += entry.getValue() * entry.getKey().getValue();
		}
		System.out.format("%n");
		
    	while (true) {
	    	System.out.format("What do you want to do?%n\t1) Roll the dice%n\t2)Take a tile%nDecision : ");
	    	int num = sc.nextInt();
	    	if (num == 1)
	    		return true;
	    	else if (num == 2)
	    		return false;
	    }
	    
        return false;
    }

    public Tile chooseTile(TreeMap<Die, Integer> dice) {
    	int dice_sum = 0;
    	
    	for (Map.Entry<Die, Integer> entry : dice.entrySet()){
    		dice_sum += entry.getValue() * entry.getKey().getValue();
		}
		
    	TreeSet<Tile> eligibleTiles = new TreeSet<Tile>();
    	for(Tile t : gameTiles){
    		if (t.getId() <= dice_sum)
    			eligibleTiles.add(t);
    	}
    	
    	
    	
    	
        return null;
    }

    public Die chooseDice(TreeMap<Die, Integer> dice, TreeMap<Die, Integer> roll) {
        return null;
    }

    public void turnEnd() {

    }

    public void gameEnd() {

    }
}
