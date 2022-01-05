import abstracto.presentacion.LblDisplayExt;
import abstracto.presentacion.Ventana;
import abstracto.logica.Click;
import abstracto.logica.Operaciones;
import concreto.click.ClickDigito;
import concreto.click.ClickIgual;
import concreto.click.ClickOperador;
import concreto.click.ClickPunto;
import java.awt.GridLayout;


public class Launcher {
    
    public static void main(String[] args) {
        
        LblDisplayExt lblDisplayExt = new LblDisplayExt();
        
        GridLayout gridLayout = new GridLayout(4, 4, 3, 3);
        Operaciones operaciones = new Operaciones();
        Click[] clicks = new Click[16];

        clicks[0] = new ClickDigito(7, lblDisplayExt);
        clicks[1] = new ClickDigito(8, lblDisplayExt);
        clicks[2] = new ClickDigito(9, lblDisplayExt);
        clicks[3] = new ClickOperador('/', lblDisplayExt, operaciones);
        clicks[4] = new ClickDigito(4, lblDisplayExt);
        clicks[5] = new ClickDigito(5, lblDisplayExt);
        clicks[6] = new ClickDigito(6, lblDisplayExt);
        clicks[7] = new ClickOperador('*', lblDisplayExt, operaciones);
        clicks[8] = new ClickDigito(1, lblDisplayExt);
        clicks[9] = new ClickDigito(2, lblDisplayExt);
        clicks[10] = new ClickDigito(3, lblDisplayExt);
        clicks[11] = new ClickOperador('-', lblDisplayExt, operaciones);
        clicks[12] = new ClickIgual(lblDisplayExt, operaciones);
        clicks[13] = new ClickDigito(0, lblDisplayExt);
        clicks[14] = new ClickPunto(lblDisplayExt);
        clicks[15] = new ClickOperador('+', lblDisplayExt, operaciones);        
        
        Ventana ventana = new Ventana(lblDisplayExt.getLblDisplay(),
                                      gridLayout,
                                      clicks);
    }

}
