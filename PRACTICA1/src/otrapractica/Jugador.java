
package otrapractica;

public class Jugador {
    private String nombreJugador;
    //Metod get para poder enviar la informacion
    public String getNombreJugador() {
        return nombreJugador;
    }
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    //constructor para el jugador 
    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    
    
}
