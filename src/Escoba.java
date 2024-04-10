import java.util.ArrayList;
import java.util.Scanner;

//La Clase encarga del control del juego
public class Escoba {
    private ArrayList<Jugador> jugadores;
    //private ArrayList<Naipe> cartasEnTablero;//No entiendo porque se utiliza la clase Naipe para este array
    private ArrayList<CartasTablero> cartasCentro;
    private Baraja baraja;

    private boolean elJuegoSigue = true;

    public Escoba(){
        jugadores = new ArrayList();
        cartasCentro = new ArrayList();//Añadido
    }

    public void jugarJuego(){
        System.out.println("===========ESCOBA===========");
        crearJugadores();
        crearCentro();//Añadido
        //do{
        baraja = new Baraja();
        baraja.revolverMazo();
        repartirCartas();
        jugarTurno();
        cartasTablero();//Añadido
        mostrarTablero();//Añadido
        //}while(elJuegoSigue);
    }

    public void crearJugadores(){
        int cantidad;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Cantidad de Jugadores: ");
            cantidad = sc.nextInt();
            if (cantidad<2 && cantidad >4){
                System.out.println("La cantidad ingresada no es valida, favor de intentar de nuevo!");
            }
        }while(cantidad<1 && cantidad>4);
        for(int i = 0; i<cantidad; i++){
            jugadores.add(new Jugador(i+1));
        }
    }
    /**
     * Inicializa las cartas del centro del tablero
     */
    public void crearCentro(){
        cartasCentro.add(new CartasTablero());
    }

    public void repartirCartas(){
        for (Jugador jugador:jugadores) {
            jugador.tomarMano(baraja.getMano3Cartas());
        }
    }
    /**
     * Obtiene el tablero inicial de la partida. desconozco si se puede realizar sin el for
     */
    public void cartasTablero(){
        for (CartasTablero centro:cartasCentro) {
            centro.tomarCentro(baraja.getTableroInicial());
        }
    }

    public void jugarTurno(){
        for (Jugador player: jugadores) {
            player.mostrarMano();
        }
    }

    /**
     * Se encarga de mostrar las cartas del tablero. dezconosco como hacerlo sin el for
     * tenme piedad que java me esta comiendo lo poco que me queda de sanidad
     */
    public void mostrarTablero(){
        for (CartasTablero centro: cartasCentro) {
            centro.mostrarCentro();
        }
    }
}
