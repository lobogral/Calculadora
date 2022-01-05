package presentacion;

import logica.Operaciones;
import logica.opr.ClickPunto;
import logica.opr.ClickIgual;
import logica.opr.ClickDigito;
import logica.opr.ClickOperador;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import logica.Click;

public class Ventana extends JFrame implements ActionListener {
    
    private final Operaciones operaciones;

    public Ventana(Operaciones operaciones) {
        this.operaciones = operaciones;
        initComponents();
    }

    private void initComponents() {
        
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
        LblDisplayExt lblDisplayExt = new LblDisplayExt();
        getContentPane().add(lblDisplayExt.getLblDisplay());
        
        //Agrega el panel de los botones
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new GridLayout(4, 4, 3, 3));
        getContentPane().add(pnlBotones);
        pnlBotones.setBounds(30, 90, 270, 200);
        
        //Coloca los botones
        Click[] clicks = new Click[16];
        clicks[0] = new ClickDigito(7, lblDisplayExt);
        clicks[1] = new ClickDigito(8, lblDisplayExt);
        clicks[2] = new ClickDigito(9, lblDisplayExt);
        clicks[3] = new ClickOperador('/', lblDisplayExt, operaciones);
        clicks[4] = new ClickDigito(4, lblDisplayExt);
        clicks[5] = new ClickDigito(5, lblDisplayExt);
        clicks[6] = new ClickDigito(6, lblDisplayExt);
        clicks[7] = new ClickOperador('*', lblDisplayExt, operaciones);
        clicks[8] = new ClickDigito(1, lblDisplayExt);
        clicks[9] = new ClickDigito(2, lblDisplayExt);
        clicks[10] = new ClickDigito(3, lblDisplayExt);
        clicks[11] = new ClickOperador('-', lblDisplayExt, operaciones);
        clicks[12] = new ClickIgual(lblDisplayExt, operaciones);
        clicks[13] = new ClickDigito(0, lblDisplayExt);
        clicks[14] = new ClickPunto(lblDisplayExt);
        clicks[15] = new ClickOperador('+', lblDisplayExt, operaciones);
        
        for (Click click : clicks) {
            pnlBotones.add(new JButtonExt(click, this));
        }
        //Hace otras operaciones
        this.setBounds(200, 200, 345, 350);              
        this.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButtonExt btnExt = (JButtonExt)(e.getSource());
        btnExt.getOprimir().ejecutar();
    }
    
}