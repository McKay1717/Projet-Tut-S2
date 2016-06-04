package engine;

import org.mockito.Mockito;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    //PROBLEME  : la fonction renvoie une taille de 0 ?
    @Test
    public void testSetPlacement() throws Exception {
        GrilleJeux gj = new GrilleJeux();
        Equipe e1 = new Equipe(gj, "e1");
        PorteAvion b = new PorteAvion(0,0,4,0,e1);
        Case[] c = new Case[]{gj.getCases()[0][0], gj.getCases()[1][0], gj.getCases()[2][0], gj.getCases()[3][0], gj.getCases()[4][0]};
        Assert.assertArrayEquals(c, e1.setPlacement(b, 0,0,4,0));

    }

}
