package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Player {

    private static final Logger log = getLogger(Player.class);
    static final String VERSION = "8";

    public static int betRequest(JsonNode request) {
//        log.info("betRequest: {}", request);
        try {
            ObjectMapper objectMapper = new ObjectMapper()
                    .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            var betRequest = objectMapper.readValue(request.toString(), BetRequest.class);
            return playPoker(betRequest);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return 0;
        }
    }

    private static int playPoker(BetRequest betRequest) {
        var player = betRequest.getPlayers().get(betRequest.getInAction());

        var card1 = player.getHoleCards().get(0);
        var card2 = player.getHoleCards().get(1);


        log.info("card1: {}, card2: {}", card1, card2);

        // If we have a pair, go all in.
        if (card1.getRank().equals(card2.getRank())) {
            log.info("We have a pair - going all in!");
            return 1000;
        }

        // If we have a high card, check or pay minimum buy-in.
        if (card1.getRank().equals("A") || card2.getRank().equals("A")) {
            log.info("We have a high card - checking or paying minimum buy-in.");
            return Math.max(betRequest.getCurrentBuyIn() - player.getBet(), betRequest.getMinimumRaise());
        }

        // If we pay the big blind, call once.
        if (player.getBet() == betRequest.getBigBlind()) {
            log.info("We pay the big blind - calling once.");
            return betRequest.getCurrentBuyIn() - player.getBet();
        }

        return 0;
    }

    public static void showdown(JsonNode game) {
    }
}
