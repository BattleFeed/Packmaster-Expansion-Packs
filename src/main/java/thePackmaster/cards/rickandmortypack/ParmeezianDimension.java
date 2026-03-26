package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.transmutationpack.TransmuteCardAction;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class ParmeezianDimension extends AbstractRickAndMortyCard {
    public static final String ID = makeID(ParmeezianDimension.class.getSimpleName());

    public ParmeezianDimension() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseBlock = this.block = 8;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.doBlk(this);
        Wiz.atb(new TransmuteCardAction((oldCard, newCard) -> newCard.setCostForTurn(0)));
    }

    @Override
    public void upp() {
        this.upgradeBlock(3);
    }


    @Override
    public float getTitleFontSize() {
        return 16f;
    }
}
