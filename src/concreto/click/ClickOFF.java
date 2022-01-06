package concreto.click;

import abstracto.logica.Click;

public class ClickOFF implements Click{
    
    @Override
    public void ejecutar(String textoBoton){
        System.exit(0);
    }

}
