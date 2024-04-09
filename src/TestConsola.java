public class TestConsola {

    public static void main(String[] args){
        Baraja cartas = new Baraja();

        // Ejemplo con 2 cartas
        Naipe carta1 = new Naipe(7,"oro",false); // Ejemplo de valor de la carta
        Naipe carta2 = new Naipe(8,"oro",false); // Ejemplo de valor de la carta
        boolean resultado1 = cartas.forma15Puntos(carta1, carta2);
        System.out.println("¿Se forman 15 puntos con 2 cartas? " + resultado1);

        // Ejemplo con 3 cartas
        Naipe carta3 = new Naipe(5,"oro",false); // Ejemplo de valor de la carta
        boolean resultado2 = cartas.forma15Puntos(carta1, carta2, carta3);
        System.out.println("¿Se forman 15 puntos con 3 cartas? " + resultado2);

        // Ejemplo con 4 cartas
        Naipe carta4 = new Naipe(2,"oro",false); // Ejemplo de valor de la carta
        boolean resultado3 = cartas.forma15Puntos(carta1, carta2, carta3, carta4);
        System.out.println("¿Se forman 15 puntos con 4 cartas? " + resultado3);
        Naipe carta = new Naipe(1,"oro",false);
        cartas.mostrarJuego();
    }
}
