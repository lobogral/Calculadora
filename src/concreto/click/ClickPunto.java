package concreto.click;

import abstracto.logica.IntDisplay;
import abstracto.logica.Click;

public class ClickPunto implements Click{

    private final IntDisplay display;

    public ClickPunto(IntDisplay display){
        this.display = display;
    }
    
    @Override
    public void ejecutar(){
        String numero = display.getText();
        if(!numero.contains(".")){
            numero = numero + ".";
            display.setText(numero);            
        }
    }

    @Override
    public String getSimbolo() {
        return ".";
    }
}
