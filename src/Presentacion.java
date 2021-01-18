import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Presentacion extends JFrame implements ActionListener {
    
    private JLabel lblDisplay;
    private final Logica logica;

    public Presentacion(Logica logica) {
        this.logica = logica;
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
        lblDisplay = new JLabel();
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
        for (int i=0; i<botones.length; i++) {
            botones[i] = new JButton();
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
        
        JButton boton = (JButton)(e.getSource());
        DecimalFormat format = new DecimalFormat("#.######");
        format.setDecimalSeparatorAlwaysShown(false);
        
        if("+-*/".contains(boton.getText())){
            float numero1 = Float.parseFloat(lblDisplay.getText());
            logica.addOperando1(numero1);
            char operador = boton.getText().charAt(0);
            logica.addOperandor(operador);
            lblDisplay.setText("0");
        } else if("=".contains(boton.getText())){
            float numero2 = Float.parseFloat(lblDisplay.getText());
            float resultado = logica.operacion(numero2);
            lblDisplay.setText("" + format.format(resultado));
        } else if("0123456789".contains(boton.getText())){
            String numero = lblDisplay.getText();
            if(numero.equals("0")){                      
                numero = "";            
            }
            numero = numero + boton.getText();
            lblDisplay.setText(numero);
        } else if(".".contains(boton.getText())){
            String numero = lblDisplay.getText();
            if(!numero.contains(".")){
                numero = numero + boton.getText();
                lblDisplay.setText(numero);            
            } else {
                lblDisplay.setText("0");
            }
        }
    }
    
}