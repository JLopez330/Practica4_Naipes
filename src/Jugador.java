import java.util.ArrayList;

public class Jugador {
    ArrayList<Naipe> mano;
    ArrayList<Naipe> cartasObtenidas;
    int cantidadEscobas;
    int puntos;
    int idJugador;

    public Jugador(int idJugador){
        mano = new ArrayList();
        cartasObtenidas = new ArrayList<>();
        cantidadEscobas = 0;
        puntos = 0;
        this.idJugador=idJugador;

    }

    public void tomarCarta(Naipe carta){

        mano.add(carta);
    }

    public void tomarMano(ArrayList<Naipe> cartas){
        mano = cartas;
    }

    public void mostrarMano(){
        System.out.println("Mano de Jugador "+idJugador+":");
        for (Naipe carta:mano) {
            System.out.print(carta+" ");
        }
        System.out.println("");
    }




}
