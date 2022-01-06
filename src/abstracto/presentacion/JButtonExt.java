package abstracto.presentacion;

import abstracto.logica.Click;
import java.awt.Font;
import javax.swing.JButton;

public class JButtonExt extends JButton{
    
    private final Click oprimir;
    private final String texto;
    
    public JButtonExt(String texto, Click oprimir){
        this.oprimir = oprimir;
        this.texto = texto;
        setText(texto);
        setFont(new Font("Tahoma", 0, 17));
    }
    
    public void ejecutar(){
        oprimir.ejecutar(texto);
    }
}
