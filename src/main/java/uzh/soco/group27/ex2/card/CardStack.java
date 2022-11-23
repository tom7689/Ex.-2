package uzh.soco.group27.ex2.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CardStack {
    ArrayList<Card> stack = new ArrayList<>();

    public void intialize(){
        for (int i = 0; i<5;i++){
            Firework F = new Firework("Firework");
            stack.add(F);
            Straight S = new Straight("Straight");
            stack.add(S);
            PlusMinus P = new PlusMinus("Plus/Minus");
            stack.add(P);
            x2 X = new x2("x2");
            stack.add(X);
            Bonus B200 = new Bonus("200",200);
            Bonus B300 = new Bonus("300",300);
            Bonus B400 = new Bonus("400",400);
            Bonus B500 = new Bonus("500",500);
            Bonus B600 = new Bonus("600",600);
            stack.add(B200);
            stack.add(B300);
            stack.add(B400);
            stack.add(B500);
            stack.add(B600);
        }
        for (int i = 0; i<10; i++){
            Stop S = new Stop("Stop");
            stack.add(S);
        }
        Cloverleaf C = new Cloverleaf("Cloverleaf");
        stack.add(C);
        shuffle();

    }
    public void shuffle(){
        Collections.shuffle(stack);
    }
    public void print(){
        System.out.println(stack);
    }
}
