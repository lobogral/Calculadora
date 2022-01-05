package logica.opr;

import logica.Operaciones;
import logica.Oprimir;
import logica.IntDisplay;

public class OprIgual implements Oprimir{

    private final IntDisplay display;
    private final Operaciones operaciones;

    public OprIgual(IntDisplay display, Operaciones operaciones){
        this.display = display;
        this.operaciones = operaciones;
    }
    
    @Override
    public void ejecutar(){
        float numero2 = Float.parseFloat(display.getText());
        float resultado = operaciones.operar(numero2);
        display.setText("" + resultado);
    }
}
