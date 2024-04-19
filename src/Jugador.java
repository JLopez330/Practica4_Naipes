import java.util.ArrayList;

public class Jugador {
    ArrayList<Naipe> mano;
    ArrayList<Naipe> cartasObtenidas;
    int cantidadEscobas;
    int puntos;
    int idJugador;

    /**
    Crea al jugador junto con sus atributos iniciales
     */
    public Jugador(int idJugador) {
        mano = new ArrayList();
        cartasObtenidas = new ArrayList<>();
        cantidadEscobas = 0;
        puntos = 0;
        this.idJugador = idJugador;

    }

    /**
    Regresa la id del jugador
     */
    public int getIdJugador() {
        return idJugador;
    }

    /**
    Devuelve la cantidad de cartas en la mano
     */
    public int getCantidadCartasEnMano() {
        return mano.size();
    }

    /**
    Devuelve la cantidad de cartas que se encuentran en el descarte total del jugador
     */
    public int getCantidadDeCartasEnDescarte(){
        return cartasObtenidas.size();
    }


    /**
    Devuelve la cantidad de cartas en la mano del jugador
     */
    public void tomarMano(ArrayList<Naipe> cartas){
        mano = cartas;
    }

    /**
    Imprime las cartas del jugador en la consola
     */
    public void mostrarMano(){
        System.out.println("Mano de Jugador "+idJugador+":");
        for (Naipe carta:mano) {
            System.out.print(carta+" ");
        }
        System.out.println("");
    }


    /**
    Comprueba si un arreglo de cartas puede sumar la cantidad de 15 puntos
     */
    public boolean forma15Puntos(Naipe... cartas) {
        int suma = 0;
        for (Naipe carta : cartas) {
            suma += carta.getValor();
        }
        return suma==15; //Está regresando que la suma es igual a 15?
        //Es una comprobación que regresa un booleano de verdadero o falso
    }

    /**
     * Recibe un ArrayList de cartas y las manda al descarte del jugador.
     */
    public void mandarADescarteDeJugador(Naipe naipeElegido, ArrayList<Naipe>naipes){
        cartasObtenidas.add(naipeElegido);
        for (Naipe naipe:naipes) {
            cartasObtenidas.add(naipe);
        }
    }


}
