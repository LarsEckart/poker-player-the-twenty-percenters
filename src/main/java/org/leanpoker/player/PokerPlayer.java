package org.leanpoker.player;

import java.util.List;

public class PokerPlayer {

    private String name;
    private int stack;
    private String status;
    private int bet;
    private int timeUsed;
    private String version;
    private int id;
    private List<Card> hole_cards;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(int timeUsed) {
        this.timeUsed = timeUsed;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Card> getHoleCards() {
        return hole_cards;
    }

    public void setHoleCards(List<Card> cards) {
        this.hole_cards = cards;
    }

}
