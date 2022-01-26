package concreto.click;

import abstracto.logica.Operacion;
import abstracto.logica.IntDisplay;
import abstracto.logica.Click;
import abstracto.logica.Operador;
import java.util.HashMap;

public class ClickOperador implements Click{

    private final IntDisplay display;
    private final Operacion operacion;
    private final HashMap<Character, Operador> operadores;

    public ClickOperador(IntDisplay display,
                         Operacion operaciones,
                         HashMap<Character, Operador> operadores){
        this.display = display;
        this.operacion = operaciones;
        this.operadores = operadores;
    }
    
    @Override
    public void ejecutar(String textoBoton){
        float numero1 = Float.parseFloat(display.getText());
        operacion.addOperando1(numero1);
        char operador = textoBoton.charAt(0);
        operacion.addOperandor(operadores.get(operador));
        display.setText("0");
    }

}
