package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.rickandmorty.AddPortalSicknessAction;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class PickleRick extends AbstractRickAndMortyCard {
    public static final String ID = makeID(PickleRick.class.getSimpleName());

    public PickleRick() {
        super(ID, 2, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        this.baseDamage = this.damage = 20;
        this.baseMagicNumber = this.magicNumber = 5;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.doDmg(abstractMonster, this.damage, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        Wiz.atb(new AddPortalSicknessAction(this.magicNumber));
    }

    @Override
    public void upp() {
        this.upgradeDamage(6);
    }
}
