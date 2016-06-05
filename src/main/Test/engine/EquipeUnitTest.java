package engine;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by valenza on 04/06/16.
 */
public class EquipeUnitTest {

    @Test
    public void testTireVide(){
        GrilleJeux gj = new GrilleJeux();
        Equipe e2 = new Equipe(Mockito.mock(GrilleJeux.class), "e2");
        Equipe e1 = new Equipe(gj, "e1");
        Assert.assertFalse(e2.tire(e1, 0, 0));
        Assert.assertFalse(e2.tire(e1, 9, 9));
    }

    @Test
    public void testTirePasVide(){
        GrilleJeux gj = new GrilleJeux();
        Equipe e2 = new Equipe(Mockito.mock(GrilleJeux.class), "e2");
        Equipe e1 = new Equipe(gj, "e1");
        e1.getGj().getCases()[5][5].setVide(false);
        Assert.assertTrue(e2.tire(e1, 5, 5));
    }

    @Test
    public void testSetPlacementEnX() throws Exception {
        GrilleJeux gj = new GrilleJeux();
        Equipe e1 = new Equipe(gj, "e1");
        PorteAvion b = new PorteAvion(0,0,4,0,e1);

        e1.gj.getCases()[0][0].setVide(true);
        e1.gj.getCases()[1][0].setVide(true);
        e1.gj.getCases()[2][0].setVide(true);
        e1.gj.getCases()[3][0].setVide(true);
        e1.gj.getCases()[4][0].setVide(true);

        Case[] c = new Case[]{gj.getCases()[0][0], gj.getCases()[1][0], gj.getCases()[2][0], gj.getCases()[3][0], gj.getCases()[4][0]};
        Assert.assertArrayEquals(c, e1.setPlacement(b, 0,0,4,0));

    }

    @Test
    public void testSetPlacementEnY() throws Exception {
        GrilleJeux gj = new GrilleJeux();
        Equipe e1 = new Equipe(gj, "e1");
        PorteAvion b = new PorteAvion(0,0,0,4,e1);

        e1.gj.getCases()[0][0].setVide(true);
        e1.gj.getCases()[0][1].setVide(true);
        e1.gj.getCases()[0][2].setVide(true);
        e1.gj.getCases()[0][3].setVide(true);
        e1.gj.getCases()[0][4].setVide(true);

        Case[] c = new Case[]{gj.getCases()[0][0], gj.getCases()[0][1], gj.getCases()[0][2], gj.getCases()[0][3], gj.getCases()[0][4]};
        Assert.assertArrayEquals(c, e1.setPlacement(b, 0,0,0,4));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = Exception.class)
    public void testSetPlacementNonAligner() throws Exception {
        GrilleJeux gj = new GrilleJeux();
        Equipe e1 = new Equipe(gj, "e1");
        PorteAvion b = new PorteAvion(0, 0, 1, 4, e1);

        thrown.expect(Exception.class);
        thrown.expectMessage("Case non alignÃ©e");
    }

    @Test(expected = Exception.class)
    public void testSetPlacementXNonVide() throws Exception {
        GrilleJeux gj = new GrilleJeux();
        Equipe e1 = new Equipe(gj, "e1");
        PorteAvion b = new PorteAvion(0, 0, 4, 0, e1);

        e1.gj.getCases()[0][0].setVide(true);
        e1.gj.getCases()[1][0].setVide(true);
        e1.gj.getCases()[3][0].setVide(true);
        e1.gj.getCases()[4][0].setVide(true);

        e1.setPlacement(b, 0,0,4,0);
        thrown.expect(Exception.class);
        thrown.expectMessage("Case 2,0 non vide");
    }

    @Test(expected = Exception.class)
    public void testSetPlacementYNonVide() throws Exception {
        GrilleJeux gj = new GrilleJeux();
        Equipe e1 = new Equipe(gj, "e1");
        PorteAvion b = new PorteAvion(0,0,0,4,e1);

        e1.gj.getCases()[0][0].setVide(true);
        e1.gj.getCases()[0][1].setVide(true);
        e1.gj.getCases()[0][3].setVide(true);
        e1.gj.getCases()[0][4].setVide(true);

        e1.setPlacement(b, 0,0,0,4);
        thrown.expect(Exception.class);
        thrown.expectMessage("Case 0,2 non vide");
    }
}