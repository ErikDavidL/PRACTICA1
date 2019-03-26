
package otrapractica;


public class Principal {


    public static void main(String[] args) {
       //objeto instanciado de la clase menu con el cual inicia todo el juego
        Menu jugar = new Menu();    
       jugar.nombreJugador();
       jugar.definirVehiculos();
       jugar.menuJuego();
    }
    
}
