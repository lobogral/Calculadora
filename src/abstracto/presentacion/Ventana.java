package abstracto.presentacion;

import abstracto.logica.Click;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class Ventana extends JFrame implements ActionListener {
    
    private final JButtonExt[] jButtonExts;

    public Ventana(JLabel lblDisplay, 
                   GridLayout gridLayout,
                   Click[] clicks) {
        
        //Establece condiciones básicas
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        pack();
        
        //Establece el lookAndFeel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException 
                 | IllegalAccessException 
                 | InstantiationException 
                 | UnsupportedLookAndFeelException ex) {
            System.out.println("No se puede implementar LookAndFeel");
        }
        
        //Agrega label para mostrar resultados
        getContentPane().add(lblDisplay);
        
        //Agrega el panel de los botones
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(gridLayout);
        pnlBotones.setBounds(30, 90, 270, 200);
        getContentPane().add(pnlBotones);
        
        
        jButtonExts = new JButtonExt[clicks.length];
        for(int i=0; i<clicks.length; i++){
            jButtonExts[i] = new JButtonExt(clicks[i], this);
            pnlBotones.add(jButtonExts[i]);
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