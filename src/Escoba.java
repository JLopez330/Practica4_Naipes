import java.util.ArrayList;
import java.util.Scanner;

//La Clase encarga del control del juego
public class Escoba {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Naipe> cartasEnTablero;
    private Baraja baraja;

    private boolean elJuegoSigue = true;

    public Escoba(){
        jugadores = new ArrayList();
        cartasEnTablero = new ArrayList<>();
    }

    public void jugarJuego(){
        System.out.println("===========ESCOBA===========");
        crearJugadores();
        //do{
        baraja = new Baraja();
        baraja.revolverMazo();
        repartirCartas();
        jugarTurno();
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

    public void repartirCartas(){
        for (Jugador jugador:jugadores) {
            jugador.tomarMano(baraja.getMano3Cartas());
        }
    }

    public void jugarTurno(){
        for (Jugador player: jugadores) {
            player.mostrarMano();
        }
    }
}
