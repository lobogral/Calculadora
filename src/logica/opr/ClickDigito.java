package logica.opr;

import logica.IntDisplay;
import logica.Click;

public class ClickDigito implements Click{

    private final IntDisplay display;
    private final int digitoBoton;

    public ClickDigito(int digitoBoton, IntDisplay display){
        this.display = display;
        this.digitoBoton = digitoBoton;
    }
    
    @Override
    public void ejecutar(){
        String digitoAgregado = display.getText();
        if(digitoAgregado.equals("0")){                      
            digitoAgregado = "";            
        }
        digitoAgregado = digitoAgregado + digitoBoton;
        display.setText(digitoAgregado);
    }

    @Override
    public String getSimbolo() {
        return "" + digitoBoton;
    }
}
