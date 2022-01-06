package concreto.click;

import abstracto.logica.Operaciones;
import abstracto.logica.IntDisplay;
import abstracto.logica.Click;

public class ClickOperador implements Click{

    private final IntDisplay display;
    private final Operaciones operaciones;

    public ClickOperador(IntDisplay display, Operaciones operaciones){
        this.display = display;
        this.operaciones = operaciones;
    }
    
    @Override
    public void ejecutar(String textoBoton){
        float numero1 = Float.parseFloat(display.getText());
        operaciones.addOperando1(numero1);
        operaciones.addOperandor(textoBoton.charAt(0));
        display.setText("0");
    }

}
