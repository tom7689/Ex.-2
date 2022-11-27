package uzh.soco.group27.ex2.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardStack implements Iterable<CardMode>{
    private final List<CardMode> aCards;

    /**
     * Creates an empty CardStack.
     */
    public CardStack()
    {
        aCards = new ArrayList<>();
    }

    public CardStack(Iterable<CardMode> pCards)
    {
        this();
        for( CardMode card : pCards )
        {
            aCards.add(card);
        }
    }

    public void push(CardMode pCard)
    {
        assert pCard != null && !aCards.contains(pCard);
        aCards.add(pCard);
    }

    public CardMode pop()
    {
        assert !isEmpty();
        return aCards.remove(aCards.size()-1);
    }

    public boolean isEmpty()
    {
        return aCards.size() == 0;
    }

    @Override
    public Iterator<CardMode> iterator()
    {
        return aCards.iterator();
    }
}
