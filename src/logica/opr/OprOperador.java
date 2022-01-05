package logica.opr;

import logica.Operaciones;
import logica.Oprimir;
import logica.IntDisplay;

public class OprOperador implements Oprimir{

    private final IntDisplay display;
    private final Operaciones operaciones;
    private final char operador;

    public OprOperador(char operador, IntDisplay display, Operaciones operaciones){
        this.display = display;
        this.operaciones = operaciones;
        this.operador = operador;
    }
    
    @Override
    public void ejecutar(){
        float numero1 = Float.parseFloat(display.getText());
        operaciones.addOperando1(numero1);
        operaciones.addOperandor(operador);
        display.setText("0");
    }
}
