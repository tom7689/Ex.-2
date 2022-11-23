package uzh.soco.group27.ex2.game;

import uzh.soco.group27.ex2.dice.DiceRoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private final Scanner aInput = new Scanner(System.in);

    public void selectDices(DiceRoll pDiceComp) {
        List<Integer> indices = new ArrayList<>(6);
        System.out.println("Enter dices (separated by comma) to select: ");
        while (true) {
            String aLine = aInput.nextLine();
            indices.clear();
            try {
                assert aLine.length() <= pDiceComp.getLength()*2;
                while (!aLine.isEmpty()) {
                    if (aLine.charAt(0) == ',' && aLine.length() > 1) {
                        aLine = aLine.substring(1);
                    }
                    int i = parseIndex(aLine.charAt(0))-1;
                    if (!indices.contains(i) && 0 <= i && i < pDiceComp.getLength()) {
                        indices.add(i);
                    } else {
                        System.out.println("Index already chosen. Try again");
                        indices.clear();
                        throw new IllegalArgumentException();
                    }
                    aLine = aLine.substring(1);
                }
                if (!pDiceComp.split(indices)) {
                    throw new IllegalArgumentException();
                }
                return;
            } catch (IllegalArgumentException e){
                System.out.println("Input is not valid. Try again");
            }
        }
    }

    private int parseIndex(char pChar) {

        int aIndex = Character.getNumericValue(pChar);

        if (aIndex > 6 || aIndex < 1) {
            System.out.println("Index is not valid");
            throw new IllegalArgumentException();
        }

        return aIndex;
    }
    public boolean toContinue() {
        while (true) {
            System.out.println("Press (R)oll or (E)nd your turn");
            String aLine = aInput.nextLine();
            if (aLine.equals("R")) {
                return true;
            } else if (aLine.equals("E")) {
                return false;
            }
        }
    }
}

