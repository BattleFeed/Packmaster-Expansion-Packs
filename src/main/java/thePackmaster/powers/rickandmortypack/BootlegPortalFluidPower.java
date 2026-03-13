package thePackmaster.powers.rickandmortypack;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import thePackmaster.powers.AbstractPackmasterPower;
import thePackmaster.util.Wiz;
import thePackmaster.util.rickandmortypack.PlayerDebuffUtil;

import java.util.concurrent.atomic.AtomicInteger;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class BootlegPortalFluidPower extends AbstractPackmasterPower {
    public static final String ID = makeID(BootlegPortalFluidPower.class.getSimpleName());
    private static final PowerStrings POWER_STRINGS = CardCrawlGame.languagePack.getPowerStrings(ID);
    public static final String NAME = POWER_STRINGS.NAME;
    public static final String DESCRIPTION = POWER_STRINGS.DESCRIPTIONS[0];

    public BootlegPortalFluidPower() {
        super(ID, NAME, PowerType.BUFF, true, Wiz.p(), 1);
        this.description = DESCRIPTION;
    }

    @Override
    public void atStartOfTurn() {
        final AtomicInteger strengthToGive = new AtomicInteger(0);
        Wiz.p().powers.stream()
                .filter(PlayerDebuffUtil.POWER_IS_DEBUFF_PREDICATE)
                .forEach(power -> {
                    strengthToGive.getAndIncrement();
                    if (power.amount > 5) {
                        strengthToGive.getAndIncrement();
                    }
                });
        Wiz.atb(new ApplyPowerAction(Wiz.p(), Wiz.p(), new StrengthPower(Wiz.p(), strengthToGive.get())));
    }
}
