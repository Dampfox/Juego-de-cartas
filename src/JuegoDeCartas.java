import java.util.Scanner;

public class JuegoDeCartas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //lee un valor ingresado
        System.out.println("Ingrese el numero de jugadores");
        int num = sc.nextInt(); //define el tipo de dato que es la variable
        //Ingresar numeroe de partidas
        System.out.println("Ingrese el numero de partidas");
        int part = sc.nextInt();
        Juego juego = new Juego(num,part);
        juego.jugar();
    }
}
