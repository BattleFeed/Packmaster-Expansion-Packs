package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.rickandmortypack.BootlegPortalFluidPower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class BootlegPortalFluid extends AbstractRickAndMortyCard {
    public static final String ID = makeID(BootlegPortalFluid.class.getSimpleName());

    public BootlegPortalFluid() {
        super(ID, 2, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.applyToSelf(new BootlegPortalFluidPower());
    }

    @Override
    public void upp() {
        upgradeBaseCost(1);
        this.upgraded = true;
    }

    @Override
    public float getTitleFontSize() {
        return 17.5f;
    }
}
