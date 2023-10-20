package swingworkerdone;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Principal {

	public static void crearGUI() {
		JFrame ventana = new JFrame("Aplicacion PI");
		Panel panel = new Panel();
		Modelo modelo = new Modelo();
		Controlador ctr = new Controlador(panel, modelo);
		panel.setControlador(ctr);
		ventana.setContentPane(panel);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				crearGUI();
			}
		});


	}

}