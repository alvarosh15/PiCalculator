package swingworkerdone;

public class Modelo {
    
    private final double radio = 1;
    private double dentroCirculo = 0;
    private double total = 0; 

    public double getRadio() {
        return radio;
    }

    public void comenzarMontecarlo() {
        dentroCirculo = 0;
        total = 0;
    }

    public void anyadirNumero(double x, double y) {
        if(x*x + y*y < radio*radio) {
            dentroCirculo ++;
            total ++;
        } else {
            total ++;
        }
    }

    public double getMontecarlo() {
        return 4*dentroCirculo/total;
    }

}
