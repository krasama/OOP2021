package cz.cvut.mk.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Match {
    private Team teamOne;
    private Team teamTwo;
    private Map<Event, Team> events;

    public Match(Team teamOne, Team teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.events = new HashMap<>();
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }

    public void simulateMatch() {
        events.put(Event.start(), null);
        for (int i = 0; i < 30; i++) {
            if (random(1)==1){
                generateRandomEvent(teamOne, teamTwo);
            }
            else {
                generateRandomEvent(teamTwo, teamOne);
            }
        }
        events.put(Event.stop(), null);
    }


    public void getWinner(){
        // TODO: 25.10.2021
        System.out.println();
    }

    public void getScore(){
        // TODO: 25.10.2021
        Long scoreOne = events.entrySet()
                .stream()
                .filter(e -> EventType.GOAL.equals(e.getKey().getType()))
                .filter(t -> teamOne.equals(t.getValue()))
                .count();
        Long scoreTwo = events.entrySet()
                .stream()
                .filter(e -> EventType.GOAL.equals(e.getKey().getType()))
                .filter(t -> teamTwo.equals(t.getValue()))
                .count();
        System.out.println();
    }

    @Override
    public String toString() {
        return "Match{" +
                "teamOne=" + teamOne +
                ", teamTwo=" + teamTwo +
                '}';
    }

    public int random(int bound){
        int rnd;
        rnd = new Random().nextInt(bound);
        System.out.println(rnd);
        return rnd;
    }

    public void shootPenalty(Team team) {
        events.put(Event.penalty(), team);
        if (random(1)==1){
            events.put(Event.goal(), team);
        }
    }

    public void generateRandomEvent(Team good, Team bad) {
        switch(random(1)) {
            case 0:
                events.put(Event.goal(), good);
                break;
            case 1:
                events.put(Event.fault(), bad);
                shootPenalty(good);
                break;
        }
    }

}
