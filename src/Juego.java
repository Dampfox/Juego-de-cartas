import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Juego {
    //jalamos las clases anteriores y usando list para crear los datos
    private List<Jugador> jugadores;
    private List<Cartas> cartas;
    private int numeroRondas;

    public Juego(int numJugadores) {
        this.jugadores = crearJugadores(numJugadores);
    }

    //crear jugadores
    private List<Jugador> crearJugadores(int numJugadores) {
        List<Jugador> jugadores = new ArrayList<Jugador>();
        for (int i = 0; i < numJugadores; i++) {
            jugadores.add(new Jugador("Jugador" + i, 50));
        }
        return jugadores;
    }

    //crear baraja
    public List<Cartas> crearBaraja() {
        List<Cartas> baraja = new ArrayList<>();
        String[] simbolos = {"Corazon", "Diamante", "Trebol", "Espadas"};
        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8"};

        for (String simbolo : simbolos) {
            for (String valor : valores) {
                Cartas carta = new Cartas(valor, simbolo);
                baraja.add(carta);
            }
        }
        return baraja;
    }

    //revolver las cartas
    private void barajar() {
        Collections.shuffle(cartas);
    }

    private void repartirCartas() {
        for (Jugador jugador : jugadores) {//recorre todos los jugadores
            for (int i = 0; i < 5; i++) {//reparte 5 cartas
                jugador.agregarCarta(cartas.remove(0));//remueve cartas para que no se repitan entre jugadores
            }
        }
    }

    private void limpiarCartas() {
        for (Jugador jugador : jugadores) {
            jugador.borrarCarta();
        }
    }

    public Juego(int numeroJugadores, int numeroRondas) {
        this.jugadores = crearJugadores(numeroJugadores);
        this.numeroRondas = numeroRondas;
    }

    private void mostrarCartas() {
        for (Jugador jugador : jugadores) {
            //meustra al jugador y las cartas que tiene
            System.out.println(jugador.getNombre() + ": " + jugador.getCartas());
        }
    }

    private void jugarCarta() {
        for (Jugador jugador : jugadores) {
            int valorCarta = jugador.jugarCarta().getValorNumerico();
            System.out.println("Jugador: " + jugador.getNombre() + " carta seleccionada " + valorCarta);
        }
    }

    public void jugar() {
        for (int ronda = 0; ronda < numeroRondas; ronda++) {
            System.out.println("Ronda: " + (ronda + 1));
            this.cartas = crearBaraja();
            barajar();
            repartirCartas();
            mostrarCartas();
            jugarCarta();
        }

        // Determinar el ganador al final de todas las rondas
        Jugador ganador = null;
        int maxPuntos = 0;
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " tiene un total de " + jugador.getPunteo() + " puntos.");
            if (jugador.getPunteo() > maxPuntos) {
                maxPuntos = jugador.getPunteo();
                ganador = jugador;
            }
        }

        if (ganador != null) {
            System.out.println("El ganador es " + ganador.getNombre() + " con " + maxPuntos + " puntos.");
        } else
            System.out.println("Hubo un empate.");
        }
    }

