
package otrapractica;

import java.util.Random;
import java.util.Scanner;

public class EscenarioPequeno extends Escenario {
    
    Scanner datosEscenario = new Scanner(System.in);
    //variables propias de la clase
    private final int fila = 4, columna = 6;
    private String escenario[][] = new String[fila][columna];
    private String terreno;
    private String arregloTemporal[][] = new String[fila][columna];
    private String arregloEscenario[][];
    private int numeroTerreno,opcion,opcionTerreno;
    
    //metodos getter para las variables
    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    //metodo heredado de la clase padre que es escenario y permite la opcion de creacion de mapas
    @Override
    public int opcionesEscenario(){
        System.out.println("\033[37m\n| MAPA PEQUEÑO.\n| SELECCIONE EL MODO DE CREACIÓN:");
        System.out.println("| 1. Generar mapa completo de manera aleatoria.");
        System.out.println("| 2. Rellenar casilla por casilla.");
        System.out.print("| SELECCIONE EL MODO DE CREACIÓN: ");
        return opcion = datosEscenario.nextInt();
    }
    //metodo que selecciona una de las dos opciones de creacion de escenario
    public String[][] opcionElegida(){
        switch(opcion){
            case 1:
                valoresEscenario();
                generarEscenario();
                arregloTemporal();
                break;
            case 2:
                crearEscenario();
                generarEscenario();
                arregloTemporal();
                break;    
        }
        return escenario;
    }
    //metodo que asigna los valores del terreno de manera completa
    public String[][] valoresEscenario(){
        for (int w=0; w < fila ; w++) {
            for (int z=0; z < columna-1; z++) {
                escenario[w][z] = definirTerreno();                
                arregloTemporal[w][z] = terreno;
                                
            }
        }
        return escenario;
    }
    //metodo heredado que define el terreno cuando se genera de manera completa
    @Override
    public String definirTerreno(){
        numeroTerreno = generarTerreno();
        switch(numeroTerreno){
            case 1:
                terreno = "\033[32m▲▲▲▲▲▲▲";    //mostrar montañas
                break;
            case 2:
                terreno = "\033[31m▓▓▓▓▓▓▓";    //mostrar planicies
                break;
            case 3:
                terreno = "\033[36m≈≈≈≈≈≈≈";    //mostrar agua
                break;    
        }
        return terreno;    
    }
    //metodo heredado de la clase padre que genera un aleatorio para utilizar en otros metodos
    @Override
    public int generarTerreno(){
    Random numeroAleatorio = new Random();
        return numeroAleatorio.nextInt(3)+1;    
    }
    //metodo que asigna valores del terreno casilla por casilla               
    public String[][] crearEscenario(){
        int x,y;
        valoresIniciales();
        
        for (int w=0; w < fila ; w++) {
            for (int z=0; z < columna-1; z++) { 
                x = w+1;
                y = z+1;
                System.out.println("\n\n");
                generarEscenario();
                System.out.println("\n| INGRESE EL TIPO DE TERRENO");
                System.out.print("| Seleccione un tipo de terreno para la casilla de la fila["+x+"] y columna["+y+"] = ");
                opcionTerreno = datosEscenario.nextInt();
                
                switch(opcionTerreno){
                    case 1:
                        terreno = "\033[32m▲▲▲▲▲▲▲";    //mostrar montañas
                        break;
                    case 2:
                        terreno = "\033[31m▓▓▓▓▓▓▓";    //mostrar planicies
                        break;
                    case 3:
                        terreno = "\033[36m≈≈≈≈≈≈≈";    //mostrar agua
                        break; 
                    default:
                        terreno = "\033[31m▓▓▓▓▓▓▓";    //mostrar planicies
                        System.out.println("\n\n\n\n-------------------------------------------------------------------------------------");
                        System.out.println("\033[37m| SELECCIONÓ UNA OPCIÓN INCORRECTA, SE LE ASIGNARÁ EL # TERRENO PLANO # POR DEFECTO |");
                        System.out.println("-------------------------------------------------------------------------------------");
                }
                escenario[w][z] = terreno;
                arregloTemporal[w][z] = terreno;
            }
        }
        return escenario;    
    }
    //metodo que genera las casillas vacias
    public String[][] valoresIniciales(){
        for (int w=0; w < fila ; w++) {
            for (int z=0; z < columna-1; z++) {
                                escenario[w][z] = " VACÍO ";
            }
        }
        return escenario;
    }
    //metodo que genera el escenario ya estructurado con valores del arreglo escenario
    @Override
    public String[][] generarEscenario(){
        System.out.println("");
        System.out.println("       A       B       C       D       E    ");
        System.out.println("   -----------------------------------------");
        for (int x=0; x < fila ; x++) {
            System.out.println("   |       |       |       |       |       |");
                                System.out.print("\033[37m"+(x+1)+"  \033[37m|");
                        for (int y=0; y < columna-1; y++) {
                                System.out.print (escenario[x][y]);
                            if (y!=escenario[x].length-1) System.out.print("\033[37m|");
                        }
                                System.out.println("");
                                System.out.println("   |       |       |       |       |       |");
                                System.out.println("   -----------------------------------------");
        }
        System.out.println("\n 1. \033[37mMontañas: \033[32m▲▲▲▲▲▲▲ \033[37m           2. Terreno Plano: \033[31m▓▓▓▓▓▓▓ \033[37m          3. Agua: \033[36m≈≈≈≈≈≈≈ \033[37m          4. Enemigos: \033[35m▼▼▼▼▼\033[37m");
        return escenario;
    }
    //metodo que regresa el arreglo a como era al inicio
    public String[][] regresarEscenario(){
        escenario = arregloTemporal;
        return escenario;
    }
    //arreglo temporal que se utilizará para los metodos de movilización de los vehículos
    public String[][] arregloTemporal(){
        arregloEscenario = escenario.clone();
        return arregloEscenario;
    } 
    //seccion donde empiezan los metodos para dibujar los vehiculos de acuerdo al tipo en el escenario que haya escogido el jugador
    OpcionVehiculo dibujoVehiculo;

    public EscenarioPequeno(OpcionVehiculo dibujoVehiculo) {
        this.dibujoVehiculo = dibujoVehiculo;
    }    
    //metodos para dibujar los vehiculos en las primeras casillas al iniciar el juego
    public String dibujoVehiculo1(){
        if(dibujoVehiculo.dibujarVehiculo1() == "Tanque"){ 
            escenario[3][1] = "\033[35m║║\033[33m=╧=\033[35m║║\033[37m";
        }else{
            escenario[3][1] = "\033[35m║\033[33m__▲__\033[35m║\033[37m";
        }        
        return escenario[3][1];
    }
    public String dibujoVehiculo2(){
        if(dibujoVehiculo.dibujarVehiculo2() == "Tanque"){
            escenario[3][2] = "\033[35m║║\033[34m=╧=\033[35m║║\033[37m";
        }else{
            escenario[3][2] = "\033[35m║\033[34m__▲__\033[35m║\033[37m";
        }                               
        return escenario[3][2];
    }
    
    public String dibujoVehiculo3(){
        if(dibujoVehiculo.dibujarVehiculo3() == "Tanque"){
            escenario[3][3] = "\033[35m║║\033[37m=╧=\033[35m║║\033[37m";
        }else{
            escenario[3][3] = "\033[35m║\033[37m__▲__\033[35m║\033[37m";
        }                    
        return escenario[3][3];
    }
    public String enemigo1(){
            escenario[0][1] = "\033[35m ▼▼▼▼▼ \033[37m";
        return escenario[0][1];
    }
    //metodos para los dibujos que se utilizaran posteriormente en la seccion de movimientos de vehiculos
    public String enemigo2(){
            escenario[0][2] = "\033[35m ▼▼▼▼▼ \033[37m";
        return escenario[0][2];
    }
    public String enemigo3(){
            escenario[0][3] = "\033[35m ▼▼▼▼▼ \033[37m";
        return escenario[0][3];
    }
     //metodo que almacena los valores del dibujo de cada vehiculo
    public void dibujosVehiculos(){
        dibujoVehiculo1();
        dibujoVehiculo2();
        dibujoVehiculo3();
        enemigo1();
        enemigo2();
        enemigo3();
    }
    //seccion donde empiezan los metodos para seleccionar y mover los dibujos de los vehiculos
    protected int movFila,movColumna;
    protected String numeroColumna,numeroFila,arreglador;
    
    public void arreglador(){
    System.out.println("\n| SELECCIONE LA POSICIÓN");
        arreglador = datosEscenario.nextLine();
    }
    //metodo para ingresar la columna a donde se desea mover
    public String movimientoFila(){
        System.out.print("\n| NÚMERO DE FILA: ");        
        numeroFila = datosEscenario.nextLine();
        return numeroFila;
    }
    //metodo para definir el valor de la fila
    public int definirFila(){
        switch(numeroFila){
            case "1":
                movFila = 0;
                break;
            case "2":
                movFila = 1;
                break;
            case "3":
                movFila = 2;
                break;
            case "4":
                movFila = 3;
                break; 
            default:
                System.out.println("  --ERROR--INGRESE UN VALOR CORRECTO--");
                repetirFila();
        }
        return movFila;
    }
    //metodo que repite si la opcion es incorrecta de la fila
    public int repetirFila(){
        movimientoFila();
        definirFila();
        return movFila;
    }
    //metodo para ingresar la columna a donde se desea mover
    public String movimientoColumna(){
        System.out.print("| LETRA DE LA COLUMNA: ");
        numeroColumna = datosEscenario.nextLine().toLowerCase();
        return numeroColumna;       
    } 
    //metodo que define el valor de columna
    public int definirColumna(){
        switch(numeroColumna){
            case "a":
                movColumna = 0;
                break;
            case "b":
                movColumna = 1;
                break;
            case "c":
                movColumna = 2;
                break;
            case "d":
                movColumna = 3;
                break;
            case "e":
                movColumna = 4;
                break;        
            default:
                System.out.println("  --ERROR--INGRESE UN VALOR CORRECTO--");
                repetirColumna();
        }
        return movColumna;
    }
    //metodo para repetir la eleccion de la columna si se equivoca
    public int repetirColumna(){
        movimientoColumna();
        definirColumna();
        return movColumna;
    }
    String dibujo1,dibujo2,dibujo3,dibujoBusqueda;
    //metodo para seleccionar el vehiculo que se movera
    public void seleccionarVehiculos(){
        System.out.println("\n| SELECCIONE EL VEHICULO QUE MOVERÁ:");
        dibujoVehiculo.nombreVehiculos();
    }
    int numeroArreglo = 0;   
    //metodo que asigna el dibujo dependiendo del tipo de vehiculo
    public String dibujo1(){
        if(dibujoVehiculo.dibujarVehiculo1() == "Tanque"){ 
            dibujo1 = "\033[35m║║\033[33m=╧=\033[35m║║\033[37m";
        }else{
            dibujo1 = "\033[35m║\033[33m__▲__\033[35m║\033[37m";
        }        
        return dibujo1;
    }
    //metodo para el movimiento del vehiculo
    public void moverVehiculoSeleccionado(){
        if(numeroArreglo == 0){
            arreglador();}        
        movimientoFila();
        definirFila();
        movimientoColumna();
        definirColumna();                       
        buscarVehiculo();                
        numeroArreglo++;
    }
    int contadorBuscar;
    int buscarFila,buscarColumna;
    //metodo para buscar la posicion del vehiculo
    public void buscarVehiculo(){
    contadorBuscar=0;
        for(int i=0;i< 4;i++){
            for(int j=0;j< 6;j++){
                if(escenario[i][j] == dibujoBusqueda){                    
                     buscarFila=i;
                     buscarColumna=j;   
                }
                contadorBuscar++;
            }
        }            
    }
    //metodo PARA selecionar y mover el vehiuclo
    public void seleccionVehiculo1(){
        dibujoBusqueda = dibujo1();        
        moverVehiculoSeleccionado();
        moverVehiculo1();
    }    
    
    String valorAnterior;
    //metodos que ubican la posicion del vehiculo 1,2 y 3
    public String[][] moverVehiculo1(){
        // si el vehículo es un tanque
        if(dibujo1 == "\033[35m║║\033[33m=╧=\033[35m║║\033[37m"){
            //si el terreno es agua
            if(escenario[movFila][movColumna] == "\033[36m≈≈≈≈≈≈≈"){
                System.out.println("\n  ---EL VEHICULO NO PUEDE MOVERSE YA QUE ES TIPO TANQUE Y NO PUEDE ESTAR EN AGUA---\n");
                seleccionVehiculo1();
            }else{
                //si el terreno son montañas o planicies
                if(escenario[movFila][movColumna] == "\033[32m▲▲▲▲▲▲▲" || escenario[movFila][movColumna] == "\033[31m▓▓▓▓▓▓▓"){
                    valorAnterior = arregloTemporal[buscarFila][buscarColumna];
                    escenario[buscarFila][buscarColumna] = valorAnterior;
                    escenario[movFila][movColumna] = dibujo1;
                }else{         
                System.out.println("\n  ---MOVIMIENTO INCORRECTO, SE ENCUENTRA UN VEHICULO EN ESA POSICION---\n");
                seleccionVehiculo1();
                }
            }
        }
        //si el vehiculo es un avión
        if(dibujo1 == "\033[35m║\033[33m__▲__\033[35m║\033[37m"){
            //si el terreno son montañas
            if(escenario[movFila][movColumna] == "\033[32m▲▲▲▲▲▲▲"){
                System.out.println("\n  ---EL VEHICULO NO PUEDE MOVERSE YA QUE ES TIPO AVIÓN Y NO PUEDE ATRAVESAR MONTAÑAS---\n");                
                seleccionVehiculo1();
            }else{
                //si el terreno es agua o planicies
                if(escenario[movFila][movColumna] == "\033[36m≈≈≈≈≈≈≈" || escenario[movFila][movColumna] == "\033[31m▓▓▓▓▓▓▓"){
                    valorAnterior = arregloTemporal[buscarFila][buscarColumna];
                    escenario[buscarFila][buscarColumna] = valorAnterior;
                    escenario[movFila][movColumna] = dibujo1;
                }else{
                System.out.println("\n  ---MOVIMIENTO INCORRECTO, SE ENCUENTRA UN VEHICULO EN ESA POSICION---\n");
                seleccionVehiculo1();
                }
            }
        }
        return escenario;
    }
    public String dibujo2(){
        if(dibujoVehiculo.dibujarVehiculo2() == "Tanque"){
            dibujo2 = "\033[35m║║\033[34m=╧=\033[35m║║\033[37m";
        }else{
            dibujo2 = "\033[35m║\033[34m__▲__\033[35m║\033[37m";
        }                               
        return dibujo2;
    }
    public void seleccionVehiculo2(){
        dibujoBusqueda = dibujo2();  
        moverVehiculoSeleccionado();
        moverVehiculo2();
      
    }
    public String[][] moverVehiculo2(){
        // si el vehículo es un tanque
        if(dibujo2 == "\033[35m║║\033[34m=╧=\033[35m║║\033[37m"){
            //si el terreno es agua
            if(escenario[movFila][movColumna] == "\033[36m≈≈≈≈≈≈≈"){
                System.out.println("\n  ---EL VEHICULO NO PUEDE MOVERSE YA QUE ES TIPO TANQUE Y NO PUEDE ESTAR EN AGUA---\n");                
                seleccionVehiculo2();
            }else{
                //si el terreno son montañas o planicies
                if(escenario[movFila][movColumna] == "\033[32m▲▲▲▲▲▲▲" || escenario[movFila][movColumna] == "\033[31m▓▓▓▓▓▓▓"){
                    valorAnterior = arregloTemporal[buscarFila][buscarColumna];
                    escenario[buscarFila][buscarColumna] = valorAnterior;
                    escenario[movFila][movColumna] = dibujo2;
                }else{         
                System.out.println("\n  ---MOVIMIENTO INCORRECTO, SE ENCUENTRA UN VEHICULO EN ESA POSICION---\n");
                seleccionVehiculo2();
                }
            }
        }
        //si el vehiculo es un avión
        if(dibujo2 == "\033[35m║\033[34m__▲__\033[35m║\033[37m"){
            //si el terreno son montañas
            if(escenario[movFila][movColumna] == "\033[32m▲▲▲▲▲▲▲"){
                System.out.println("\n  ---EL VEHICULO NO PUEDE MOVERSE YA QUE ES TIPO AVIÓN Y NO PUEDE ATRAVESAR MONTAÑAS---\n");                        
                seleccionVehiculo2();
            }else{
                //si el terreno es agua o planicies
                if(escenario[movFila][movColumna] == "\033[36m≈≈≈≈≈≈≈" || escenario[movFila][movColumna] == "\033[31m▓▓▓▓▓▓▓"){
                    valorAnterior = arregloTemporal[buscarFila][buscarColumna];
                    escenario[buscarFila][buscarColumna] = valorAnterior;
                    escenario[movFila][movColumna] = dibujo2;
                }else{
                System.out.println("\n  ---MOVIMIENTO INCORRECTO, SE ENCUENTRA UN VEHICULO EN ESA POSICION---\n");
                seleccionVehiculo2();
                }
            }
        }
        return escenario;
    }
    public String dibujo3(){
        if(dibujoVehiculo.dibujarVehiculo3() == "Tanque"){
            dibujo3 = "\033[35m║║\033[37m=╧=\033[35m║║\033[37m";
        }else{
            dibujo3 = "\033[35m║\033[37m__▲__\033[35m║\033[37m";
        }                    
        return dibujo3;
    }
    
    public void seleccionVehiculo3(){
        dibujoBusqueda = dibujo3();
        moverVehiculoSeleccionado();
        moverVehiculo3();
  
    }
    public String[][] moverVehiculo3(){
        // si el vehículo es un tanque
        if(dibujo3 == "\033[35m║║\033[37m=╧=\033[35m║║\033[37m"){
            //si el terreno es agua
            if(escenario[movFila][movColumna] == "\033[36m≈≈≈≈≈≈≈"){
                System.out.println("\n  ---EL VEHICULO NO PUEDE MOVERSE YA QUE ES TIPO TANQUE Y NO PUEDE ESTAR EN AGUA---\n");
                seleccionVehiculo3();           
            }else{
                //si el terreno son montañas o planicies
                if(escenario[movFila][movColumna] == "\033[32m▲▲▲▲▲▲▲" || escenario[movFila][movColumna] == "\033[31m▓▓▓▓▓▓▓"){
                    valorAnterior = arregloTemporal[buscarFila][buscarColumna];
                    escenario[buscarFila][buscarColumna] = valorAnterior;
                    escenario[movFila][movColumna] = dibujo3;
                }else{
                System.out.println("\n  ---MOVIMIENTO INCORRECTO, SE ENCUENTRA UN VEHICULO EN ESA POSICION---\n");
                seleccionVehiculo3();
                }
            }
        }
        //si el vehiculo es un avión
        if(dibujo3 == "\033[35m║\033[37m__▲__\033[35m║\033[37m"){
            //si el terreno son montañas
            if(escenario[movFila][movColumna] == "\033[32m▲▲▲▲▲▲▲"){
                System.out.println("\n  ---EL VEHICULO NO PUEDE MOVERSE YA QUE ES TIPO AVIÓN Y NO PUEDE ATRAVESAR MONTAÑAS---\n");
                seleccionVehiculo3();
            }else{
                //si el terreno es agua o planicies
                if(escenario[movFila][movColumna] == "\033[36m≈≈≈≈≈≈≈" || escenario[movFila][movColumna] == "\033[31m▓▓▓▓▓▓▓"){
                    valorAnterior = arregloTemporal[buscarFila][buscarColumna];
                    escenario[buscarFila][buscarColumna] = valorAnterior;
                    escenario[movFila][movColumna] = dibujo3;
                }else{
                System.out.println("\n  ---MOVIMIENTO INCORRECTO, SE ENCUENTRA UN VEHICULO EN ESA POSICION---\n");
                seleccionVehiculo3();
                }
            }
        }
        return escenario;
    }
        
}
