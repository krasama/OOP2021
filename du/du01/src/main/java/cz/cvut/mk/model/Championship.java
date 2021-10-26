package cz.cvut.mk.model;

import java.util.ArrayList;

public class Championship {

    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Match> matches = new ArrayList<>();
    /*MatchGenerator matchGenerator = new MatchGenerator();
    public void setMatchGenerator(MatchGenerator matchGenerator) {
        this.matchGenerator = matchGenerator;
    }*/

    public void registerTeam(Team team) {
        teams.add(team);
    }

    public void generateMatches() {

        /*int number = matchGenerator.XYZ();
        if (number < 1){
            throw new IllegalStateException();
        }*/

        if (this.teams.size() < 2) {
            throw new IllegalStateException("less than two team registered");
        }
        for (Team i : teams) {
            for (Team j : teams) {
                if (!i.equals(j)) {
                    matches.add(new Match(i, j));
                }
            }
        }
    }

    public void simulateMatches() {
        for (Match match : this.matches) {
            match.simulateMatch();
            match.getScore();
            match.getWinner();
        }
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }
}
