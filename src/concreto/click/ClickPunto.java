package concreto.click;

import abstracto.logica.IntDisplay;
import abstracto.logica.Click;

public class ClickPunto implements Click{

    private final IntDisplay display;

    public ClickPunto(IntDisplay display){
        this.display = display;
    }

    @Override
    public void ejecutar(String textoBoton){
        String numero = display.getText();
        if(!numero.contains(textoBoton)){
            numero = numero + textoBoton;
            display.setText(numero);            
        }
    }

}