package concreto.click;

import abstracto.logica.IntDisplay;
import abstracto.logica.Click;

public class ClickDigito implements Click{

    private final IntDisplay display;

    public ClickDigito(IntDisplay display){
        this.display = display;
    }
    
    @Override
    public void ejecutar(String textoBoton){
        String digitoAgregado = display.getText();
        if(digitoAgregado.equals("0")){                      
            digitoAgregado = "";            
        }
        digitoAgregado = digitoAgregado + textoBoton;
        display.setText(digitoAgregado);
    }

}
