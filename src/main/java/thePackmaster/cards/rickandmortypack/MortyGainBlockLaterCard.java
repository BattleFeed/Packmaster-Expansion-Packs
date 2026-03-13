package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class MortyGainBlockLaterCard extends AbstractRickAndMortyCard {
    public static final String ID = makeID(MortyGainBlockLaterCard.class.getSimpleName());

    public MortyGainBlockLaterCard() {
        this(false);
    }

    public MortyGainBlockLaterCard(boolean upgraded) {
        super(ID, -2, CardType.SKILL, CardRarity.SPECIAL, CardTarget.NONE);
        this.baseBlock = this.block = 11;
        if (upgraded) {
            this.upgrade();
        }
    }

    @Override
    public void onChoseThisOption() {
        Wiz.applyToSelf(new NextTurnBlockPower(Wiz.p(), this.block));
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }

    @Override
    public void upp() {
        this.upgradeBlock(3);
    }
}
