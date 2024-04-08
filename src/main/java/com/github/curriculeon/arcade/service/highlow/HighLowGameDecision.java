package com.github.curriculeon.arcade.service.highlow;

import com.github.curriculeon.arcade.lib.game.cardgame.utils.DiscardPile;
import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.lib.game.utils.GameDecisionInterface;
import com.github.curriculeon.arcade.lib.utils.InputOutputConsoleInterface;
import com.github.curriculeon.arcade.lib.utils.Pair;

import java.util.function.BiConsumer;

/**
 * Created by leon on 6/24/2020.
 */
public enum HighLowGameDecision implements GameDecisionInterface<HighLowGame, HighLowPlayer> {
    VIEW_HAND((game, player) -> {
        game.getConsole().println(player.getHand().toString());
    }),

    VIEW_DISCARD_PILE((game, player) -> {
        game.getConsole().println(game
                .getDiscardPile()
                .getPlayerAndCardAtIndex(0)
                .getValue()
                .toString());
    }),

    DECIDE_HIGH((game, player) -> {
        player.setDecision(HighLowPlayer.DecisionState.HIGH);
        final String infoMessage = "[ %s ] has claimed their hand-value is `HIGHER` than the current face-up value of [ %s ]";
        final CardInterface currentFaceUpCard = game.getCurrentFaceUpValue();
        game
                .getConsole()
                .println(infoMessage, player.getName(), currentFaceUpCard);
        game
                .getDiscardPile()
                .add(player, player.getCard());
    }),


    DECIDE_LOW((game, player) -> {
        player.setDecision(HighLowPlayer.DecisionState.LOW);
        final String infoMessage = "[ %s ] has claimed their hand-value is `LOWER` than the current face-up value of [ %s ]";
        final CardInterface currentFaceUpCard = game.getCurrentFaceUpValue();
        game
                .getConsole()
                .println(infoMessage, player.getName(), currentFaceUpCard);
        game
                .getDiscardPile()
                .add(player, player.getCard());
    }),

    DECIDE_BLUFF((game, player) -> {
        player.setDecision(HighLowPlayer.DecisionState.BLUFF);
        final InputOutputConsoleInterface console = game.getConsole();
        final String claimMessage = "[ %s ] believes the previous player, [ %s ], did not have a hand-state of [ %s ]";
        final String previousCardInfoMessage = "Previous-card was [ %s ]";
        final String previousPreviousCardInfoMessage = "Previous-previous-card was [ %s ]";
        final String claimAffirmationMessage = "[ %s ]'s claim that [ %s ] did not have a hand-state of [ %s ] was [ %s ]";
        final DiscardPile<HighLowPlayer> discardPile = game.getDiscardPile();
        final Pair<HighLowPlayer, CardInterface> previousPlayerAndCard = discardPile.getPlayerAndCardAtIndex(0);
        final HighLowPlayer previousPlayer = previousPlayerAndCard.getKey();
        final CardInterface previousCard = previousPlayerAndCard.getValue();
        final CardInterface previousPreviousCard = discardPile.getPlayerAndCardAtIndex(1).getValue();
        final boolean previousPlayerDecidedHigh = previousPlayer.getDecision().equals(HighLowPlayer.DecisionState.HIGH);
        final boolean previousPlayerDecidedLow = previousPlayer.getDecision().equals(HighLowPlayer.DecisionState.LOW);
        final boolean previousPlayerHasHigh = previousPreviousCard.getValue() < previousCard.getValue();
        final boolean previousPlayerHasLow = previousPreviousCard.getValue() > previousCard.getValue();
        final boolean previousPlayerClaimIsTrue = (
                previousPlayerDecidedHigh && previousPlayerHasHigh) || (
                previousPlayerDecidedLow && previousPlayerHasLow);

        console.println(claimMessage,
                previousPlayer.getName(),
                player.getName(),
                previousPlayer.getDecision().name());

        console.println(previousCardInfoMessage, previousCard);
        console.println(previousPreviousCardInfoMessage, previousPreviousCard);
        console.print(claimAffirmationMessage, player.getName(), previousPlayer.getName(), previousPlayer.getDecision(), previousPlayerClaimIsTrue);

        if (previousPlayerClaimIsTrue) {
            previousPlayer.increasePoints(1);
            player.decreasePoints(1);
        }
    });

    private final BiConsumer<HighLowGame, HighLowPlayer> operation;

    HighLowGameDecision(final BiConsumer<HighLowGame, HighLowPlayer> operation) {
        this.operation = operation;
    }

    @Override
    public BiConsumer<HighLowGame, HighLowPlayer> getProcedure() {
        return operation;
    }
}
