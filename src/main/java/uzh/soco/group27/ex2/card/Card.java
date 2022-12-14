package uzh.soco.group27.ex2.card;

import java.util.ArrayList;
import java.util.List;

public final class Card
{
	private static final List<CardMode> CARDS = new ArrayList<>(56);
	
	// Create flyweight Cards
	static {

		for (int quantity = 1; quantity <= CardType.CLOVERLEAF.quantity; quantity++) {
			CARDS.add(new Cloverleaf());

		}
		for (int quantity = 1; quantity <= CardType.FIREWORKS.quantity; quantity++) {
			CARDS.add(new Fireworks());

		}
		for (int quantity = 1; quantity <= CardType.STOP.quantity; quantity++) {
			CARDS.add(new Stop());

		}
		for (int quantity = 1; quantity <= CardType.STRAIGHT.quantity; quantity++) {
			CARDS.add(new Straight());

		}
		for (int quantity = 1; quantity <= CardType.PLUSMINUS.quantity; quantity++) {
			CARDS.add(new PlusMinus());

		}
		for (int quantity = 1; quantity <= CardType.X2.quantity; quantity++) {
			CARDS.add(new X2());

		}
		for (int quantity = 1; quantity <= CardType.BONUS.quantity; quantity++) {
			for (int i = 1; i <= 5; i++) {
				CARDS.add(new Bonus(200));
				CARDS.add(new Bonus(300));
				CARDS.add(new Bonus(400));
				CARDS.add(new Bonus(500));
				CARDS.add(new Bonus(600));
			}
		}
	}

	private final CardType aType;
	private final int aId;

	private Card(CardType pType, int pId)
	{
		aType = pType;
		aId = pId;
	}
	
	public static CardMode get(int pId)
	{
		assert pId >= 0 && pId <= 55;
		return CARDS.get(pId);
	}

	@Override
	public String toString()
	{
		return aType+" "+aId;
	}
}
