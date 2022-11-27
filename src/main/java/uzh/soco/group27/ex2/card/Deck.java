package uzh.soco.group27.ex2.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Models a deck of 56 cards.
 */
public class Deck 
{
	private CardStack aCards;
	
	/**
	 * Creates a new deck of 56 cards, shuffled.
	 */
	public Deck()
	{
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 56 cards, and shuffles them.
	 */
	public void shuffle()
	{
		List<CardMode> cards = new ArrayList<>();
		for(int i = 1; i <= 56; i++) {
			cards.add(Card.get(i));
		}
		Collections.shuffle(cards);
		aCards = new CardStack(cards);
	}
	
	/**
	 * Places pCard on top of the deck.
	 * @param pCard The card to place on top of the deck.
	 * @pre pCard !=null
	 */
	public void push(CardMode pCard)
	{
		assert pCard != null;
		aCards.push(pCard);
	}
	
	/**
	 * Draws a card from the deck and removes the card from the deck.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public CardMode draw()
	{
		assert !isEmpty();
		return aCards.pop();
	}
	
	/**
	 * @return True iff there are no cards in the deck.
	 */
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
}
