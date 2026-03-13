package thePackmaster.cards.rickandmortypack;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DescriptionLine;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.actions.transmutationpack.TransmuteCardAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.packs.AbstractCardPack;
import thePackmaster.util.Wiz;

import java.util.function.Function;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class RoyALifeWellLived extends AbstractRickAndMortyCard {
    public static final String ID = makeID(RoyALifeWellLived.class.getSimpleName());

    public RoyALifeWellLived() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        AbstractCardPack newTargetPack = SpireAnniversary5Mod.getRandomPackFromCurrentPool();
        Function<AbstractCard, Boolean> cardInNewTargetPack = card -> newTargetPack.packID.equals(Wiz.getPackByCard(card).packID);
        Wiz.atb(new TransmuteCardAction(Integer.MAX_VALUE, false, null, cardInNewTargetPack));
    }

    @Override
    public void upp() {
        this.selfRetain = true;
        this.upgrade();
    }

    @Override
    public float getTitleFontSize() {
        return 16.5f;
    }
}
