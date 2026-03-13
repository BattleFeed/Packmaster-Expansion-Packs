package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.actions.rickandmorty.AddPortalSicknessAction;
import thePackmaster.util.Wiz;

import java.util.ArrayList;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class MortysAdventureCard extends AbstractRickAndMortyCard {
    public static final String ID = makeID(MortysAdventureCard.class.getSimpleName());

    public MortysAdventureCard() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE);
        this.baseBlock = this.block = 10;               //block now
        this.baseMagicNumber = this.magicNumber = 11;   //block later
        this.baseSecondMagic = this.secondMagic = 3;    //portal sickness
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.atb(new AddPortalSicknessAction(secondMagic));
        ArrayList<AbstractCard> choices = new ArrayList<>();
        MortyGainBlockNowCard gainBlockNowCard = new MortyGainBlockNowCard(this.upgraded);
        gainBlockNowCard.applyPowers();
        MortyGainBlockLaterCard gainBlockLaterCard = new MortyGainBlockLaterCard(this.upgraded);
        gainBlockLaterCard.applyPowers();
        choices.add(gainBlockNowCard);
        choices.add(gainBlockLaterCard);
        Wiz.atb(new ChooseOneAction(choices));
    }

    @Override
    public void upp() {
        this.upgradeBlock(3);
        this.upgradeMagicNumber(3);
        this.upgradeSecondMagic(-1);
    }

    @Override
    public float getTitleFontSize() {
        return 15f;
    }

    @Override
    public void applyPowersToBlock() {
        super.applyPowersToBlock();

        int originalBaseBlock = baseBlock;
        int originalBlock = block;
        boolean originalIsBlockModified = isBlockModified;

        baseBlock = baseMagicNumber;
        super.applyPowersToBlock();
        magicNumber = block;
        isMagicNumberModified = isBlockModified;

        baseBlock = originalBaseBlock;
        block = originalBlock;
        isBlockModified = originalIsBlockModified;
    }
}
