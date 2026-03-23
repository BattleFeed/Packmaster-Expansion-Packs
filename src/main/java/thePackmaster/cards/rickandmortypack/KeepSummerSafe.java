package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import thePackmaster.util.Wiz;
import thePackmaster.util.rickandmortypack.PlayerDebuffUtil;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class KeepSummerSafe extends AbstractRickAndMortyCard {
    public static final String ID = makeID(KeepSummerSafe.class.getSimpleName());

    public KeepSummerSafe() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        this.baseBlock = this.block = 10;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.doBlk(this);
        if (PlayerDebuffUtil.playerHasDebuff()) {
            Wiz.atb(new DrawCardAction(2));
        }
    }

    @Override
    public void upp() {
        this.upgradeBlock(4);
    }

    @Override
    public float getTitleFontSize() {
        return 20f;
    }

    @Override
    public void triggerOnGlowCheck() {
        glowColor = PlayerDebuffUtil.playerHasDebuff() ? GOLD_BORDER_GLOW_COLOR : BLUE_BORDER_GLOW_COLOR;
    }
}
