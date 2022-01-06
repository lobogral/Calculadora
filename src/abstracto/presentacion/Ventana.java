package abstracto.presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Ventana extends JFrame implements ActionListener {
    
    private final JButtonExt[] jButtonExts;

    public Ventana(JLabel lblDisplay, 
                   GridLayout gridLayout,
                   JButtonExt[] jButtonExts) {
        
        //Establece condiciones básicas
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        pack();
        
        //Agrega label para mostrar resultados
        getContentPane().add(lblDisplay);
        
        //Agrega el panel de los botones
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(gridLayout);
        pnlBotones.setBounds(30, 90, 270, 200);
        getContentPane().add(pnlBotones);
        
        this.jButtonExts = jButtonExts;
        for (JButtonExt jButtonExt : this.jButtonExts) {
            jButtonExt.addActionListener(this);
            pnlBotones.add(jButtonExt);
        }
        
        //Hace otras operaciones
        this.setBounds(200, 200, 345, 350);              
        this.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButtonExt btnExt = (JButtonExt)(e.getSource());
        btnExt.ejecutar();
    }
    
}