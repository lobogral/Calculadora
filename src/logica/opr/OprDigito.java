package logica.opr;

import logica.Oprimir;
import logica.IntDisplay;

public class OprDigito implements Oprimir{

    private final IntDisplay display;
    private final int digitoBoton;

    public OprDigito(int digitoBoton, IntDisplay display){
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
}
