import java.util.Map;
import java.util.TreeMap;

class DiceSet {
    private int nbDice;
    private TreeMap<Die, Integer> frequency;

    public DiceSet() {
        nbDice      = 0;
        frequency   = new TreeMap<Die, Integer>();
    }

    public int size() {
        return nbDice;
    }

    public void addMultiple(Die d, int k) {
        frequency.put(d, k + ((frequency.get(d) == null) ? 0 : frequency.get(d)));
        nbDice += k;
    }

    public void add(Die d) {
        addMultiple(d, 1);
    }

    public void add() {
        add(new Die());
    }

    public DiceSet(int n) {
        this();
        while(n-- > 0)
            add();
    }

    public DiceSet(DiceSet o) {
        this.nbDice     = o.nbDice;
        this.frequency  = new TreeMap<Die, Integer> (o.frequency);
    }

    public boolean inSet(Die d) {
        return frequency.get(d) != null;
    }

    public int getFrequency(Die d) {
        if(inSet(d))
            return frequency.get(d);
        else
            return 0;
    }

    public void removeAll(Die d) {
        nbDice -= getFrequency(d);
        frequency.remove(d);
    }

    public boolean diff(DiceSet o) { // true si this\o est non vide
        for(Die d : frequency.keySet())
            if(!o.inSet(d))
                return true;
        return false;
    }

    public int getValue() {
        int v = 0;
        for(Map.Entry<Die, Integer> entry : frequency.entrySet())
            v += entry.getValue() * entry.getKey().getValue();
        return v;
    }
}

