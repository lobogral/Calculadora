package logica.opr;

import logica.IntDisplay;
import logica.Oprimir;

public class OprPunto implements Oprimir{

    private final IntDisplay display;

    public OprPunto(IntDisplay display){
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
}
