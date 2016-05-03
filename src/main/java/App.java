import engine.GrilleJeux;

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
					GrilleJeux gj = new GrilleJeux();
					//Controleur GUI ?
					//ControlGroup control = new ControlGroup(model);
				}
			});
		}

	}

