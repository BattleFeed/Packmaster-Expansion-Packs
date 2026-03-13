package thePackmaster.powers.rickandmortypack;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import thePackmaster.powers.AbstractPackmasterPower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class PortalSicknessPower extends AbstractPackmasterPower {
    public static final String ID = makeID(PortalSicknessPower.class.getSimpleName());
    private static final PowerStrings POWER_STRINGS = CardCrawlGame.languagePack.getPowerStrings(ID);
    public static final String NAME = POWER_STRINGS.NAME;
    public static final String FUTURE_TURN_DESCRIPTION_TEMPLATE = POWER_STRINGS.DESCRIPTIONS[0];
    public static final String THIS_TURN_DESCRIPTION_TEMPLATE = POWER_STRINGS.DESCRIPTIONS[1];

    public PortalSicknessPower(int amount) {
        super(ID, NAME, PowerType.DEBUFF, true, Wiz.p(), amount);
        this.isTwoAmount = true;
        this.amount2 = 3;
        updateDescription();
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        if (this.amount2 == 1) {
            Wiz.att(new DamageAction(Wiz.p(), new DamageInfo(Wiz.p(), this.amount)));
        }
        this.amount2 -= 1;
        if (this.amount2 == 0) {
            this.removeThis();
        } else {
            this.updateDescription();
        }
    }

    @Override
    public void updateDescription() {
        this.description = this.amount2 == 1 ?
                String.format(THIS_TURN_DESCRIPTION_TEMPLATE, this.amount) :
                String.format(FUTURE_TURN_DESCRIPTION_TEMPLATE, this.amount, this.amount2);
    }

    public void increasePortalSicknessAmount(int amount) {
        this.amount += amount;
        this.updateDescription();
    }
}
