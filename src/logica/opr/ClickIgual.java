package logica.opr;

import logica.Operaciones;
import logica.IntDisplay;
import logica.Click;

public class ClickIgual implements Click{

    private final IntDisplay display;
    private final Operaciones operaciones;

    public ClickIgual(IntDisplay display, Operaciones operaciones){
        this.display = display;
        this.operaciones = operaciones;
    }
    
    @Override
    public void ejecutar(){
        float numero2 = Float.parseFloat(display.getText());
        float resultado = operaciones.operar(numero2);
        display.setText("" + resultado);
    }

    @Override
    public String getSimbolo() {
        return "=";
    }
}
