import engine.Equipe;
import engine.GrilleJeux;
import gui.AccueilJFrame;

/**
* 
*/

/**
 * @author nicolas
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				GrilleJeux gj1 = new GrilleJeux();

				GrilleJeux gj2 = new GrilleJeux();

				Equipe equipes1 = new Equipe(gj1);
				Equipe equipes2 = new Equipe(gj2);

				Equipe[] equipes = new Equipe[] { equipes1, equipes2 };
				gj1.setEquipes(equipes);
				gj2.setEquipes(equipes);
				// Controleur GUI ?
				// ControlGroup control = new ControlGroup(model);

				AccueilJFrame accueilJFrame = new AccueilJFrame();
			}
		});
	}

}
