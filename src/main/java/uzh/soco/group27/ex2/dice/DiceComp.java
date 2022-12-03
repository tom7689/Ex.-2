package uzh.soco.group27.ex2.dice;

import uzh.soco.group27.ex2.card.CardMode;
import uzh.soco.group27.ex2.card.Fireworks;
import uzh.soco.group27.ex2.card.PlusMinus;
import uzh.soco.group27.ex2.card.Straight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceComp{
    private final List<Dice> aDices;
    private final List<Dice> selectedDices;
    private final List<List<Dice>> rolledDices;
    private final List<Dice> tempDices;
    private final List<Dice> aDicesWithPoints;
    private final List<Dice> straightList = Arrays.asList(new Dice[6]);
    private final List<Drilling> drillingList;
    private boolean plusMinusTutto = false;
    private boolean cloverleaf = false;
    private int points;

    public DiceComp() {
        aDices = new ArrayList<>(6);
        selectedDices = new ArrayList<>(6);
        rolledDices = new ArrayList<>(6);
        tempDices = new ArrayList<>(6);
        aDicesWithPoints = new ArrayList<>(6);
        drillingList = new ArrayList<>(2);

    }
    public void roll() {
        for (Dice dice : aDices) {
            dice.roll();
        }
        testPoints(aDices);
        System.out.print("\n");
    }
    private int getResults() {
        int aPoints = 0;
        for (Drilling drilling : drillingList) {
            aPoints += drilling.getPoints();
        }
        aPoints += rolledDices.get(0).size() * 100;
        aPoints += rolledDices.get(4).size() * 50;
        return aPoints;
    }

    private boolean testPoints(List<Dice> pDices) {
        rolledDices.clear();
        drillingList.clear();
        for (int i = 0; i < 6; i++) {
            rolledDices.add(i, new ArrayList<>());
        }
        for (Dice dice : pDices) {
            int aNumber = dice.getPoints() - 1;
            List<Dice> sameNumber = rolledDices.get(aNumber);
            if (sameNumber.size() == 2){
                sameNumber.add(dice);
                drillingList.add(new Drilling(sameNumber, aNumber));
                rolledDices.set(aNumber, new ArrayList<>());
            } else {
                sameNumber.add(dice);
            }
        }
        addDicesWithPoints();
        return getResults() > 0;
    }

    private void addDicesWithPoints() {
        aDicesWithPoints.clear();
        aDicesWithPoints.addAll(rolledDices.get(0));
        aDicesWithPoints.addAll(rolledDices.get(4));
        for (Drilling drilling : drillingList) {
            aDicesWithPoints.addAll(drilling.getaDices());
        }
    }

    public int getPoints() {
        return points;
    }
    public void add(Dice pDice) {
        aDices.add(pDice);
    }

    public boolean split(List<Integer> pIndices, CardMode pCardMode) {
        if (pCardMode.getClass() == Fireworks.class) {
            testPoints(aDices);
            for (int index : pIndices) {
                tempDices.add(aDices.get(index));
            }
            if (drillingNotValid(tempDices)) {
                tempDices.clear();
                return false;
            }
            for (Dice dice : aDicesWithPoints) {
                if (!tempDices.contains(dice)) {
                    tempDices.clear();
                    System.out.println("Please select all counting dices");
                    return false;
                }
            }
            if (testPoints(tempDices)) {
                selectedDices.addAll(tempDices);
                for (Dice dice : tempDices) {
                    aDices.remove(dice);
                }
                aDicesWithPoints.clear();
                tempDices.clear();
                points += getResults();
                return true;
            }
        }
        else if (pCardMode.getClass() == Straight.class) {
            for (int index : pIndices) {
                if (straightList.get(aDices.get(index).getPoints() - 1) != null) {
                    tempDices.clear();
                    return false;
                } else {
                    tempDices.add(aDices.get(index));
                }
            }
            for (Dice dice : tempDices) {
                straightList.set(dice.getPoints() - 1, dice);
                aDices.remove(dice);
            }
            return true;
        }
        else if (pCardMode.getClass() == PlusMinus.class){
            for (int index : pIndices) {
                tempDices.add(aDices.get(index));
            }
            if (drillingNotValid(tempDices)) {
                tempDices.clear();
                return false;
            }
            if (testPoints(tempDices)) {
                selectedDices.addAll(tempDices);
                for (Dice dice : tempDices) {
                    aDices.remove(dice);
                }
                aDicesWithPoints.clear();
                tempDices.clear();
                return true;
            }
        }
        else {
            for (int index : pIndices) {
                tempDices.add(aDices.get(index));
            }
            if (drillingNotValid(tempDices)) {
                tempDices.clear();
                return false;
            }
            if (testPoints(tempDices)) {
                selectedDices.addAll(tempDices);
                for (Dice dice : tempDices) {
                    aDices.remove(dice);
                }
                aDicesWithPoints.clear();
                tempDices.clear();
                points += getResults();
                return true;
            }
        }
        assert false;
        return false;
    }

    public boolean isNull() {
        testPoints(aDices);
        return !testPoints(aDices);

    }
    public boolean isTutto() {
        for (Dice aDice : aDices) {
            if (hasNoPoints(aDice)) {
                return false;
            }
        }
        points += getResults();
        return true;
    }
    private boolean hasNoPoints(Dice pDice) {
        testPoints(aDices);
        return !aDicesWithPoints.contains(pDice);
    }
    private boolean drillingNotValid(List<Dice> tempDices) {
        List<List<Dice>> drillingControlList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            drillingControlList.add(i, new ArrayList<>());
        }
        for (Dice dice : tempDices) {
            if (dice.getPoints() - 1 != 0 && dice.getPoints() - 1 != 4) {
                List<Dice> sameNumber = drillingControlList.get(dice.getPoints() - 1);
                sameNumber.add(dice);
            }
        }
        int[] ints = new int[]{1, 2, 3, 5};
        for (int i : ints) {
            if (drillingControlList.get(i).size() != 0 && drillingControlList.get(i).size() != 3) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return aDices.size();
    }

    public List<Dice> getaDices() {
        return aDices;
    }

    /**
     * @pre dices need to be selected.
     * @return true when straight is reached.
     */
    public boolean isStraight() {
        for (int i = 0; i<6; i++) {
            if (straightList.get(i) == null) {
                return false;
            }
        }
        return true;
    }
    /**
     * @pre checks if it is not possible to get a straight before selecting dices.
     * @return true, if not possibly anymore.
     */
    public boolean isNoStraight() {
        for (Dice dice : aDices) {
            if (straightList.get(dice.getPoints()-1) == null) {
                return false;
            }
        }
        return true;
    }
    public List<Dice> getStraightList() {
        return straightList;
    }
    public void clear() {
        aDices.addAll(selectedDices);
        selectedDices.clear();
        for (int i = 0; i<6; i++) {
            if (straightList.get(i) != null && !aDices.contains(straightList.get(i))) {
                aDices.add(straightList.get(i));
                straightList.set(i, null);
            }
        }
        rolledDices.clear();
        tempDices.clear();
        aDicesWithPoints.clear();
        drillingList.clear();
    }

    public void setPointsToZero() {
        this.points = 0;
    }

    public void addBonusPoints(int bonus) {
        this.points += bonus;
    }
    public void setPlusMinusTutto() {
        plusMinusTutto = true;
        points -= getResults();
    }
    public void setPlusMinusTuttoBack() {
        this.plusMinusTutto = false;
    }
    public boolean plusMinusTutto() {
        return plusMinusTutto;
    }

    public void setCloverleaf() {
        cloverleaf = true;
    }
    public boolean isCloverleaf() {
        return cloverleaf;
    }

    @Override
    public String toString() {
        return ""+getLength();
    }
}
