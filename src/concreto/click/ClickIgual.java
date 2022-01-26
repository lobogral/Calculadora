package concreto.click;

import abstracto.logica.Operacion;
import abstracto.logica.IntDisplay;
import abstracto.logica.Click;

public class ClickIgual implements Click{

    private final IntDisplay display;
    private final Operacion operacion;

    public ClickIgual(IntDisplay display, Operacion operacion){
        this.display = display;
        this.operacion = operacion;
    }
    
    @Override
    public void ejecutar(String textoBoton){
        float numero2 = Float.parseFloat(display.getText());
        float resultado = operacion.operar(numero2);
        display.setText("" + resultado);
    }

}
