import java.util.ArrayList;
import java.util.Collections;

/**
 * Añadi ArrayLists temporales para hacer el funcionamiento en la consola
 */
public class Baraja {
    private ArrayList<Naipe> naipes;

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

    }

    /**
     * Regresa la cantidad de cartas que quedan en el mazo
     */
    public int getCantidadCartas(){
        return naipes.size();
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
     * Da la mano de 3 cartas al jugador
     */
    public ArrayList<Naipe> getMano3Cartas(){
        ArrayList<Naipe> cartas = new ArrayList();
        for(int i = 0; i<3; i++){
            cartas.add(naipes.remove(0));
        }
        return cartas;
    }

    /**
     * Crea las 4 cartas iniciales del tablero
     */
    public ArrayList<Naipe> getTableroInicial(){
        ArrayList<Naipe> cartasCentrales = new ArrayList();
        for(int i = 0; i<4; i++){
            cartasCentrales.add(naipes.remove(0));
        }
        return cartasCentrales;
    }

    /**
     * Determina si es posible realizar una suma que de como resultado 15 con las cartas proporcionadas
     */
    public boolean forma15Puntos(Naipe... cartas) {
        int suma = 0;
        for (Naipe carta : cartas) {
            suma += carta.getValor();
        }
        return suma == 15; //Está regresando que la suma es igual a 15?
        //Es una comprobación que regresa un booleano de verdadero o falso
    }

}
