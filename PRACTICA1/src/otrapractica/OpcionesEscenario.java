
package otrapractica;

import java.util.Scanner;

public class OpcionesEscenario {
        
    Scanner escenario = new Scanner(System.in);
    
    EscenarioPequeno escenarioPequeno[] =  new EscenarioPequeno[200]; 
    EscenarioMediano escenarioMediano[] =  new EscenarioMediano[200]; 
    EscenarioGrande escenarioGrande[] =  new EscenarioGrande[200]; 
    OpcionesEscenario copiaEscenario[] = new OpcionesEscenario[200];
    
    protected int opcion,opcionContinuar;
    int contadorPeque = 0,contadorMediano = 0,contadorGrande =0;
    int opcionLista,opcionEscenarioJuego;
    
    OpcionVehiculo vehiculo;
    //metodo constructor para la clase opcion vehiculo
    public OpcionesEscenario(OpcionVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    //metodo para seleccionar el escenario y crearlo
    public void escenario(){
        seleccionarEscenario();
        definirEscenario();
    }
    public void seleccionarEscenario(){
        System.out.println("\n| SELECCIONE EL TAMAÑO DE ESCENARIO QUE DESEA CREAR: ");
        System.out.println("| 1. Escenario Pequeño (4X5)");
        System.out.println("| 2. Escenario Mediano (5X7)");
        System.out.println("| 3. Escenario Grande  (6X9)");        
        System.out.print("| SELECCIONE EL TAMAÑO DEL ESCENARIO: ");
        opcion = escenario.nextInt();
    }
    //metodo para seleccionar la dimension del escenario y asi crearlo 
    public void definirEscenario(){
        
        switch(opcion){
            case 1:
                arregloEscenarioPequeno();
                crearEscenario();
                respuestaContinuar();
                break;
            case 2:
                arregloEscenarioMediano();
                crearEscenario();
                respuestaContinuar();
                break;
            case 3:
                arregloEscenarioGrande();
                crearEscenario();
                respuestaContinuar();
                break;
            case 4:
                
                break;
            default:
                System.out.println("\n| OPCIÓN INCORRECTA\n");
                escenario();
        }
    }    
    //metodo para el objeto arreglo del escenario pequeño
    public EscenarioPequeno[] arregloEscenarioPequeno(){        
        escenarioPequeno[contadorPeque] = new EscenarioPequeno(vehiculo);
        escenarioPequeno[contadorPeque].opcionesEscenario();
        escenarioPequeno[contadorPeque].opcionElegida();
        contadorPeque++;
        return escenarioPequeno;
    }
    //metodo para el objeto arreglo del escenario mediano
    public EscenarioMediano[] arregloEscenarioMediano(){        
        escenarioMediano[contadorMediano] = new EscenarioMediano(vehiculo);
        escenarioMediano[contadorMediano].opcionesEscenario();
        escenarioMediano[contadorMediano].opcionElegida();        
        contadorMediano++;
        return escenarioMediano;
    }
    //metodo para el objeto arreglo del escenario grande
    public EscenarioGrande[] arregloEscenarioGrande(){        
        escenarioGrande[contadorGrande] = new EscenarioGrande(vehiculo);
        escenarioGrande[contadorGrande].opcionesEscenario();
        escenarioGrande[contadorGrande].opcionElegida();        
        contadorGrande++;
        return escenarioGrande;
    }
    //metodo para seguir creando escenarios
    public int crearEscenario(){
        System.out.println("\033[37m\n| ¿DESEA CREAR OTRO ESCENARIO?: ");
        System.out.println("| 1. Si deseo hacerlo.");
        System.out.println("| 2. No por ahora.");
        System.out.print("| Ingrese una opción: ");
        return opcionContinuar = escenario.nextInt();
    }
    //metodo para verificar la respuesta continuar
    public void respuestaContinuar(){
        switch(opcionContinuar){
            case 1:
                seleccionarEscenario();
                definirEscenario();
                break;
            case 2:
                System.out.println("\n--------------------- \n| REGRESARÁ AL MENÚ |\n---------------------");                
                break;
        
        }
    }
    //metdo para mostrar los escenarios creados
    public void mostrarListasEscenario(){
        menuListaEscenario();
        mostrarLista();
    }
    //metodo para la lista de escenarios
    public int menuListaEscenario(){        
        System.out.println("\n| LISTA DE ESCENARIOS:");
        System.out.println("| 1. Escenarios Pequeños ");
        System.out.println("| 2. Escenarios Medianos");
        System.out.println("| 3. Escenarios Grandes");
        System.out.print("| ELIJA UNA LISTA: ");
        return opcionLista = escenario.nextInt();
    }
    int retornoLista;
    public int numeroLista(){
        return retornoLista = opcionLista;
    }
    //metodo para mostrar cada lista por tamaño
    public void mostrarLista(){
        switch(opcionLista){
            case 1:
                listaPequena();
                break;
            case 2:
                listaMediana();
                break;
            case 3:
                listaGrande();
                break;
        }
    }
    //metodo para generar la lista pequeña
    public void listaPequena(){
        
        for (int x=0; x < contadorPeque ; x++) {            
            System.out.println("\n\n\033[35mESCENARIO # "+(x+1));
            escenarioPequeno[x].generarEscenario();
        }               
    }
    //metodo para generar la lista mediana
    public void listaMediana(){
        
        for (int x=0; x < contadorMediano ; x++) {            
            System.out.println("\n\n\033[35mESCENARIO # "+(x+1));
            escenarioMediano[x].generarEscenario();
        }               
    }
    //metodo para generar la lista grande
    public void listaGrande(){
        
        for (int x=0; x < contadorGrande ; x++) {            
            System.out.println("\n\n\033[35mESCENARIO # "+(x+1));
            escenarioGrande[x].generarEscenario();
        }               
    }
    //metod para seleccionar cualquier escenario para jugar
    public int menuSeleccionEscenario(){
        System.out.print("\n\n| ELIJA EL NÚMERO DEL ESCENARIO QUE DESEA USAR: ");
        return opcionEscenarioJuego = escenario.nextInt();
    }
    //metodo que selecciona el escenario e inicia el juego
    public void seleccionEscenario(){        
        switch(opcionLista){
            case 1:                
                
                System.out.println("\n\n\n\n\033[35m|     ---HA ELEGIDO SU ESCENARIO--- |\033[37m\n\n");
                escenarioPequeno[(opcionEscenarioJuego-1)].dibujosVehiculos();
                break;
            case 2:
                
                System.out.println("\n\n\n\n\033[35m|     ---HA ELEGIDO SU ESCENARIO--- |\033[37m\n\n");
                escenarioMediano[(opcionEscenarioJuego-1)].dibujosVehiculos();                
                break;
            case 3:
                
                System.out.println("\n\n\n\n\033[35m|     ---HA ELEGIDO SU ESCENARIO--- |\033[37m\n\n");
                escenarioGrande[(opcionEscenarioJuego-1)].dibujosVehiculos();                
                break;
       } 
    }           
    //generar escenario elegido
    public void escenarioJuego(){
        switch(opcionLista){
            case 1: 
                escenarioPequeno[(opcionEscenarioJuego-1)].generarEscenario();                
                break;
            case 2: 
                escenarioMediano[(opcionEscenarioJuego-1)].generarEscenario();
                break;
            case 3: 
                escenarioGrande[(opcionEscenarioJuego-1)].generarEscenario();
                break;    
        }
    }
    //metodos para ver las listas de vehiculos
    public void pequenoListadoVehiculos(){
        escenarioPequeno[(opcionEscenarioJuego-1)].seleccionarVehiculos();                                   
    }
    public void medianoListadoVehiculos(){
        escenarioMediano[(opcionEscenarioJuego-1)].seleccionarVehiculos();
    }
    public void grandeListadoVehiculos(){
        escenarioGrande[(opcionEscenarioJuego-1)].seleccionarVehiculos();
    }
    //metodos para mover los vehiculos en los escenarios de tamaño pequeño
    public void pequenoVehiculo1(){
        escenarioPequeno[(opcionEscenarioJuego-1)].seleccionVehiculo1();        
    }
    public void pequenoVehiculo2(){
        escenarioPequeno[(opcionEscenarioJuego-1)].seleccionVehiculo2();
    }
    public void pequenoVehiculo3(){
        escenarioPequeno[(opcionEscenarioJuego-1)].seleccionVehiculo3();        
    }
    //metodos para mover los vehiculos en los escenarios de tamaño mediano
    public void medianoVehiculo1(){
        escenarioMediano[(opcionEscenarioJuego-1)].seleccionVehiculo1();
    }
    public void medianoVehiculo2(){
        escenarioMediano[(opcionEscenarioJuego-1)].seleccionVehiculo2();
    }
    public void medianoVehiculo3(){
        escenarioMediano[(opcionEscenarioJuego-1)].seleccionVehiculo3();
    }
    //metodos para mover los vehiculos en los escenarios de tamaño grande
    public void grandeVehiculo1(){
        escenarioGrande[(opcionEscenarioJuego-1)].seleccionVehiculo1();
    }
    public void grandeVehiculo2(){
        escenarioGrande[(opcionEscenarioJuego-1)].seleccionVehiculo2();
    }
    public void grandeVehiculo3(){
        escenarioGrande[(opcionEscenarioJuego-1)].seleccionVehiculo3();
    }    
    
}

