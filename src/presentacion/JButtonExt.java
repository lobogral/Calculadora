package presentacion;

import javax.swing.JButton;
import logica.Oprimir;

public class JButtonExt extends JButton{
    
    private final Oprimir oprimir;
    
    public JButtonExt(Oprimir oprimir){
        this.oprimir = oprimir;
    }
    
    public Oprimir getOprimir(){
        return oprimir;
    }
}
