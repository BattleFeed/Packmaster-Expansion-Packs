package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class MortyGainBlockNowCard extends AbstractRickAndMortyCard {
    public static final String ID = makeID(MortyGainBlockNowCard.class.getSimpleName());

    public MortyGainBlockNowCard() {
        this(false);
    }

    public MortyGainBlockNowCard(boolean upgraded) {
        super(ID, -2, CardType.SKILL, CardRarity.SPECIAL, CardTarget.NONE);
        this.baseBlock = this.block = 10;
        if (upgraded) {
            this.upgrade();
        }
    }

    @Override
    public void onChoseThisOption() {
        Wiz.doBlk(this);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }

    @Override
    public void upp() {
        this.upgradeBlock(3);
    }
}
