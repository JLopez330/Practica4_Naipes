import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class Naipe extends JButton {
    private int valor;
    private String palo;
    private boolean estaVolteada;

    public Naipe(int valor, String palo, boolean estaVolteada){
        this.valor = valor;
        this.palo = palo;
        this.estaVolteada = estaVolteada;
        setLayout(new BorderLayout());
        setIcon(new ImageIcon());

    }

    public int getValor() {

        return valor;
    }

    public void setValor(int valor) {

        this.valor = valor;
    }

    public String getPalo() {

        return palo;
    }

    public void setPalo(String palo) {

        this.palo = palo;
    }

    public boolean isEstaVolteada() {

        return estaVolteada;
    }

    public void setEstaVolteada(boolean estaVolteada) {

        this.estaVolteada = estaVolteada;
    }

    @Override
    public String toString() {
        String cadena;
        cadena="["+palo+" "+valor+"]";
        return cadena;
    }

}
