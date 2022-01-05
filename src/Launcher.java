
import presentacion.Ventana;
import logica.Operaciones;

public class Launcher {
    
    public static void main(String[] args) {
        Operaciones logica = new Operaciones();
        Ventana presentacion = new Ventana(logica);
    }

}
