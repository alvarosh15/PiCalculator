package swingworkerdone;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public class WorkerSeries extends SwingWorker<Double, Object>{

    private Panel panel;
    private double pi = 0;

    public WorkerSeries(Panel panel) {
        this.panel = panel;
    } 

    @Override
    protected Double doInBackground() throws Exception {

        pi = 0;
            
        for (int i = 0; i < panel.getIteraciones(); i++) {
            pi = pi + Math.pow(-1, i)*4/(2*i+1);
        }

        return pi;
    }
    
    @Override
    public void done() {
        try {
            panel.escribePI2(get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    } 
}
