package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.rickandmortypack.PortalSicknessPower;
import thePackmaster.util.Wiz;

import java.util.function.Predicate;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class PortalGun extends AbstractRickAndMortyCard {
    public static final String ID = makeID(PortalGun.class.getSimpleName());

    public PortalGun() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseDamage = this.damage = 8;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.doDmg(abstractMonster, this.damage, AbstractGameAction.AttackEffect.POISON);
        if (abstractPlayer.hasPower(PortalSicknessPower.ID)) {
            Predicate<AbstractCard> zeroCostAttackPredicate = card -> 0 == card.cost && CardType.ATTACK.equals(card.type);
            AbstractCard randomZeroCostAttack = Wiz.getRandomItem(Wiz.getCardsMatchingPredicate(zeroCostAttackPredicate));
            if (randomZeroCostAttack == null) {
                // This means that there were no zero cost attacks in the card pool. Will give random 0 cost if that's the case
                randomZeroCostAttack = Wiz.getRandomItem(Wiz.getCardsMatchingPredicate(zeroCostAttackPredicate, true));
            }
            Wiz.atb(new MakeTempCardInHandAction(randomZeroCostAttack.makeCopy()));
        }
    }

    @Override
    public void upp() {
        this.upgradeDamage(3);
    }

    @Override
    public void triggerOnGlowCheck() {
        glowColor = Wiz.p().hasPower(PortalSicknessPower.ID) ? GOLD_BORDER_GLOW_COLOR : BLUE_BORDER_GLOW_COLOR;
    }
}
