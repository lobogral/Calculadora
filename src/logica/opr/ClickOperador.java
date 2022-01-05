package logica.opr;

import logica.Operaciones;
import logica.IntDisplay;
import logica.Click;

public class ClickOperador implements Click{

    private final IntDisplay display;
    private final Operaciones operaciones;
    private final char operador;

    public ClickOperador(char operador, IntDisplay display, Operaciones operaciones){
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

    @Override
    public String getSimbolo() {
        return "" + operador;
    }
}
