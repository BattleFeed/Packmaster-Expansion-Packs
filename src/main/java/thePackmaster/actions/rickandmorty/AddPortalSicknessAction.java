package thePackmaster.actions.rickandmorty;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import thePackmaster.powers.rickandmortypack.PortalSicknessPower;
import thePackmaster.util.Wiz;

public class AddPortalSicknessAction extends AbstractGameAction {
    public AddPortalSicknessAction(int amount) {
        this.amount = amount;
    }

    @Override
    public void update() {
        AbstractPlayer player = Wiz.p();
        if (!player.hasPower(PortalSicknessPower.ID)) {
            Wiz.applyToSelf(new PortalSicknessPower(this.amount));
        } else {
            PortalSicknessPower power = (PortalSicknessPower) player.getPower(PortalSicknessPower.ID);
            power.increasePortalSicknessAmount(this.amount);
            power.updateDescription();
        }
        this.isDone = true;
    }
}
