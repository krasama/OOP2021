package cz.cvut.mk;

import cz.cvut.mk.model.Championship;
import cz.cvut.mk.model.Team;

public class Playground {

    public void play() {
        championship();
    }

    public void championship(){
        Team team = new Team("Sparta");
        Team team2 = new Team("Slavia");
        Team team3 = new Team("Sigma");
        Team team4 = new Team("Viktoria");

        Championship championship = new Championship();
        championship.registerTeam(team);
        championship.registerTeam(team2);
        championship.registerTeam(team3);
        championship.registerTeam(team4);

        championship.generateMatches();
        System.out.println();
        championship.simulateMatches();
    }

/*
    public void equals(){
        Team team = new Team("Sparta");

        Team team2 = new Team("Slavia");
        if(team.equals(team2)){
            System.out.println("tymy jsou stejne");
        }else{
            System.out.println("tymy nejsou stejne");
        }
    }*/

    /*public void random(){
        System.out.println(new Random().nextInt(90));
        int lower = 5;
        System.out.println(new Random().nextInt(10 - lower) + lower);

    }/*

    public void eventEnum(){
        Event event = new Event();
        event.setType(EventType.START);

        if(event.getType() == EventType.START){
            System.out.println("event je typu start");
        }
        System.out.println(event);

    }

    public void exception() {
        throw new IllegalStateException("ajaj, nastala chyba");
    }*/
}
