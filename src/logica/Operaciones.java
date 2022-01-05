package logica;

public class Operaciones {

    private float operando1;
    private char operador;

    public void addOperando1(float operando1) {
        this.operando1 = operando1;
    }
    
    public void addOperandor(char operador) {
        this.operador = operador;
    }

    public float operar(float operando2) {
        return switch (operador) {
            case '+' -> operando1 + operando2;
            case '-' -> operando1 - operando2;
            case '*' -> operando1 * operando2;
            default -> operando1 / operando2;
        };
    }

}

