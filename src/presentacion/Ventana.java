package presentacion;

import logica.Operaciones;
import logica.Oprimir;
import logica.opr.OprPunto;
import logica.opr.OprIgual;
import logica.opr.OprDigito;
import logica.opr.OprOperador;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

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
        } catch (Exception ex) {
            System.out.println("No se puede implementar LookAndFeel");
        }
        //Agrega label para mostrar resultados
        LblDisplayExt lblDisplay = new LblDisplayExt();
        lblDisplay.setBackground(new Color(255, 255, 255));
        lblDisplay.setFont(new Font("Tahoma", 0, 17)); // NOI18N
        lblDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDisplay.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lblDisplay.setOpaque(true);
        getContentPane().add(lblDisplay);
        lblDisplay.setBounds(30, 30, 270, 40);
        //Agrega el panel de los botones
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new GridLayout(4, 4, 3, 3));
        getContentPane().add(pnlBotones);
        pnlBotones.setBounds(30, 90, 270, 200);
        //Coloca los botones
        JButton[] botones = new JButton[16];
        String[] textoBotones = {"7","8","9","/",
                                 "4","5","6","*",
                                 "1","2","3","-", 
                                 "=","0",".","+"};
        
        Oprimir[] oprimir = new Oprimir[16];
        oprimir[0] = new OprDigito(7, lblDisplay);
        oprimir[1] = new OprDigito(8, lblDisplay);
        oprimir[2] = new OprDigito(9, lblDisplay);
        oprimir[3] = new OprOperador('/', lblDisplay, operaciones);
        oprimir[4] = new OprDigito(4, lblDisplay);
        oprimir[5] = new OprDigito(5, lblDisplay);
        oprimir[6] = new OprDigito(6, lblDisplay);
        oprimir[7] = new OprOperador('*', lblDisplay, operaciones);
        oprimir[8] = new OprDigito(1, lblDisplay);
        oprimir[9] = new OprDigito(2, lblDisplay);
        oprimir[10] = new OprDigito(3, lblDisplay);
        oprimir[11] = new OprOperador('-', lblDisplay, operaciones);
        oprimir[12] = new OprIgual(lblDisplay, operaciones);
        oprimir[13] = new OprDigito(0, lblDisplay);
        oprimir[14] = new OprPunto(lblDisplay);
        oprimir[15] = new OprOperador('+', lblDisplay, operaciones);
        
        for (int i=0; i<botones.length; i++) {    
            botones[i] = new JButtonExt(oprimir[i]);
            botones[i].setText(textoBotones[i]);
            botones[i].setFont(new Font("Tahoma", 0, 17));
            botones[i].addActionListener(this);
            pnlBotones.add(botones[i]);
        }
        //Hace otras operaciones
        this.setBounds(200, 200, 345, 350);
        lblDisplay.setText("0");                
        this.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButtonExt btnExt = (JButtonExt)(e.getSource());
        btnExt.getOprimir().ejecutar();
    }
    
}