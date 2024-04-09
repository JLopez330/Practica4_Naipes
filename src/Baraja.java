import java.util.ArrayList;
import java.util.Collections;

/**
 * Añadi ArrayLists temporales para hacer el funcionamiento en la consola
 */
public class Baraja {
    private ArrayList<Naipe> naipes;
    ArrayList<Naipe> naipesJugador1;
    ArrayList<Naipe> naipesJugador2;
    ArrayList<Naipe> descarteJugador1;
    ArrayList<Naipe> descarteJugador2;
    ArrayList<Naipe> naipesCentrales;

    /**
     * Dividi las cartas de la baraja inicial para que desde el principio del juego ya se tengan las cartas iniciales
     */
    public Baraja() {
        naipes = new ArrayList<>();
        String[] palos;
        palos = new String[]{"oro", "copa", "espada", "mazo"};
        Naipe auxiliar;
        //int contador=1; //Deja esto comentado de momento

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 10; j++) {
                auxiliar = new Naipe(j, palos[i], false);
                naipes.add(auxiliar);
                //contador++; //Deja esto como un comentario de momento
            }
        }
        //revolverMazo(); //De moomento no se va a revolver para evitar aleatoriedad
        naipesJugador1 = new ArrayList();
        Naipe temp;
        for (int i = 1; i <= (3); i++) {
            temp = naipes.remove(0);
            naipesJugador1.add(temp);
        }
        naipesJugador2 = new ArrayList();
        for (int i = 1; i <= (3); i++) {
            temp = naipes.remove(0);
            naipesJugador2.add(temp);
        }
        naipesCentrales = new ArrayList();
        for (int i = 1; i <= (4); i++) {
            temp = naipes.remove(0);
            naipesCentrales.add(temp);
        }
        descarteJugador1 = new ArrayList();
        descarteJugador2 = new ArrayList();
    }

    /**
     * Barajea el Mazo de cartas
     */
    public void mostrarBaraja() {
        naipes.forEach(System.out::println);
    }

    /**
     * Revuelve las cartas en el mazo
     */
    public void revolverMazo() {
        Collections.shuffle(naipes);
    }

    /**
     * Remueve X cantidad de cartas del tope del mazo
     */
    public ArrayList<Naipe> getNaipes(int cantidad) {
        ArrayList<Naipe> naipesParaRepartir = new ArrayList();
        for (int i = 0; i < cantidad; i++) {
            naipesParaRepartir.add(naipes.remove(0));
        }
        return naipesParaRepartir;
    }

    /**
     * Determina si es posible realizar una suma que de como resultado 15 con las cartas proporcionadas
     */
    public boolean forma15Puntos(Naipe... cartas) {
        int suma = 0;
        for (Naipe carta : cartas) {
            suma += carta.getValor();
        }
        return suma == 15;
    }
    public void mandarACartasDescartadasJugador1DelJugador(Naipe carta) {
        descarteJugador1.add(carta);
        naipesJugador1.remove(carta);
    }
    public void mandarACartasDescartadasJugador1Centrales(Naipe carta) {
        descarteJugador1.add(carta);
        naipesCentrales.remove(carta); // Eliminar la carta del array de naipesCentrales
    }
    public void mandarADescarteJugador1(Naipe cartaADescartar, Naipe... cartas) {
        // Mandar la carta elegida por el jugador al descarte del jugador 1
        mandarACartasDescartadasJugador1DelJugador(cartaADescartar);

        // Mandar las demás cartas al descarte del jugador 1
        for (Naipe carta : cartas) {
            mandarACartasDescartadasJugador1Centrales(carta);
        }
    }

    public void mandarACartasDescartadasJugador2DelJugador(Naipe carta) {
        descarteJugador2.add(carta);
        naipesJugador2.remove(carta);
    }
    public void mandarACartasDescartadasJugador2Centrales(Naipe carta) {
        descarteJugador2.add(carta);
        naipesCentrales.remove(carta); // Eliminar la carta del array de naipesCentrales
    }
    public void mandarADescarteJugador2(Naipe cartaADescartar, Naipe... cartas) {
        // Mandar la carta elegida por el jugador al descarte del jugador 2
        mandarACartasDescartadasJugador2DelJugador(cartaADescartar);

        // Mandar las demás cartas al descarte del jugador 2
        for (Naipe carta : cartas) {
            mandarACartasDescartadasJugador2Centrales(carta);
        }
    }
    public void mostrarJuego() {//Muestra el domino en consola
        Naipe naipeTemp;
        System.out.println("Naipes Jugador 1");
        for (int i=0; i<naipesJugador1.size(); i++) {
            naipeTemp = naipesJugador1.get(i);
            System.out.print(naipeTemp);
        }
        System.out.println("");
        System.out.println("Naipes descartados jugador 1");
        for (int i=0; i<descarteJugador1.size(); i++) {
            naipeTemp = descarteJugador1.get(i);
            System.out.print(naipeTemp);
        }
        System.out.println("");
        System.out.println("Naipes centrales");
        for (int i=0; i<naipesCentrales.size(); i++) {
            naipeTemp = naipesCentrales.get(i);
            System.out.print(naipeTemp);
        }
        System.out.println("");
        System.out.println("Naipes Jugador 2");

        for (int i=0; i<naipesJugador2.size(); i++) {
            naipeTemp = naipesJugador2.get(i);
            System.out.print(naipeTemp);
        }

        System.out.println("");
        System.out.println("Naipes descartados jugador 2");
        for (int i=0; i<descarteJugador2.size(); i++) {
            naipeTemp = descarteJugador2.get(i);
            System.out.print(naipeTemp);
        }
    }
}
