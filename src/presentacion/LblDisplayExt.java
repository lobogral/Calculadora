package presentacion;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import logica.IntDisplay;

public class LblDisplayExt implements IntDisplay{

    private final JLabel lblDisplay;
    
    public LblDisplayExt(){
        lblDisplay = new JLabel();
        lblDisplay.setBackground(new Color(255, 255, 255));
        lblDisplay.setFont(new Font("Tahoma", 0, 17)); // NOI18N
        lblDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDisplay.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lblDisplay.setOpaque(true);
        lblDisplay.setBounds(30, 30, 270, 40);
        lblDisplay.setText("0");
    }
    
    public JLabel getLblDisplay(){
        return lblDisplay;
    }
    
    @Override
    public String getText() {
        return lblDisplay.getText();
    }

    @Override
    public void setText(String text) {
        lblDisplay.setText(text);
    }
    
}
