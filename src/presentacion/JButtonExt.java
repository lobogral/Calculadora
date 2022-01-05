package presentacion;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import logica.Click;

public class JButtonExt extends JButton{
    
    private final Click oprimir;
    
    public JButtonExt(Click oprimir, ActionListener actionListener){
        this.oprimir = oprimir;
        setText(oprimir.getSimbolo());
        setFont(new Font("Tahoma", 0, 17));
        addActionListener(actionListener);
    }
    
    public Click getOprimir(){
        return oprimir;
    }
}
