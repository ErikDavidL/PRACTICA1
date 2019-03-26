
package otrapractica;

import java.util.Scanner;

public class datosJuego {
    
    Scanner juego = new Scanner(System.in);
    OpcionesEscenario escenarios;
    TiendaJuego armas;
    OpcionVehiculo vehiculos;
    Ataque ataque;
    
    
    protected int opcionEscenario;
    
    //metodos constructores
    public datosJuego(OpcionesEscenario escenarios) {
        this.escenarios = escenarios;
    }

    public datosJuego(OpcionVehiculo vehiculos) {
        this.vehiculos = vehiculos;
    }    

    public datosJuego(Ataque ataque) {
        this.ataque = ataque;
    }
    
    //metodos para inicializar la jugabilidad que se llevará a cabo    
    public void juego(){
        inicioJuego();
        escenarios.mostrarListasEscenario();
        seleccionarDimensionEscenario();
    }
    public void inicioJuego(){    
        System.out.println("\n\033[35m                ---INICIO DEL JUEGO---");
        System.out.println("\033[37m| INICIARÁ EL JUEGO SELECCIONANDO EL ESCENARIO DONDE JUGARÁ");
        System.out.println("| SE LE MOSTRARÁN LOS ESCENARIOS DISPONIBLES PARA EL JUEGO \n");
    }
    
    String escenarioJuego[][];
    //metodo para seleccionar los escenarios para jugar
    public void seleccionarDimensionEscenario(){
        escenarios.menuSeleccionEscenario();
        escenarios.seleccionEscenario();    
               
    } 
    //metodo para generar el escenario en el juego
    public void generarEscenario(){
         escenarios.escenarioJuego();
    }
    //metodo para desplegar el listado de vehiculos
    public void listadoVehiculos(){
        vehiculos.listadoVehiculos();
    }
    ////metodo para desplegar las opciones del jugador
    public void accionJugador(){
       vehiculos.opcionesJugador();
    }
    String opcionAccion;
    //metodo para elegir un vehiculo en las acciones
    public void moverVehiculo(){        
        listaVehiculos();
        System.out.print("\n| ELIJA UN VEHICULO: ");
        opcionAccion = juego.nextLine();
        movimientosEnEscenarios();
        //seguirMoviendo
        
    }
    //metodo para ver los listados de escenarios
    public void listaVehiculos(){
        switch(escenarios.numeroLista()){
            case 1:
                escenarios.pequenoListadoVehiculos();
                break;
            case 2:
                escenarios.medianoListadoVehiculos();
                break;
            case 3:
                escenarios.grandeListadoVehiculos();
                break;
        }
    
    }
    //metodo para los movimientos en los escenarios de los vehiculos
    public void movimientosEnEscenarios(){
        switch(escenarios.numeroLista()){
            case 1:
                opcionVehiculoPequeno();
                break;
            case 2:
                opcionVehiculoMediano();
                break;
            case 3:
                opcionVehiculoGrande();
                break;
        }    
    }
    //metodo especifico de movimiento
    public void opcionVehiculoPequeno(){
        switch(opcionAccion){
            case "1":
                escenarios.pequenoVehiculo1();
                break;
            case "2":
                escenarios.pequenoVehiculo2();
                break;
            case "3":
                escenarios.pequenoVehiculo3();
                break;
        }
    }
    //metodos para elegir los vehiculos especificos en el escenario mediano
    public void opcionVehiculoMediano(){
        switch(opcionAccion){
            case "1":
                escenarios.medianoVehiculo1();
                break;
            case "2":
                escenarios.medianoVehiculo2();
                break;
            case "3":
                escenarios.medianoVehiculo3();
                break;
        }
    }
    //metodos para elegir los vehiculos especificos en el escenario grande
    public void opcionVehiculoGrande(){
        switch(opcionAccion){
            case "1":
                escenarios.grandeVehiculo1();
                break;
            case "2":
                escenarios.grandeVehiculo2();
                break;
            case "3":
                escenarios.grandeVehiculo3();
                break;
        }
    }
    String opcionContinuar;
    //opcion seguir moviendo
    public void seguirMoviendo(){
        System.out.println("\n --DESEA SEGUIR--");
        System.out.println("| 1. SI");
        System.out.println("| 2. NO");
        System.out.print("| ELIJA UNA OPCIÓN: ");
        opcionContinuar = juego.nextLine();
        switch(opcionContinuar){
            case "1":
                moverVehiculo();
                break;
            case "2":
                System.out.println("\n--------------------- \n| REGRESARÁ AL MENÚ |\n---------------------");
                break;
        }
    }
    //menu acciones del jugador
    public void seleccionarAcciones(){
        System.out.println("\n| ACCIONES DEL JUGADOR:");
        System.out.println("| 1. Atacar.");
        System.out.println("| 2. Moverse.");
        System.out.println("| 3. Cambiar de Vehículo.");
        System.out.println("| 4. Usar Objeto.");
        System.out.println("| 5. Rendirse.");
    }
    public void inicioAtaque(){
        ataque.inicioAtaque();
    }
    
    
}
