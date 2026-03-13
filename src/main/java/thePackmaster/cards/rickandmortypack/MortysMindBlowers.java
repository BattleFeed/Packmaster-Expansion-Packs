package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.pixiepack.DrawSpecificCardAction;
import thePackmaster.actions.rickandmorty.AddPortalSicknessAction;
import thePackmaster.util.Wiz;
import thePackmaster.util.rickandmortypack.PlayerDebuffUtil;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class MortysMindBlowers extends AbstractRickAndMortyCard {
    public static final String ID = makeID(MortysMindBlowers.class.getSimpleName());

    public MortysMindBlowers() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        this.baseMagicNumber = this.magicNumber = 1;
        this.baseSecondMagic = this.secondMagic = 10;
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        abstractPlayer.powers.stream()
                .filter(PlayerDebuffUtil.POWER_IS_DEBUFF_PREDICATE)
                .forEach(power -> Wiz.atb(new RemoveSpecificPowerAction(abstractPlayer, abstractPlayer, power)));
        for (int i = 0; i < this.magicNumber; i++) {
            AbstractCard nextCard = Wiz.p().drawPile.getTopCard();
            nextCard.setCostForTurn(0);
            Wiz.atb(new DrawSpecificCardAction(nextCard));
        }
        Wiz.atb(new AddPortalSicknessAction(this.secondMagic));
    }

    @Override
    public void upp() {
        this.upgradeMagicNumber(1);
        this.upgradeSecondMagic(-4);
    }

    @Override
    public float getTitleFontSize() {
        return 16.75f;
    }
}
