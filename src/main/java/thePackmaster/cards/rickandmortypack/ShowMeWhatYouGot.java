package thePackmaster.cards.rickandmortypack;

import com.evacipated.cardcrawl.mod.stslib.actions.common.AllEnemyApplyPowerAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import thePackmaster.actions.rickandmorty.AddPortalSicknessAction;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class ShowMeWhatYouGot extends AbstractRickAndMortyCard {
    public static final String ID = makeID(ShowMeWhatYouGot.class.getSimpleName());

    public ShowMeWhatYouGot() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.ALL);
        this.baseDamage = this.damage = 5;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        for (int i = 0; i < 4; i++) {
            Wiz.doAllDmg(this, AbstractGameAction.AttackEffect.BLUNT_HEAVY, false);
        }
        Wiz.atb(new AllEnemyApplyPowerAction(abstractPlayer, 3, (q) -> new WeakPower(q, 3, false)));
        Wiz.atb(new AddPortalSicknessAction(5));
    }

    @Override
    public void upp() {
        this.upgradeDamage(2);
    }

    @Override
    public float getTitleFontSize() {
        return 13f;
    }
}
