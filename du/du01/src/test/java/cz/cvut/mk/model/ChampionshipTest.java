package cz.cvut.mk.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ChampionshipTest {

    @Test
    public void generateMatches_lessThanTwoTeamsRegistered_throwIllegalStateException(){
        Championship championship = new Championship();
        Assertions.assertThrows(IllegalStateException.class, championship::generateMatches);
    }

    @Test
    public void generateMatches_moreThanTwoTeamsRegistered_matchesGeneratedOk(){

        Team sparta = new Team("Sparta");
        Championship championship = new Championship();
        championship.registerTeam(sparta);
        championship.registerTeam(new Team("Slavia"));
        championship.generateMatches();

        Assertions.assertEquals(1, championship.getMatches().size());

        int spartaCountMatches = 0;
        for(Match match: championship.getMatches()){
            if(match.getTeamOne().equals(sparta) || match.getTeamTwo().equals(sparta)){
                spartaCountMatches++;
            }
        }
        Assertions.assertEquals(championship.getTeams().size() - 1, spartaCountMatches);
    }

    /*@Test
    public void matchGenerator_XYZ_Test(){
        Championship championship = new Championship();
        MatchGenerator mock = Mockito.mock(MatchGenerator.class);
        Mockito.when(mock.XYZ()).thenReturn(0);

        championship.setMatchGenerator(mock);

        Assertions.assertThrows(IllegalStateException.class, ()-> championship);
    }*/

}
