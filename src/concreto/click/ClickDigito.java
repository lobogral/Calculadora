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
        String numeroDisplay = display.getText();
        if(numeroDisplay.equals("0")){                      
            numeroDisplay = "";            
        }
        numeroDisplay = numeroDisplay + textoBoton;
        String numDisplaySin0Izq = numeroDisplay.replaceAll("^0+", "0");
        display.setText(numDisplaySin0Izq);
    }

}
