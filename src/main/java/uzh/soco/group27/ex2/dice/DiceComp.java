package uzh.soco.group27.ex2.dice;

import java.util.ArrayList;
import java.util.List;

public class DiceComp implements DiceRoll {
    private final List<Dice> aDices;
    private final List<Dice> selectedDices;
    private final List<DiceComp> rolledDices;
    private final List<Dice> tempDices;
    private int points;

    public DiceComp() {
        aDices = new ArrayList<>(6);
        selectedDices = new ArrayList<>(6);
        rolledDices = new ArrayList<>(6);
        tempDices = new ArrayList<>(6);

    }
    public void roll() {
        for (Dice dice : aDices) {
            dice.roll();
        }
    }
    private int getResults() {
        int aPoints = 0;
        aPoints += rolledDices.get(6).getPoints();
        aPoints += rolledDices.get(7).getPoints();
        aPoints += rolledDices.get(0).getLength() * 100;
        aPoints += rolledDices.get(4).getLength() * 50;
        return aPoints;
    }

    private boolean testPoints(List<Dice> pDices) {
        rolledDices.clear();
        for (int i = 0; i < 8; i++) {
            rolledDices.add(new DiceComp());
        }
        for (Dice dice : pDices) {
            int aNumber = dice.getPoints() - 1;
            DiceComp aDiceComp = rolledDices.get(aNumber);
            if (rolledDices.get(aNumber).getLength() == 0){
                aDiceComp.add(dice);
            } else if (rolledDices.get(aNumber).getLength() == 2){
                aDiceComp.add(dice);
                rolledDices.set(6, new Drilling(aDiceComp, aNumber));
                rolledDices.set(aNumber, new DiceComp());
            } else if (rolledDices.get(aNumber).getLength() == 5){
                aDiceComp.add(dice);
                rolledDices.set(7, new Drilling(aDiceComp, aNumber));
                rolledDices.set(aNumber, new DiceComp());
            } else {
                aDiceComp.add(dice);
            }
        }
        return getResults() > 0;
    }

    public int getPoints() {
        return points;
    }
    public void add(Dice pDice) {
        aDices.add(pDice);
    }
    @Override
    public boolean split(List<Integer> pIndices) {
        testPoints(aDices);
        for (int index : pIndices) {
            if (rolledDices.get(0).getaDices().contains(aDices.get(index)) ||
                    rolledDices.get(4).getaDices().contains(aDices.get(index)) ||
                    rolledDices.get(6).getaDices().contains(aDices.get(index)) ||
                    rolledDices.get(7).getaDices().contains(aDices.get(index))) {
                tempDices.add(aDices.get(index));
            } else return false;
        }
        if (testPoints(tempDices)) {
            selectedDices.addAll(tempDices);
            for (Dice dice : tempDices) {
                aDices.remove(dice);
            }
            points += getResults();
            tempDices.clear();
            return true;
        }
        assert false;
        return false;
    }

    /**
     *
     * @pre aDices to be rolled.
     */
    public boolean isNull() {
        if (aDices.get(0).getPoints() != 0) {
            return !testPoints(aDices);
        } else {
            return false;
        }
    }
    public boolean isTutto() {
        return selectedDices.size() == 6;
    }

    @Override
    public int getLength() {
        return aDices.size();
    }

    protected List<Dice> getaDices() {
        return aDices;
    }

    @Override
    public String toString() {
        return ""+getLength();
    }
}
