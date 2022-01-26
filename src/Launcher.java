import abstracto.presentacion.LblDisplayExt;
import abstracto.presentacion.Ventana;
import abstracto.presentacion.JButtonExt;
import abstracto.logica.Operacion;
import concreto.click.ClickDigito;
import concreto.click.ClickIgual;
import concreto.click.ClickOperador;
import concreto.click.ClickAC;
import concreto.click.ClickDEL;
import concreto.click.ClickOFF;
import concreto.click.ClickPunto;
import concreto.operaciones.OpeDivision;
import concreto.operaciones.OpeMultiplicacion;
import concreto.operaciones.OpeResta;
import concreto.operaciones.OpeSuma;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import abstracto.logica.Operador;


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
        
        int filasGrid = 5;
        int columnasGrid = 4;
        GridLayout gridLayout = new GridLayout(filasGrid, columnasGrid, 3, 3);       
        
        HashMap<Character, Operador> operadores = new HashMap<>();
        operadores.put('+', new OpeSuma());
        operadores.put('-', new OpeResta());
        operadores.put('*', new OpeMultiplicacion());
        operadores.put('/', new OpeDivision());

        Operacion operacion = new Operacion();
        LblDisplayExt lblDisplayExt = new LblDisplayExt();

        ClickDigito clickDigito = new ClickDigito(lblDisplayExt);
        ClickOperador clickOperador = new ClickOperador(lblDisplayExt, operacion, operadores);
        ClickIgual clickIgual = new ClickIgual(lblDisplayExt, operacion);
        ClickAC clickAC = new ClickAC(lblDisplayExt);
        ClickOFF clickOFF = new ClickOFF();
        ClickPunto clickPunto = new ClickPunto(lblDisplayExt);
        ClickDEL clickDEL = new ClickDEL(lblDisplayExt);

        int cont = 0;
        JButtonExt[] jButtonExts = new JButtonExt[filasGrid*columnasGrid];
        jButtonExts[cont++] = new JButtonExt("OFF", clickOFF);
        jButtonExts[cont++] = new JButtonExt("DEL", clickDEL);
        jButtonExts[cont++] = new JButtonExt("AC", clickAC);
        jButtonExts[cont++] = new JButtonExt("/", clickOperador);
        jButtonExts[cont++] = new JButtonExt("7", clickDigito);
        jButtonExts[cont++] = new JButtonExt("8", clickDigito);
        jButtonExts[cont++] = new JButtonExt("9", clickDigito);
        jButtonExts[cont++] = new JButtonExt("*", clickOperador);
        jButtonExts[cont++] = new JButtonExt("4", clickDigito);
        jButtonExts[cont++] = new JButtonExt("5", clickDigito);
        jButtonExts[cont++] = new JButtonExt("6", clickDigito);
        jButtonExts[cont++] = new JButtonExt("-", clickOperador);
        jButtonExts[cont++] = new JButtonExt("1", clickDigito);
        jButtonExts[cont++] = new JButtonExt("2", clickDigito);
        jButtonExts[cont++] = new JButtonExt("3", clickDigito);
        jButtonExts[cont++] = new JButtonExt("+", clickOperador);
        jButtonExts[cont++] = new JButtonExt("0", clickDigito);
        jButtonExts[cont++] = new JButtonExt("00", clickDigito);
        jButtonExts[cont++] = new JButtonExt(".", clickPunto);
        jButtonExts[cont++] = new JButtonExt("=", clickIgual);
        
        Ventana ventana = new Ventana(lblDisplayExt.getLblDisplay(),
                                      gridLayout,
                                      jButtonExts);
    }

}
