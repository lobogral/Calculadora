package concreto.operaciones;

import abstracto.logica.Operador;

public class OpeResta implements Operador{
    @Override
    public float operar(float operador1, float operador2){
        return operador1 - operador2;
    }
}
