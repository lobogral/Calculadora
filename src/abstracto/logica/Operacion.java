package abstracto.logica;

public class Operacion {

    private float operando1;
    private Operador operador;

    public void addOperando1(float operando1) {
        this.operando1 = operando1;
    }
    
    public void addOperandor(Operador operador) {
        this.operador = operador;
    }

    public float operar(float operando2) {
        return operador.operar(operando1, operando2);
    }

}
