import java.awt.Dialog;
import java.awt.*;
import java.awt.event.*;

public class InterfacciaGrafica {
    public static void main(String[] args) {
        Frame f = new Frame( "Hello world!" );
        f.addWindowListener( new WindowAdapter(){ public void windowClosing( WindowEvent e ){ System.exit( 0 ); } } );
        f.setSize( 300, 100 );
        f.show();
    }
}
