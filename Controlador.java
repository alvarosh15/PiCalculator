package swingworkerdone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private Panel panel;
	private Modelo modelo;

	public Controlador(Panel panel, Modelo modelo) {
		this.panel = panel;
		this.modelo = modelo;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Panel.comenzar())) {

            WorkerMontecarlo workerMontecarlo = new WorkerMontecarlo(panel, modelo);

            WorkerSeries workerSeries = new WorkerSeries(panel);

            workerMontecarlo.execute();
            workerSeries.execute();
            
        }
        
    }
    
}
