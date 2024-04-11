import java.util.ArrayList;

public class CartasTablero {
    ArrayList<Naipe> cartasCentrales;
    /**
     * Inicializa las cartas del centro del tablero
     */
    public CartasTablero() {
        cartasCentrales = new ArrayList();
    }
    /**
     * Añade cartas al tablero
     */
    public void añadirCarta(Naipe carta){

        cartasCentrales.add(carta);
    }
    /**
     * Modifica las cartas centrales por la entrada
     */
    public void tomarCentro(ArrayList<Naipe> cartas){

        cartasCentrales = cartas;
    }

    public int getCantidadDeCartasEnTablero(){
        return cartasCentrales.size();
    }

    /**
     * Manda una copia de la carta en el indice X
     */
    public Naipe mandarCartaEn(int indice){
        Naipe auxiliar;
        auxiliar = cartasCentrales.get(indice-1);

        return auxiliar;
    }


    public Naipe removerCartaEn(int indice){
        Naipe auxiliar;
        auxiliar = cartasCentrales.get(indice-1);
        return auxiliar;
    }


    /**
     * Muestra en la consola las cartas del tablero
     */
    public void mostrarCentro(){
        System.out.println("Cartas centrales");
        for (Naipe carta:cartasCentrales) {
            System.out.print(carta+" ");
        }
        System.out.println("");
    }
}

