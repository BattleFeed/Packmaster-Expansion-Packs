package thePackmaster.packs;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.rickandmortypack.*;

import java.util.ArrayList;

public class RickAndMortyPack extends AbstractCardPack {
    public static final String ID = SpireAnniversary5Mod.makeID(RickAndMortyPack.class.getSimpleName());
    private static final UIStrings UI_STRINGS = CardCrawlGame.languagePack.getUIString(ID);
    public static final String NAME = UI_STRINGS.TEXT[0];
    public static final String DESC = UI_STRINGS.TEXT[1];
    public static final String AUTHOR = UI_STRINGS.TEXT[2];

    public RickAndMortyPack() {
        super(ID, NAME, DESC, AUTHOR, new PackSummary(3, 2, 3, 4, 3));
        hatHidesHair = true;
    }

    @Override
    public ArrayList<String> getCards() {
        ArrayList<String> cards = new ArrayList<>();
        cards.add(KeepSummerSafe.ID);
        cards.add(MortysMindBlowers.ID);
        cards.add(ShowMeWhatYouGot.ID);
        cards.add(BootlegPortalFluid.ID);
        cards.add(ParmeezianDimension.ID);
        cards.add(RoyALifeWellLived.ID);
        cards.add(PortalGun.ID);
        cards.add(MortysAdventureCard.ID);
        cards.add(PickleRick.ID);
        cards.add(WubbaLubbaDubDub.ID);
        return cards;
    }
}
