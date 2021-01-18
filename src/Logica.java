public class Logica {

    private float operando1;
    private char operador;

    public void addOperando1(float operando1) {
        this.operando1 = operando1;
    }
    
    public void addOperandor(char operador) {
        this.operador = operador;
    }

    public float operacion(float operando2) {
        switch (operador) {
            case '+':
                return operando1 + operando2;
            case '-':
                return operando1 - operando2;
            case '*':
                return operando1 * operando2;
            default:
                return operando1 / operando2; 
        }
    }

}

