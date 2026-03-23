package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import thePackmaster.powers.rickandmortypack.PortalSicknessPower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class WubbaLubbaDubDub extends AbstractRickAndMortyCard {
    public static final String ID = makeID(WubbaLubbaDubDub.class.getSimpleName());

    public WubbaLubbaDubDub() {
        super(ID, 0, CardType.SKILL, CardRarity.COMMON, CardTarget.ENEMY);
        this.baseMagicNumber = this.magicNumber = 2;
        this.baseSecondMagic = this.secondMagic = 6;
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.applyToEnemy(abstractMonster, new VulnerablePower(abstractMonster, this.magicNumber, false));
        Wiz.applyToEnemy(abstractMonster, new WeakPower(abstractMonster, this.magicNumber, false));
        Wiz.applyToSelf(new PortalSicknessPower(this.secondMagic));
    }

    @Override
    public void upp() {
        this.upgradeMagicNumber(1);
    }

    @Override
    public float getTitleFontSize() {
        return 16.5f;
    }

}
