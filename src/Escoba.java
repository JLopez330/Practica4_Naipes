import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

//La Clase encarga del control del juego
public class Escoba {
    private ArrayList<Jugador> jugadores;
    //private ArrayList<Naipe> cartasEnTablero;//No entiendo porque se utiliza la clase Naipe para este array
    private CartasTablero cartasCentro;
    private Baraja baraja;

    private boolean elJuegoSigue = true;

    public Escoba(){
        jugadores = new ArrayList();
        cartasCentro = new CartasTablero();
    }

    public void jugarJuego(){
        System.out.println("===========ESCOBA===========");
        crearJugadores();
        baraja = new Baraja();
        baraja.revolverMazo();
        repartirCartas();
        cartasTablero();
        do{
        jugarTurno();
        elJuegoSigue=verificarJuego(); //Quitar Comentario ya que se pueda jugar la ronda entera
        }while(elJuegoSigue);
    }

    public void crearJugadores(){
        int cantidad;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Cantidad de Jugadores: ");
            cantidad = sc.nextInt();
            if (cantidad<2 || cantidad >4){
                System.out.println("La cantidad ingresada no es valida, favor de intentar de nuevo!");
            }
        }while(cantidad<2 || cantidad>4);
        for(int i = 0; i<cantidad; i++){
            jugadores.add(new Jugador(i+1));
        }
    }
    /**
     * Inicializa las cartas del centro del tablero
     */



    public void repartirCartas(){
        for (Jugador jugador:jugadores) {
            jugador.tomarMano(baraja.getMano3Cartas());
        }
    }
    /**
     * Obtiene el tablero inicial de la partida. desconozco si se puede realizar sin el for
     */
    public void cartasTablero(){
        cartasCentro.tomarCentro(baraja.getNaipes(4));
    }

    public void jugarTurno(){
        Scanner sc = new Scanner(System.in);
        for (Jugador player: jugadores) {
            mostrarTablero();
            player.mostrarMano();
            int indiceCarta;
            int indiceCartaCentral1;
            int indiceCartaCentral2;
            int indiceCartaCentral3;
            int indiceCartaCentral4;
            int indiceCartaCentral5;
            int indiceCartaCentral6;
            int indiceCartaCentral7;
            int indiceCartaCentral8;
            int cantidadCartas;
            Naipe auxiliar;
            ArrayList<Naipe> naipesAlDescarte = new ArrayList();
            do {
                System.out.println("Jugador, elije una carta: ");
                indiceCarta = sc.nextInt();
            }while(indiceCarta>player.getCantidadCartasEnMano()||indiceCarta<1);
            do{
                System.out.println("Elige la cantidad de cartas para sumar 15 puntos, si escribes 0 pasas turno ");
                cantidadCartas = sc.nextInt();
                if (cantidadCartas<=cartasCentro.getCantidadDeCartasEnTablero()){
                    switch(cantidadCartas){
                        case 0:
                            System.out.println("El jugador decidio pasar turno y colocar carta en el centro");
                            cartasCentro.añadirCarta(player.mano.get(indiceCarta-1));
                            player.mano.remove(indiceCarta-1);
                            break;
                        case 1:
                            do {
                                System.out.println("Elige la primera carta que vas a tomar: ");
                                indiceCartaCentral1 = sc.nextInt();
                            }while((!(indiceCartaCentral1<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1)));
                            if(player.forma15Puntos(player.mano.get(indiceCarta-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral1-1))){
                            //El Naipe auxiliar representa la carta usada por el jugador
                                    auxiliar=player.mano.remove(indiceCarta-1);
                            //Los Naipes Al Descarte varian dependiendo del case
                                    naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral1-1));
                                    player.mandarADescarteDeJugador(auxiliar,naipesAlDescarte);
                            }else{
                                System.out.println("No se lograron formar 15 puntos por lo que la carta se gasta");
                                cartasCentro.añadirCarta(player.mano.get(indiceCarta-1));
                                player.mano.remove(indiceCarta-1);
                            }
                            cantidadCartas=0;
                            break;
                        case 2:
                            do {
                                System.out.println("Elige la primera carta que vas a tomar: ");
                                indiceCartaCentral1 = sc.nextInt();
                            }while(!(indiceCartaCentral1<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            //tal vez indiceCartaCentral#<=1 lo arregle
                            do {
                                System.out.println("Elige la segunda carta que vas a tomar: ");
                                indiceCartaCentral2 = sc.nextInt();
                            }while(!(indiceCartaCentral2<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            if(player.forma15Puntos(player.mano.get(indiceCarta-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral1-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral2-1))) {
                                //El Naipe auxiliar representa la carta usada por el jugador
                                auxiliar = player.mano.remove(indiceCarta - 1);
                                //Los Naipes Al Descarte varian dependiendo del case
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral2 - 1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral1 - 1));
                                player.mandarADescarteDeJugador(auxiliar, naipesAlDescarte);
                            }else{
                                System.out.println("No se lograron formar 15 puntos por lo que la carta se gasta");
                                cartasCentro.añadirCarta(player.mano.get(indiceCarta-1));
                                player.mano.remove(indiceCarta-1);
                            }
                            cantidadCartas=0;
                            break;
                        case 3:
                            do {
                                System.out.println("Elige la primera carta que vas a tomar: ");
                                indiceCartaCentral1 = sc.nextInt();
                            }while(!(indiceCartaCentral1<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la segunda carta que vas a tomar: ");
                                indiceCartaCentral2 = sc.nextInt();
                            }while(!(indiceCartaCentral2<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la tercera carta que vas a tomar: ");
                                indiceCartaCentral3 = sc.nextInt();
                            }while(!(indiceCartaCentral3<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral3>=1));
                            if(player.forma15Puntos(player.mano.get(indiceCarta-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral1-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral2-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral3-1))){
                                //El Naipe auxiliar representa la carta usada por el jugador
                                auxiliar=player.mano.remove(indiceCarta-1);
                                //Los Naipes Al Descarte varian dependiendo del case
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral3-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral2-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral1-1));
                                player.mandarADescarteDeJugador(auxiliar,naipesAlDescarte);
                            }else{
                                System.out.println("No se lograron formar 15 puntos por lo que la carta se gasta");
                                cartasCentro.añadirCarta(player.mano.get(indiceCarta-1));
                                player.mano.remove(indiceCarta-1);
                            }
                            cantidadCartas=0;
                            break;
                        case 4:
                            do {
                                System.out.println("Elige la primera carta que vas a tomar: ");
                                indiceCartaCentral1 = sc.nextInt();
                            }while(!(indiceCartaCentral1<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la segunda carta que vas a tomar: ");
                                indiceCartaCentral2 = sc.nextInt();
                            }while(!(indiceCartaCentral2<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la tercera carta que vas a tomar: ");
                                indiceCartaCentral3 = sc.nextInt();
                            }while(!(indiceCartaCentral3<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral3>=1));
                            do {
                                System.out.println("Elige la cuarta carta que vas a tomar: ");
                                indiceCartaCentral4 = sc.nextInt();
                            }while(!(indiceCartaCentral4<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral4>=1));
                            if(player.forma15Puntos(player.mano.get(indiceCarta-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral1-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral2-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral3-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral4-1))){
                                //El Naipe auxiliar representa la carta usada por el jugador
                                auxiliar=player.mano.remove(indiceCarta-1);
                                //Los Naipes Al Descarte varian dependiendo del case
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral4-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral3-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral2-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral1-1));
                                player.mandarADescarteDeJugador(auxiliar,naipesAlDescarte);
                            }else{
                                System.out.println("No se lograron formar 15 puntos por lo que la carta se gasta");
                                cartasCentro.añadirCarta(player.mano.get(indiceCarta-1));
                                player.mano.remove(indiceCarta-1);
                            }
                            cantidadCartas=0;
                            break;
                        case 5:
                            do {
                                System.out.println("Elige la primera carta que vas a tomar: ");
                                indiceCartaCentral1 = sc.nextInt();
                            }while(!(indiceCartaCentral1<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la segunda carta que vas a tomar: ");
                                indiceCartaCentral2 = sc.nextInt();
                            }while(!(indiceCartaCentral2<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la tercera carta que vas a tomar: ");
                                indiceCartaCentral3 = sc.nextInt();
                            }while(!(indiceCartaCentral3<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral3>=1));
                            do {
                                System.out.println("Elige la cuarta carta que vas a tomar: ");
                                indiceCartaCentral4 = sc.nextInt();
                            }while(!(indiceCartaCentral4<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral4>=1));
                            do {
                                System.out.println("Elige la quinta carta que vas a tomar: ");
                                indiceCartaCentral5 = sc.nextInt();
                            }while(!(indiceCartaCentral5<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral5>=1));
                            if(player.forma15Puntos(player.mano.get(indiceCarta-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral1-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral2-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral3-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral4-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral5-1))){
                                //El Naipe auxiliar representa la carta usada por el jugador
                                auxiliar=player.mano.remove(indiceCarta-1);
                                //Los Naipes Al Descarte varian dependiendo del case
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral5-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral4-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral3-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral2-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral1-1));
                                player.mandarADescarteDeJugador(auxiliar,naipesAlDescarte);
                            }else{
                                System.out.println("No se lograron formar 15 puntos por lo que la carta se gasta");
                                cartasCentro.añadirCarta(player.mano.get(indiceCarta-1));
                                player.mano.remove(indiceCarta-1);
                            }
                            cantidadCartas=0;
                            break;
                        case 6:
                            do {
                                System.out.println("Elige la primera carta que vas a tomar: ");
                                indiceCartaCentral1 = sc.nextInt();
                            }while(!(indiceCartaCentral1<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la segunda carta que vas a tomar: ");
                                indiceCartaCentral2 = sc.nextInt();
                            }while(!(indiceCartaCentral2<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la tercera carta que vas a tomar: ");
                                indiceCartaCentral3 = sc.nextInt();
                            }while(!(indiceCartaCentral3<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral3>=1));
                            do {
                                System.out.println("Elige la cuarta carta que vas a tomar: ");
                                indiceCartaCentral4 = sc.nextInt();
                            }while(!(indiceCartaCentral4<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral4>=1));
                            do {
                                System.out.println("Elige la quinta carta que vas a tomar: ");
                                indiceCartaCentral5 = sc.nextInt();
                            }while(!(indiceCartaCentral5<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral5>=1));
                            do {
                                System.out.println("Elige la sexta carta que vas a tomar: ");
                                indiceCartaCentral6 = sc.nextInt();
                            }while(!(indiceCartaCentral6<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral6>=1));
                            if(player.forma15Puntos(player.mano.get(indiceCarta-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral1-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral2-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral3-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral4-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral5-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral6-1))){
                                //El Naipe auxiliar representa la carta usada por el jugador
                                auxiliar=player.mano.remove(indiceCarta-1);
                                //Los Naipes Al Descarte varian dependiendo del case
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral6-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral5-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral4-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral3-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral2-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral1-1));
                                player.mandarADescarteDeJugador(auxiliar,naipesAlDescarte);
                            }else{
                                System.out.println("No se lograron formar 15 puntos por lo que la carta se gasta");
                                cartasCentro.añadirCarta(player.mano.get(indiceCarta-1));
                                player.mano.remove(indiceCarta-1);
                            }
                            cantidadCartas=0;
                            break;
                        case 7:
                            do {
                                System.out.println("Elige la primera carta que vas a tomar: ");
                                indiceCartaCentral1 = sc.nextInt();
                            }while(!(indiceCartaCentral1<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la segunda carta que vas a tomar: ");
                                indiceCartaCentral2 = sc.nextInt();
                            }while(!(indiceCartaCentral2<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la tercera carta que vas a tomar: ");
                                indiceCartaCentral3 = sc.nextInt();
                            }while(!(indiceCartaCentral3<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral3>=1));
                            do {
                                System.out.println("Elige la cuarta carta que vas a tomar: ");
                                indiceCartaCentral4 = sc.nextInt();
                            }while(!(indiceCartaCentral4<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral4>=1));
                            do {
                                System.out.println("Elige la quinta carta que vas a tomar: ");
                                indiceCartaCentral5 = sc.nextInt();
                            }while(!(indiceCartaCentral5<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral5>=1));
                            do {
                                System.out.println("Elige la sexta carta que vas a tomar: ");
                                indiceCartaCentral6 = sc.nextInt();
                            }while(!(indiceCartaCentral6<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral6>=1));
                            do {
                                System.out.println("Elige la septima carta que vas a tomar: ");
                                indiceCartaCentral7 = sc.nextInt();
                            }while(!(indiceCartaCentral7<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral7>=1));
                            if(player.forma15Puntos(player.mano.get(indiceCarta-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral1-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral2-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral3-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral4-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral5-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral6-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral7-1))){
                                //El Naipe auxiliar representa la carta usada por el jugador
                                auxiliar=player.mano.remove(indiceCarta-1);
                                //Los Naipes Al Descarte varian dependiendo del case
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral7-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral6-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral5-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral4-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral3-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral2-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral1-1));
                                player.mandarADescarteDeJugador(auxiliar,naipesAlDescarte);
                            }else{
                                System.out.println("No se lograron formar 15 puntos por lo que la carta se gasta");
                                cartasCentro.añadirCarta(player.mano.get(indiceCarta-1));
                                player.mano.remove(indiceCarta-1);
                            }
                            cantidadCartas=0;
                            break;
                        case 8:
                            do {
                                System.out.println("Elige la primera carta que vas a tomar: ");
                                indiceCartaCentral1 = sc.nextInt();
                            }while(!(indiceCartaCentral1<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la segunda carta que vas a tomar: ");
                                indiceCartaCentral2 = sc.nextInt();
                            }while(!(indiceCartaCentral2<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral1>=1));
                            do {
                                System.out.println("Elige la tercera carta que vas a tomar: ");
                                indiceCartaCentral3 = sc.nextInt();
                            }while(!(indiceCartaCentral3<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral3>=1));
                            do {
                                System.out.println("Elige la cuarta carta que vas a tomar: ");
                                indiceCartaCentral4 = sc.nextInt();
                            }while(!(indiceCartaCentral4<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral4>=1));
                            do {
                                System.out.println("Elige la quinta carta que vas a tomar: ");
                                indiceCartaCentral5 = sc.nextInt();
                            }while(!(indiceCartaCentral5<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral5>=1));
                            do {
                                System.out.println("Elige la sexta carta que vas a tomar: ");
                                indiceCartaCentral6 = sc.nextInt();
                            }while(!(indiceCartaCentral6<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral6>=1));
                            do {
                                System.out.println("Elige la septima carta que vas a tomar: ");
                                indiceCartaCentral7 = sc.nextInt();
                            }while(!(indiceCartaCentral7<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral7>=1));
                            do {
                                System.out.println("Elige la octava carta que vas a tomar: ");
                                indiceCartaCentral8 = sc.nextInt();
                            }while(!(indiceCartaCentral8<=cartasCentro.getCantidadDeCartasEnTablero()&&indiceCartaCentral8>=1));
                            if(player.forma15Puntos(player.mano.get(indiceCarta-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral1-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral2-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral3-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral4-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral5-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral6-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral7-1),
                                    cartasCentro.cartasCentrales.get(indiceCartaCentral8-1))){
                                //El Naipe auxiliar representa la carta usada por el jugador
                                auxiliar=player.mano.remove(indiceCarta-1);
                                //Los Naipes Al Descarte varian dependiendo del case
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral7-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral6-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral5-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral4-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral3-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral2-1));
                                naipesAlDescarte.add(cartasCentro.cartasCentrales.remove(indiceCartaCentral1-1));
                                player.mandarADescarteDeJugador(auxiliar,naipesAlDescarte);
                            }else{
                                System.out.println("No se lograron formar 15 puntos por lo que la carta se gasta");
                                cartasCentro.añadirCarta(player.mano.get(indiceCarta-1));
                                player.mano.remove(indiceCarta-1);
                            }
                            cantidadCartas=0;
                                break;
                        default:
                            System.out.println("No se puede hacer una sumatoria de 15 con esas cartas");
                            break;
                    }
                }

            }while(cantidadCartas<0 || cantidadCartas>cartasCentro.getCantidadDeCartasEnTablero());

        }
    }


    /**
     * Se encarga de mostrar las cartas del tablero. dezconosco como hacerlo sin el for
     * tenme piedad que java me esta comiendo lo poco que me queda de sanidad
     */
    public void mostrarTablero(){

        cartasCentro.mostrarCentro();
    }

    /**
     * Verificación para saber si el juego sigue en marcha
     */
    public boolean verificarJuego(){
        boolean juegoSigue= true;
        int contadorManosVacias=0;

        for(Jugador jugador: jugadores){
            if(jugador.getCantidadCartasEnMano()==0) {
                contadorManosVacias++;
            }
        }
        if(baraja.getCantidadCartas()==0 && contadorManosVacias == jugadores.size()){
            juegoSigue=false;
        }
        return juegoSigue;
    }

    }


