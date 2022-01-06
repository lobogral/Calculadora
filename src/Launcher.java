import abstracto.presentacion.LblDisplayExt;
import abstracto.presentacion.Ventana;
import abstracto.logica.Operaciones;
import abstracto.presentacion.JButtonExt;
import concreto.click.ClickDigito;
import concreto.click.ClickIgual;
import concreto.click.ClickOperador;
import concreto.click.ClickAC;
import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Launcher {
    
    public static void main(String[] args) {
        
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
        
        GridLayout gridLayout = new GridLayout(4, 4, 3, 3);
        Operaciones operaciones = new Operaciones();
        LblDisplayExt lblDisplayExt = new LblDisplayExt();
        
        ClickDigito clickDigito = new ClickDigito(lblDisplayExt);
        ClickOperador clickOperador = new ClickOperador(lblDisplayExt, operaciones);
        ClickIgual clickIgual = new ClickIgual(lblDisplayExt, operaciones);
        ClickAC clickAC = new ClickAC(lblDisplayExt);

        int cont = 0;
        JButtonExt[] jButtonExts = new JButtonExt[16];
        jButtonExts[cont++] = new JButtonExt("7", clickDigito);
        jButtonExts[cont++] = new JButtonExt("8", clickDigito);
        jButtonExts[cont++] = new JButtonExt("9", clickDigito);
        jButtonExts[cont++] = new JButtonExt("/", clickOperador);
        jButtonExts[cont++] = new JButtonExt("4", clickDigito);
        jButtonExts[cont++] = new JButtonExt("5", clickDigito);
        jButtonExts[cont++] = new JButtonExt("6", clickDigito);
        jButtonExts[cont++] = new JButtonExt("*", clickOperador);
        jButtonExts[cont++] = new JButtonExt("1", clickDigito);
        jButtonExts[cont++] = new JButtonExt("2", clickDigito);
        jButtonExts[cont++] = new JButtonExt("3", clickDigito);
        jButtonExts[cont++] = new JButtonExt("-", clickOperador);
        jButtonExts[cont++] = new JButtonExt("=", clickIgual);
        jButtonExts[cont++] = new JButtonExt("0", clickDigito);
        jButtonExts[cont++] = new JButtonExt("AC", clickAC);
        jButtonExts[cont++] = new JButtonExt("+", clickOperador);
        
        Ventana ventana = new Ventana(lblDisplayExt.getLblDisplay(),
                                      gridLayout,
                                      jButtonExts);
    }

}
