import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class Naipe extends JButton {
    private int valor;
    private String palo;
    private boolean estaVolteada;


    public Naipe(int valor, String palo, boolean estaVolteada, int orden){
        this.valor = valor;
        this.palo = palo;
        this.estaVolteada = estaVolteada;
        ImageIcon icono = new ImageIcon(this.getClass().getResource("img/"+orden+".png"));
        setLayout(new BorderLayout());
        this.setIcon(icono);

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

    public void volverVisible(){
        setVisible(true);
    }

    @Override
    public String toString() {
        String cadena;
        cadena="["+palo+" "+valor+"]";
        return cadena;
    }

}
