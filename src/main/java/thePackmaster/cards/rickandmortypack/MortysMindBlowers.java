package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.pixiepack.DrawSpecificCardAction;
import thePackmaster.powers.rickandmortypack.PortalSicknessPower;
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
        Wiz.atb(new RemoveDebuffsAction(abstractPlayer));
        Wiz.atb(new DrawCardAction(this.magicNumber, new AbstractGameAction() {
            @Override
            public void update() {
                for (AbstractCard c : DrawCardAction.drawnCards) {
                    c.setCostForTurn(0);
                    c.isCostModifiedForTurn = true;
                    c.superFlash();
                }
                this.isDone = true;
            }
        }));
        Wiz.applyToSelf(new PortalSicknessPower(this.secondMagic));
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
