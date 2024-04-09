import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Naipe> naipes;

    public Baraja(){
        naipes = new ArrayList<>();
        String[] palos;
        palos= new String[]{"oro","copa","espada","mazo"};
        Naipe auxiliar;
        //int contador=1; //Deja esto comentado de momento

        for(int i = 0; i<4; i++){
            for(int j = 1; j<=10; j++){
                auxiliar = new Naipe(j,palos[i],false);
                naipes.add(auxiliar);
                //contador++; //Deja esto como un comentario de momento
            }
        }
    }

    /**
     * Barajea el Mazo de cartas
     */
    public void mostrarBaraja(){
        naipes.forEach(System.out::println);
    }

    /**
     * Revuelve las cartas en el mazo
     */
    public void revolverMazo(){
        Collections.shuffle(naipes);
    }

    /**
     * Remueve X cantidad de cartas del tope del mazo
     */
    public ArrayList<Naipe> getNaipes(int cantidad) {
        ArrayList<Naipe> naipesParaRepartir = new ArrayList();
        for(int i=0; i<cantidad; i++){
            naipesParaRepartir.add(naipes.remove(0));
        }
        return naipesParaRepartir;
    }


}
