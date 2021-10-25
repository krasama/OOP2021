package cz.cvut.mk.model;

import java.util.Random;

public class Match {
    private Team teamOne;
    private Team teamTwo;

    public Match(Team teamOne, Team teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
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
        Event.start();
        for (int i = 0; i < 30; i++) {
            if (random(1)==1){
                simulation();
            }
            else {
                simulation();
            }
        }
        Event.stop();
    }


    public void getWinner(){
        // TODO: 25.10.2021  
        System.out.println();
    }

    public void getScore(){
        // TODO: 25.10.2021  
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
    public void simulation(){
        switch(random(1)) {
            case 0:
                Event.goal();
                break;
            case 1:
                Event.faul();
                Event.penalty();

                if (random(1)==1){
                    Event.goal();
                }
                break;
        }
    }

}
