package concreto.click;

import abstracto.logica.IntDisplay;
import abstracto.logica.Click;

public class ClickDEL implements Click{

    private final IntDisplay display;

    public ClickDEL(IntDisplay display){
        this.display = display;
    }
    
    @Override
    public void ejecutar(String textoBoton){
        String numDisplay = display.getText();
        numDisplay = numDisplay.substring(0, numDisplay.length()-1);
        display.setText(numDisplay);
    }

}
