package thePackmaster.cards.rickandmortypack;

import thePackmaster.cards.AbstractPackmasterCard;

public abstract class AbstractRickAndMortyCard extends AbstractPackmasterCard {
    public AbstractRickAndMortyCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target) {
        super(cardID, cost, type, rarity, target, "rickandmorty", "rickandmorty/orb.png");
    }
}
