import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Naipe{
    private int valor;
    private String palo;
    private boolean estaVolteada;


    public Naipe(int valor, String palo, boolean estaVolteada){
        this.valor = valor;
        this.palo = palo;
        this.estaVolteada = estaVolteada;
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

    /**
     * Compara el valor de la carta con otra, regresa true si son iguales
     * @param otraCarta
     * @return
     */
    public boolean compararValorCon(Naipe otraCarta){
        boolean esIgual;
        if(valor == otraCarta.getValor()){
            esIgual = true;
        }else{
            esIgual = false;
        }
        return esIgual;
    }

    /**
     * Compara el palo de la carta con otra, regresa true si son iguales
     * @param otraCarta
     * @return
     */
    public boolean comprarPaloCon(Naipe otraCarta){
        boolean esIgual;
        if(palo.equals(otraCarta.getPalo())){
            esIgual = true;
        }else{
            esIgual = false;
        }
        return esIgual;
    }

    @Override
    public String toString() {
        String cadena;
        cadena="["+palo+" "+valor+"]";
        return cadena;
    }

}
