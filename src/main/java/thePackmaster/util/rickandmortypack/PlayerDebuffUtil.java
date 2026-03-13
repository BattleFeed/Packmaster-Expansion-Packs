package thePackmaster.util.rickandmortypack;

import com.megacrit.cardcrawl.powers.AbstractPower;
import thePackmaster.util.Wiz;

import java.util.function.Predicate;

public class PlayerDebuffUtil {
    public static final Predicate<AbstractPower> POWER_IS_DEBUFF_PREDICATE = power ->
            AbstractPower.PowerType.DEBUFF.equals(power.type);

    public static boolean playerHasDebuff() {
        return Wiz.p().powers.stream().anyMatch(POWER_IS_DEBUFF_PREDICATE);
    }
}
