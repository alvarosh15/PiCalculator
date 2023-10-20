package swingworkerdone;
import java.util.Random;

import javax.swing.SwingWorker;

public class WorkerMontecarlo extends SwingWorker<Modelo, Object>{

    private Panel panel;
    private Modelo modelo;
    private static Random r = new Random();
    private double radio;
    private double x, y;

    public WorkerMontecarlo(Panel panel, Modelo modelo) {
        this.panel = panel;
        this.modelo = modelo;
    } 

    @Override
    protected Modelo doInBackground() throws Exception {

        modelo.comenzarMontecarlo();

        // Obtengo el radio del modelo
        radio = modelo.getRadio();

        // Obtengo el numero de iteraciones de la vista y calculo numeros aleatorios en el interalo [-radio, radio]
        // y los añado al modelo
        for (int i = 0; i < panel.getIteraciones(); i++) {
            x = -radio + r.nextDouble()*(2*radio);
            y = -radio + r.nextDouble()*(2*radio);
            modelo.anyadirNumero(x, y);
        }

        return modelo;
    }

    @Override
    public void done() {
        panel.escribePI1(modelo.getMontecarlo());
    } 
    
}
