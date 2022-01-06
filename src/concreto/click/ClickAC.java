package concreto.click;

import abstracto.logica.IntDisplay;
import abstracto.logica.Click;

public class ClickAC implements Click{

    private final IntDisplay display;

    public ClickAC(IntDisplay display){
        this.display = display;
    }
    
    @Override
    public void ejecutar(String textoBoton){
        display.setText("");
    }

}
