
package otrapractica;

import java.util.Scanner;

public class Menu {
    Scanner juego = new Scanner(System.in);
    
    //datos y metodos para ingresar el nombre del jugador
    String nombreJugador;
    Jugador nuevoJugador = new Jugador(nombreJugador);
    
    public String nombreJugador(){
        System.out.println("\033[35m    ---BIENVENIDO AL JUEGO EL BATALLÓN FINAL---\033[37m\n\n ");
        System.out.print("\nINGRESE SU NOMBRE PARA JUGAR: ");
        return nombreJugador = juego.nextLine();        
    }
        
    //datos y metodos para los vehiculos del jugador
    OpcionVehiculo vehiculo = new OpcionVehiculo();
    public void definirVehiculos(){
        vehiculo.ingresarVehiculos();
    }
    public void listadoVehiculos(){
        vehiculo.listadoVehiculos();
    }
    public void cambiarVehiculo(){
        vehiculo.metodosSeleccionVehiculo();
    }
    //menu para las opciones del juego
    public void menuJuego(){
        Scanner numeroEscogido = new Scanner(System.in);
        boolean salir = false;
        int opcion;         
            while(!salir){
                System.out.println("\nMENÚ INICIO:");
                System.out.println("1. CREAR ARMA.");
                System.out.println("2. CREAR ESCENARIO.");
                System.out.println("3. INICIAR JUEGO.");
                System.out.println("4. TIENDA.");
                System.out.println("5. LISTADO VEHÍCULOS."); 
                System.out.println("6. LISTADO DE ESCENARIOS.");
                System.out.println("7. SALIR.");
                System.out.print("Ingrese una opción: ");
                opcion = numeroEscogido.nextInt();
                    switch(opcion){
                        case 1:
                            armas();
                            break;
                        case 2:
                            escenarios();
                            break;
                        case 3:
                            jugabilidad();
                            break;
                        case 4:
                            tienda();
                            break;
                        case 5:
                            mostrarVehiculos();
                            break;
                        case 6:
                            mostrarEscenarios();
                            break;
                        case 7:                            
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Ingrese una opción correcta");
                    }
            }
    }
    //objeto para la clase tienda del juego
    TiendaJuego armas = new TiendaJuego();
    //metodo para la creacion de armas
    public void armas(){
        armas.elegirArma();
    }
    //metodo para llamar a la tienda
    public void tienda(){
        armas.tienda();
    }
    //objeto para la clase escenario 
    OpcionesEscenario escenario = new OpcionesEscenario(vehiculo);
    //metodo para la creacion de escenarios
    public void escenarios(){
        escenario.escenario();
    }
    //metodo para mostrar los escenarios creados
    public void mostrarEscenarios(){
        escenario.mostrarListasEscenario();
    }    
    //metodo y objeto de la clase datos del juego
    datosJuego inicioJuego = new datosJuego(escenario);
    public void seleccionEscenario(){
        inicioJuego = new datosJuego(escenario);    
        inicioJuego.juego();
    }
    //metodo para generar el escenario de la clase datos del juego
    public void generarEscenario(){
        inicioJuego = new datosJuego(escenario);    
        inicioJuego.generarEscenario();
    }
    //metodo para mostrar los vehiculos ya creados
    public void mostrarVehiculos(){
        inicioJuego = new datosJuego(vehiculo);
        inicioJuego.listadoVehiculos();    
    }
    //metodo para mostrar las acciones del jugador
    public void nombreVehiculos(){
        inicioJuego = new datosJuego(vehiculo);
        inicioJuego.accionJugador();
    }
    //metodo para mover un vehiculo en los escenarios
    public void moverVehiculos(){
        inicioJuego = new datosJuego(escenario);
        inicioJuego.moverVehiculo();
    }
    int contador = 0;
    float vidaEnemigo1 = 50f;
    float vidaEnemigo2 = 50f;
    float vidaEnemigo3 = 50f;
    
    float vidaVehiculo1 = 50f;
    float vidaVehiculo2 = 50f;
    float vidaVehiculo3 = 50f;
    //metodo para iniciar la jugabilidad 
    public void jugabilidad(){
        seleccionEscenario();
        do{
            
            generarEscenario();        
            System.out.println("\n\033[35m--- ESTÁ JUGANDO EN LA PARTIDA: "+nombreJugador+" ---\033[37m             DINERO ACTUAL: Q "+dineroGanado);
            nombreVehiculos();
            inicioJuego.seleccionarAcciones();
            elegirAccion();   
            realizarAccion();        
            seguir = verdadero; 
            resultadoPartida();
            seguir = verdadero;
            } 
        while(seguir =="Seguir");
        resultadoPartida();
    }
    float dineroGanado;
    public void resultadoPartida(){
        if(vidaEnemigo1 <= 0 && vidaEnemigo2 <= 0 && vidaEnemigo3 <= 0){
            System.out.println("\nEL JUGADOR "+nombreJugador+" HA GANADO LA PARTIDA");
            verdadero = "Rendirse";
            dineroGanado = 350f;
            System.out.println("\n ----HA GANADO: Q "+dineroGanado);
        }
        if(vidaVehiculo1 <= 0 && vidaVehiculo2 <= 0 && vidaVehiculo3 <= 0){
            System.out.println("\nEL JUGADOR "+nombreJugador+" HA PERDIDO LA PARTIDA");
            verdadero = "Rendirse";
            dineroGanado = 50f;
            System.out.println("\n ----HA GANADO: Q "+dineroGanado);
        }
    }
    String opcionAccion;
    //metodo que devuelve la opcion de la accion
    public String elegirAccion(){
        System.out.print("| SELECCIONE UNA ACCIÓN: ");
        opcionAccion = juego.nextLine();
        return opcionAccion;
    }
    //metodo para mostrar a los enemigos
    public void vidaEnemigos(){
        System.out.println("\n| VIDA ENEMIGO TANQUE 25-9:              "+vidaEnemigo1);
        System.out.println("| VIDA ENEMIGO AVIÓN KAMIKASE:           "+vidaEnemigo2);
        System.out.println("| VIDA ENEMIGO HELICÓPTERO CAZA TROPAS:  "+vidaEnemigo3);
    }
    //metodo para ver la vida de nuestros vehiculos
    public void vidaVehiculos(){
        inicioAtaque = new Ataque(vehiculo);        
        System.out.println("| VIDA: "+vidaVehiculo1+"   | VEHICULO:  "+inicioAtaque.nombre1());
        System.out.println("| VIDA: "+vidaVehiculo2+"   | VEHICULO:  "+inicioAtaque.nombre2());
        System.out.println("| VIDA: "+vidaVehiculo3+"   | VEHICULO:  "+inicioAtaque.nombre3());
    }
    //metodo para modificar la vida del enemigo conforme su ataque
    public void restaVidaEnemigos(){
        vidaEnemigo1 = vidaEnemigo1 - inicioAtaque.getValorGolpe1();
        vidaEnemigo2 = vidaEnemigo2 - inicioAtaque.getValorGolpe2();
        vidaEnemigo3 = vidaEnemigo3 - inicioAtaque.getValorGolpe3();
        corregirNegativo1();
        corregirNegativo2();
        corregirNegativo3();
    }
    public void corregirNegativo1(){
        if(vidaEnemigo1 <= 0){
         vidaEnemigo1 = 0f;
        }
    }
    public void corregirNegativo2(){
        if(vidaEnemigo2 <= 0){
         vidaEnemigo2 = 0f;
        }
    }
    public void corregirNegativo3(){
        if(vidaEnemigo3 <= 0){
         vidaEnemigo3 = 0f;
        }
    }
    //metodo para restarle vida a los vehiculos
    public void restaVidaVehiculos(){
        vidaVehiculo1 = vidaVehiculo1 - inicioAtaque.getValorGolpe1();
        vidaVehiculo2 = vidaVehiculo2 - inicioAtaque.getValorGolpe2();
        vidaVehiculo3 = vidaVehiculo3 - inicioAtaque.getValorGolpe3();
        corregirVehiculo1();
        corregirVehiculo2();
        corregirVehiculo3();
    }
    public void corregirVehiculo1(){
        if(vidaVehiculo1 <= 0){
         vidaVehiculo1 = 0f;
        }
    }
    public void corregirVehiculo2(){
        if(vidaVehiculo2 <= 0){
         vidaVehiculo2 = 0f;
        }
    }
    public void corregirVehiculo3(){
        if(vidaVehiculo3 <= 0){
         vidaVehiculo3 = 0f;
        }
    }
    // metodo para escoger la accion que se realizara
    int opcionAtaque;
    String seguir,verdadero;
    public String realizarAccion(){
        switch(opcionAccion){
            case "1":
                ataque();           
                restaVidaEnemigos();                
                vidaEnemigos();
                ataqueEnemigo();
                restaVidaVehiculos();
                vidaVehiculos();
                verdadero = "Seguir";
                break;
            case "2":
                moverVehiculos();
                ataqueEnemigo();
                restaVidaVehiculos();
                vidaVehiculos();
                verdadero = "Seguir";
                break;
            case "3":
                cambiarVehiculo();
                verdadero = "Seguir";
                break;
            case "4":
                verdadero = "Seguir";
                break;
            case "5":
                verdadero = "Rendirse";
                vidaEnemigo1 = 50f;
                vidaEnemigo2 = 50f;
                vidaEnemigo3 = 50f;
                vidaVehiculo1 = 50f;
                vidaVehiculo2 = 50f;
                vidaVehiculo3 = 50f;
                dineroGanado = 50f;
                System.out.println("\n  ---HA DECIDIDO RENDIRSE, TERMINARÁ LA PARTIDA SIN RECOMPENSA---");
                break;        
        }
        return verdadero;
    }
    //metodo para iniciar el ataque
    Ataque inicioAtaque = new Ataque(vehiculo);
    public void ataque(){
        inicioAtaque = new Ataque(vehiculo);
        inicioAtaque.inicioAtaque();
    }    
    public void golpeVehiculo1(){
        inicioAtaque = new Ataque(vehiculo);   
    }
    public void tipoVehiculo1(){
        inicioAtaque = new Ataque(escenario);
        inicioAtaque.tipoVehiculo1();
    }    
    public void ataqueEnemigo(){
        inicioAtaque = new Ataque(vehiculo);
        inicioAtaque.ataqueEnemigo();
    }
    
}
