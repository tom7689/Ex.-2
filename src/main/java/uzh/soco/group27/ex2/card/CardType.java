package uzh.soco.group27.ex2.card;

public enum CardType {CLOVERLEAF(1), FIREWORKS(5), STOP(10),
    STRAIGHT(5), PLUSMINUS(5), X2(5), BONUS(25);
    public final int quantity;

    CardType(int pQuantity) {
        quantity = pQuantity;
    }
}
