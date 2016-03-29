import java.util.Map;
import java.util.HashMap;

class Pair {
    DiceSet first;
    DiceSet second;

    Pair(DiceSet first, DiceSet second) {
        this.first = first;
        this.second = second;
    }
}

class WormEater extends Intelligence {
    long factorial(long i) {
        if(i == 0) return 1;
        return i * factorial(i-1);
    }

    int binomial(long n, long k) {
        return (int)(factorial(n) / (factorial(k) * factorial(n-k)));
    }

    int nbRolls(int n) {
        return binomial(n + Die.NB_FACES - 1, n);
    }

    HashMap<DiceSet, Double>                        memo;
    HashMap<DiceSet, Boolean>                       decisionRollOrStop;
    HashMap<DiceSet, Tile>                          decisionChooseTile;
    HashMap<Pair, Die>                              decisionChooseDice;

    int firstP, secondP;

    void processFirstPlayers() {
        firstP = 0; secondP = -1;
        for(int p = 1; p < nbPlayers-1; ++p)
            if(scores[p] > scores[firstP]) {
                secondP = firstP;
                firstP = p;
            }
    }

    int failureValue() {
        return myScore - ((myTileStack.length == 0) ? 0 : myTileStack[0].getNbWorms()) - scores[firstP];
    }

    int diceValue(DiceSet dice) {
        int bestValue = failureValue();
        Tile bestDecision = null;

        if(!dice.hasWorm())
            return bestValue;

        int points = dice.getValue();

        Tile t = gameTiles.floor(new Tile(points));
        if(t != null) {
            int cand = myScore + t.getNbWorms() - scores[firstP];
            if(cand > bestValue) {
                bestValue = cand;
                bestDecision = t;
            }
        }

        for(int p = 0; p < nbPlayers-1; ++p)
            if(tileStacks[p].length != 0 && tileStacks[p][0].equals(new Tile(points))) {
                int cand = myScore + tileStacks[p][0].getNbWorms();
                if(p == firstP)
                    cand -= Math.max(scores[p] - tileStacks[p][0].getNbWorms(), (secondP == -1) ? 0 : scores[secondP]);
                else
                    cand -= scores[firstP];
                if(cand > bestValue) {
                    bestValue = cand;
                    bestDecision = tileStacks[p][0];
                }
            }

        decisionChooseTile.put(dice, bestDecision);
        return bestValue;
    }

    double transition(DiceSet dice, DiceSet roll) {
        if(dice.size() + roll.size() == Game.NB_DICE) {
            double bestValue = failureValue();
            Die bestDecision = null;
            for(int f = 1; f <= Die.NB_FACES; ++f) {
                Die d = new Die(f);
                if(roll.inSet(d) && !dice.inSet(d)) {
                    dice.addMultiple(d, roll.getFrequency(d));
                    double cand = dp(dice);
                    if(cand > bestValue) {
                        bestValue = cand;
                        bestDecision = d;
                    }
                    dice.removeAll(d);
                }
            }

            decisionChooseDice.put(new Pair(dice, roll), bestDecision);
            return bestValue;
        } else {
            double sum = 0;
            for(int i = ((roll.size() == 0) ? 1 : roll.highest().getFace()); i <= Die.NB_FACES; ++i) {
                Die d = new Die(i);
                roll.add(d);
                sum += transition(dice, roll);
                roll.remove(d);
            }
            return sum;
        }
    }

    double dp(DiceSet dice) {
        if(memo.containsKey(dice))
            return memo.get(dice);
        else if(dice.size() == Game.NB_DICE) {
            memo.put(dice, (double)diceValue(dice));
            return memo.get(dice);
        } else {
            double stop = diceValue(dice);
            DiceSet roll = new DiceSet();
            double goOn = transition(dice, roll) / nbRolls(Game.NB_DICE - dice.size());
            decisionRollOrStop.put(dice, goOn > stop);
            memo.put(dice, Math.max(stop, goOn));
            return memo.get(dice);
        }
    }

    public void gameStart() {
    }

    public void turnStart() {
        processFirstPlayers();
        DiceSet emptyDice = new DiceSet();
        dp(emptyDice);
    }

    public boolean rollOrStop(DiceSet dice) {
        return decisionRollOrStop.get(dice);
    }

    public Tile chooseTile(DiceSet dice) {
        return decisionChooseTile.get(dice);
    }

    public Die chooseDice(DiceSet dice, DiceSet roll) {
        return decisionChooseDice.get(new Pair(dice, roll));
    }

    public void turnEnd() {
        memo.clear();
        decisionRollOrStop.clear();
        decisionChooseTile.clear();
        decisionChooseDice.clear();
    }

    public void gameEnd() {
    }
}
