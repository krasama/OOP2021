package cz.cvut.mk.model;

import java.util.*;


public class Match {
    private Team teamOne;
    private Team teamTwo;
    private HashMap<Event, Team> events;
    private HashMap<Team, Integer> score;

    public Match(Team teamOne, Team teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.events = new HashMap<>();
        this.score = new HashMap<>();
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

        for (int i = 0; i < 15; i++) {
            if (random(2)==1){
                generateRandomEvent(teamOne, teamTwo);
            }
            else {
                generateRandomEvent(teamTwo, teamOne);
            }
        }
        events.put(Event.stop(), null);
    }


    public void getWinner(){
        System.out.println(List.of(score));

        /*score.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);*/

        Object firsTeam = score.keySet().toArray()[0];
        Object firsTeamScore = score.get(firsTeam);
        System.out.print("Výherný tým je:"+ firsTeam + "\n");
        System.out.println("Body výherního týmu jsou :"+ firsTeamScore);
    }

    public void getScore(){

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

        System.out.println(teamOne);
        System.out.println(scoreOne);
        System.out.println(teamTwo);
        System.out.println(scoreTwo);


        if (scoreOne>scoreTwo){
            if (score.containsKey(teamOne)){
                score.put(teamOne, score.get(teamOne) + 3);
            }
            else{
                score.put(teamOne, 3);
           }
        }
        else if (scoreOne<scoreTwo){
            if (score.containsKey(teamTwo)){
                score.put(teamTwo, score.get(teamTwo) + 3);
            }
            else{
                score.put(teamTwo, 3);
            }
        }
        else {
            if (score.containsKey(teamOne) && score.containsKey(teamTwo)){
                score.put(teamOne, score.get(teamOne) + 1);
                score.put(teamTwo, score.get(teamTwo) + 1);
            }
            else if(score.containsKey(teamOne)){
                score.put(teamOne, score.get(teamOne) + 1);
                score.put(teamTwo, 1);
            }
            else if(score.containsKey(teamTwo)){
                score.put(teamOne, 1);
                score.put(teamTwo, score.get(teamTwo) + 1);
            }
            else{
                score.put(teamOne, 1);
                score.put(teamTwo, 1);
            }
        }
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
        if (random(2)==1){
            events.put(Event.goal(), team);
        }
    }

    public void generateRandomEvent(Team good, Team bad) {
        switch(random(2)) {
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
