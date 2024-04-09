import java.util.ArrayList;

public class Test {

    Baraja cartas = new Baraja();

    public static void main(String[] args){
        Tablero tablero = new Tablero();
        Naipe carta = new Naipe(1,"oro",false,1);
        carta.volverVisible();
    }
}
