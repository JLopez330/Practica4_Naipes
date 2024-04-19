public class Naipe{
    private int valor;
    private String palo;
    private boolean estaVolteada;

    /**
    Crea una carta con valor y palo asignado
     */
    public Naipe(int valor, String palo, boolean estaVolteada){
        this.valor = valor;
        this.palo = palo;
        this.estaVolteada = estaVolteada;
    }

    /**
    Regresa el valor de la carta
     */
    public int getValor() {

        return valor;
    }

    /**
    Metodo toString de la carta
     */
    @Override
    public String toString() {
        String cadena;
        cadena="["+palo+" "+valor+"]";
        return cadena;
    }

}
