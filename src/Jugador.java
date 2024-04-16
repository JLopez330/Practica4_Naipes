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

    public int getCantidadEscobas(){
        return cantidadEscobas;
    }

    public int getPuntos(){
        return puntos;
    }

    public int getIdJugador(){
        return idJugador;
    }

    public int getCantidadCartasEnMano(){
        return mano.size();
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

    public boolean forma15Puntos(ArrayList<Naipe> cartas, int indice) {
        Naipe auxiliar = mano.get(indice-1);
        int suma = auxiliar.getValor();
        boolean esValido = true;
        for (Naipe carta : cartas) {
            suma+=carta.getValor();
        }
        if(suma == 15){
            esValido=true;
        }else{
            esValido=false;
        }
        return esValido;
    }

    public boolean forma15Puntos(Naipe... cartas) {
        int suma = 0;
        for (Naipe carta : cartas) {
            suma += carta.getValor();
        }
        return suma == 15; //Está regresando que la suma es igual a 15?
        //Es una comprobación que regresa un booleano de verdadero o falso
    }


}
