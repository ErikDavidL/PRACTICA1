
package otrapractica;

import java.util.Scanner;

public class OpcionVehiculo {
    
    Scanner datosVehiculo = new Scanner(System.in);
    Vehiculo misVehiculos[] = new Vehiculo[3];
    int indice = 0,numExtra,numeroArreglo = 0,opcionVehiculo;
    //metodo para guardar los vehiculos en una objeto arreglo
    public void ingresarVehiculos(){
        while(numeroArreglo <= 2){            
            misVehiculos[numeroArreglo] = new Vehiculo("   ");
                numExtra = numeroArreglo +1;
                System.out.println("\n\nINGRESANDO VEHÍCULO # "+numExtra );
            misVehiculos[numeroArreglo].ingresarNicknameVehicle();
            misVehiculos[numeroArreglo].ingresarVehicle();  
            misVehiculos[numeroArreglo].opcionArma();
            System.out.println(" ---VEHICULO CREADO CON ÉXITO---");
            numeroArreglo++;            
        }    
    }
    //metodo para mostrar un listado de los vehiculos ya creados
    public void listadoVehiculos(){
        for(Vehiculo mostrarVehiculos: misVehiculos){
            System.out.println(" ");
            mostrarVehiculos.mostrarDatos();
            System.out.println(" ");
        }
    }
    protected String dibujoVehiculo;

    public String getDibujoVehiculo() {
        return dibujoVehiculo;
    }    
    public String dibujarVehiculo1(){
        dibujoVehiculo = misVehiculos[0].dibujoVehiculo();
        return dibujoVehiculo;
    } 
    public String dibujarVehiculo2(){
        dibujoVehiculo = misVehiculos[1].dibujoVehiculo();
        return dibujoVehiculo;
    }
    public String dibujarVehiculo3(){
        dibujoVehiculo = misVehiculos[2].dibujoVehiculo();
        return dibujoVehiculo;
    }
        
    protected String nombreVehiculo;

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }
    String dibujo;
    //metodo para definir el dibujo de los vehiculos
    public String vehiculo1(){
        if (misVehiculos[0].dibujoVehiculo() == "Tanque"){
            dibujo = "\033[33m =╧= \033[37m";
        }else{
            dibujo = "\033[33m__▲__\033[37m";
        }
        return dibujo;
    }
    public String vehiculo2(){
        if (misVehiculos[1].dibujoVehiculo() == "Tanque"){
            dibujo = "\033[34m =╧= \033[37m";
        }else{
            dibujo = "\033[34m__▲__\033[37m";
        }
        return dibujo;
    }
    public String vehiculo3(){
        if (misVehiculos[2].dibujoVehiculo() == "Tanque"){
            dibujo = " =╧= ";
        }else{
            dibujo = "__▲__";
        }
        return dibujo;
    }
    //metodo que muestra un listado breve de los vehiculos y su skin
    public void nombreVehiculos(){        
        System.out.println("| VEHICULOS DEL JUGADOR:");
        System.out.println("| 1. SU SKIN: "+vehiculo1()+"   TIPO: "+misVehiculos[0].tipoVehiculo()+"         NOMBRE: "+misVehiculos[0].getNombreVehiculo());
        System.out.println("| 2. SU SKIN: "+vehiculo2()+"   TIPO: "+misVehiculos[1].tipoVehiculo()+"         NOMBRE: "+misVehiculos[1].getNombreVehiculo());
        System.out.println("| 3. SU SKIN: "+vehiculo3()+"   TIPO: "+misVehiculos[2].tipoVehiculo()+"         NOMBRE: "+misVehiculos[2].getNombreVehiculo());
    }
    //metodo para seleccionar un vehiculo
    public void metodosSeleccionVehiculo(){
        nombreVehiculos();
        seleccionVehiculo();
        vehiculo();        
    }
    //metodo para elegir un vehiculo
    public int seleccionVehiculo(){
        System.out.print("| ELIJA UN VEHICULO: ");
        opcionVehiculo = datosVehiculo.nextInt();
        return opcionVehiculo;
    }
    //metodo para mostrar el vehiculo seleccionado
    public void vehiculo(){
        switch(opcionVehiculo){
            case 1:
                System.out.println("\n\n| SELECCIONÓ A:    |"+ vehiculo1()+"     |"+misVehiculos[0].getNombreVehiculo());
                break;
            case 2:
                System.out.println("\n\n| SELECCIONÓ A:    |"+ vehiculo2()+"     |"+misVehiculos[1].getNombreVehiculo());
                break;
            case 3:
                System.out.println("\n\n| SELECCIONÓ A:    |"+ vehiculo3()+"     |"+misVehiculos[2].getNombreVehiculo());
                break;        
        }
    }
    //metodos utilizados para mostrar ciertas variables
    public void opcionesJugador(){
        menuAcciones();     
    }
    public void menuAcciones(){
        vehiculo();        
    }
    public void datosVehiculo1(){
        misVehiculos[0].mostrarDatos();
    }
    public void datosVehiculo2(){
        misVehiculos[1].mostrarDatos();
    }
    public void datosVehiculo3(){
        misVehiculos[2].mostrarDatos();
    }
    public String tipoVehiculo1(){
        return misVehiculos[0].getTipoVehiculo();
    }
    public String tipoVehiculo2(){
        return misVehiculos[1].getTipoVehiculo();
    }
    public String tipoVehiculo3(){
        return misVehiculos[2].getTipoVehiculo();
    }
    public String nombre1(){
        return misVehiculos[0].getNombreVehiculo();
    }
    public String nombre2(){
        return misVehiculos[1].getNombreVehiculo();
    }
    public String nombre3(){
        return misVehiculos[2].getNombreVehiculo();
    }
    
}
