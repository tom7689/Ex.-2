package uzh.soco.group27.ex2.game;

import java.io.InputStream;
import java.util.Scanner;

public class InputAsker {
    private final Scanner aScanner;

    public InputAsker (InputStream in) {
        aScanner = new Scanner(in);
    }

    public String ask () {
        return aScanner.nextLine();
    }
}
