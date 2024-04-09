import java.util.ArrayList;

public class Jugador {
    ArrayList<Naipe> mano;
    ArrayList<Naipe> cartasObtenidas;
    int cantidadEscobas;
    int puntos;

    public Jugador(){
        mano = new ArrayList();
        cartasObtenidas = new ArrayList<>();
        cantidadEscobas = 0;
        puntos = 0;
    }

    public void tomarCarta(Naipe carta){
        mano.add(carta);
    }


}
