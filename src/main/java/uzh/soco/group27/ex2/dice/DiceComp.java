package uzh.soco.group27.ex2.dice;

import uzh.soco.group27.ex2.card.CardMode;
import uzh.soco.group27.ex2.card.Fireworks;
import uzh.soco.group27.ex2.card.Straight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DiceComp{
    private final List<Dice> aDices;
    private final List<Dice> selectedDices;
    private final List<DiceComp> rolledDices;
    private final List<Dice> tempDices;
    private final List<Dice> aDicesWithPoints;
    private int points;

    public DiceComp() {
        aDices = new ArrayList<>(6);
        selectedDices = new ArrayList<>(6);
        rolledDices = new ArrayList<>(6);
        tempDices = new ArrayList<>(6);
        aDicesWithPoints = new ArrayList<>(6);
    }
    public void roll() {
        for (Dice dice : aDices) {
            dice.roll();
        }
        System.out.print("\n");
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
        addDicesWithPoints();
        return getResults() > 0;
    }

    private void addDicesWithPoints() {
        aDicesWithPoints.clear();
        aDicesWithPoints.addAll(rolledDices.get(0).getaDices());
        aDicesWithPoints.addAll(rolledDices.get(4).getaDices());
        aDicesWithPoints.addAll(rolledDices.get(6).getaDices());
        aDicesWithPoints.addAll(rolledDices.get(7).getaDices());
    }

    public int getPoints() {
        return points;
    }
    public void add(Dice pDice) {
        aDices.add(pDice);
    }

    public boolean split(List<Integer> pIndices, CardMode pCardMode) {
        tempDices.clear();
        if (pCardMode.getClass() == Fireworks.class) {
            for (int index : pIndices) {
                if (hasPoints(aDices.get(index)) && !tempDices.contains(aDices.get(index))) {
                    tempDices.add(aDices.get(index));
                } else return false;
            }
            if (testPoints(tempDices) && isComplete()) {
                selectedDices.addAll(tempDices);
                for (Dice dice : tempDices) {
                    aDices.remove(dice);
                }
                points += getResults();
                return true;
            }
        }
        else if (pCardMode.getClass() == Straight.class) {
            for (int index : pIndices) {
                tempDices.add(aDices.get(index));
            }
            for (Dice dice : tempDices) {
                if (!selectedDices.contains(dice)) {
                    selectedDices.set(dice.getPoints(), dice);
                } else return false;
            } return true;
        }
        else {
            for (int index : pIndices) {
                if (hasPoints(aDices.get(index)) && !tempDices.contains(aDices.get(index))) {
                    tempDices.add(aDices.get(index));
                } else return false;
            }
            if (testPoints(tempDices)) {
                selectedDices.addAll(tempDices);
                for (Dice dice : tempDices) {
                    aDices.remove(dice);
                }
                points += getResults();
                return true;
            }
        }
        assert false;
        return false;
    }

    public boolean isNull() {
        if (aDices.get(0).getPoints() != 0) {
            return !testPoints(aDices);
        } else {
            return false;
        }
    }
    public boolean isTutto() {
        for (Dice aDice : aDices) {
            if (!hasPoints(aDice)) {
                return false;
            }
        }
        points += getResults();
        return true;
    }
    private boolean hasPoints(Dice pDice) {
        return rolledDices.get(0).getaDices().contains(pDice) ||
                rolledDices.get(4).getaDices().contains(pDice) ||
                rolledDices.get(6).getaDices().contains(pDice) ||
                rolledDices.get(7).getaDices().contains(pDice);
    }

    public int getLength() {
        return aDices.size();
    }

    protected List<Dice> getaDices() {
        return aDices;
    }

    public boolean isComplete() {
        return new HashSet<>(tempDices).containsAll(aDicesWithPoints);
    }

    public boolean isStraight() {
        return selectedDices.size() == 6;
    }
    public boolean isNoStraight() {
        for (Dice dice : aDices) {
            try {
                if (selectedDices.get(dice.getPoints()) == null) {
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            }
        }
        return true;
    }
    public void clear() {
        aDices.addAll(selectedDices);
        selectedDices.clear();
        rolledDices.clear();
        tempDices.clear();
        aDicesWithPoints.clear();
        points = 0;
    }

    @Override
    public String toString() {
        return ""+getLength();
    }
}
