
package otrapractica;

import java.util.Random;
import java.util.Scanner;


public class Ataque {
   
    Scanner datosAtaque = new Scanner(System.in);
    //objetos sentenciados sin parametros, que serviran para heredar los valores de las clases de donde provienen
    OpcionVehiculo vehiculos;
    OpcionArmas armas;
    OpcionesEscenario escenario;
    Jugador jugador;
    
    protected String enemigo;
    protected float ataqueEnemigo, vidaEnemigo1 = 50f,vidaEnemigo2 = 50f ,vidaEnemigo3 = 50f, defensaEnemigo;    
    //metodos getter para las variables de la clase
    public String getEnemigo() {
        return enemigo;
    }
    public float getAtaqueEnemigo() {
        return ataqueEnemigo;
    }
    public float getDefensaEnemigo() {
        return defensaEnemigo;
    }
    //metodo constructor para heredar valores de la clase opcion vehiculo
    public Ataque(OpcionVehiculo vehiculos) {
        this.vehiculos = vehiculos;
    }
    //metodo constructor para heredar valores de la clase opcion armas
    public Ataque(OpcionArmas armas) {
        this.armas = armas;
    }
    //metodo constructor para heredar valores de la clase opcion escenarios
    public Ataque(OpcionesEscenario escenario) {
        this.escenario = escenario;
    }
    //metodo constructor para heredar valores de la clase jugador
    public Ataque(Jugador jugador) {
        this.jugador = jugador;
    }
    //metodo para seleccionar el vehiculo que atacara
    public void inicioAtaque(){
        System.out.println("\n");
        vehiculos.nombreVehiculos();
        System.out.print("| INGRESE EL VEHICULO QUE ATACARÁ: ");
        valorOpcionAtaque();        
        opcionVehiculo();
    }
    protected int opcionAtaque;
    //metodo que guarda el valor del carro que se elija
    public int valorOpcionAtaque(){
        opcionAtaque = datosAtaque.nextInt();
        return opcionAtaque;
    }
    protected int copia;
    //metodo que copia la opcion de ataque para utilizar en otra clase
    public int copiaOpcionAtaque(){
        copia = opcionAtaque;
        return copia;
    }
    //metodo que cumple con los ataques dependiendo del tipo de carro que sea
    public void opcionVehiculo(){
        switch(opcionAtaque){
            case 1:
                System.out.println("\n");
                tipoVehiculo1();
                vehiculos.datosVehiculo1();               
                menuEnemigo();
                seleccionEnemigo();
                System.out.println("\n\n  \033[35m------ATAQUE DEL JUGADOR------\033[37m");
                realizarAtaque();
                break;
            case 2:
                System.out.println("\n");
                tipoVehiculo2();
                vehiculos.datosVehiculo2();                
                menuEnemigo();
                seleccionEnemigo();
                System.out.println("\n\n  \033[35m------ATAQUE DEL JUGADOR------\033[37m");
                realizarAtaque();
                break;
            case 3:
                System.out.println("\n");
                tipoVehiculo3();
                vehiculos.datosVehiculo3();
                menuEnemigo();
                seleccionEnemigo();
                System.out.println("\n\n  \033[35m------ATAQUE DEL JUGADOR------\033[37m");
                realizarAtaque();
                break;        
        }        
    }
    //metodo para explicar de mejor manera la mecanica del juego
    public void inicioAtaqueVehiculo1(){
        System.out.println("\n | INGRESE EL OBJETIVO, SOLO SON PERMITIDOS MOVIMIENTO EN LÍNEA RECTA");
        System.out.println("| Coordenadas del objetivo:");
    }
    //metodo aleatorio para generar los porcentajes de ataque
    public int numeroAleatorio(){
        Random numeroAleatorio = new Random();
        return numeroAleatorio.nextInt(99)+1;
    }
    //metodo aleatorio para escoger al rival que se ataca
    public int enemigoAleatorio(){
        Random enemigoAleatorio = new Random();
        return enemigoAleatorio.nextInt(3)+1;
    }
    int randomEnemigo, porcentajeEnemigo;
    //definir el valor del ataque del enemigo en funcion de un ramdom
    public void definirAtaqueEnemigo(){
       randomEnemigo = enemigoAleatorio();
        switch(randomEnemigo){
            case 1:
                valorGolpe1 = valorGolpe; 
                valorGolpe2 = 0f;
                valorGolpe3 = 0f;
                break;
            case 2:
                valorGolpe2 = valorGolpe; 
                valorGolpe1 = 0f;
                valorGolpe3 = 0f;
                break;
            case 3:
                valorGolpe3 = valorGolpe; 
                valorGolpe2 = 0f;
                valorGolpe1 = 0f;
                break;                
        }
    }
    //metodo utilizado para seleccionar un enemigo o vehiculo
    public float realizarAtaqueEnemigo(){
        porcentajeEnemigo = numeroAleatorio();            
        if(porcentajeEnemigo <= 50){
                valorGolpe = 10f;
                definirAtaqueEnemigo();
                System.out.println("\n  ---ATAQUE EXITOSO---");
                System.out.println("  ---DAÑO HECHO: "+valorGolpe);
        }else{
                valorGolpe = 0f;
                System.out.println("\n  ---ATAQUE FALLIDO---");
                System.out.println("  ---DAÑO HECHO: "+valorGolpe);
        }                                    
        return valorGolpe;
    }
    int ataque;
    String tipoVehiculo;
    //metodo que llama al tipo de vehiculo de la clase opcion vehiculo
    public String tipoVehiculo1(){
        tipoVehiculo = vehiculos.tipoVehiculo1();
        return tipoVehiculo;
    }
    public String tipoVehiculo2(){
        tipoVehiculo = vehiculos.tipoVehiculo2();
        return tipoVehiculo;
    }
    public String tipoVehiculo3(){
        tipoVehiculo = vehiculos.tipoVehiculo3();
        return tipoVehiculo;
    }
    protected float valorGolpe,valorGolpe1,valorGolpe2,valorGolpe3;
    //metodos que guardan el valor de los daños
    public float getValorGolpe1() {
        return valorGolpe1;
    }
    public float getValorGolpe2() {
        return valorGolpe2;
    }
    public float getValorGolpe3() {
        return valorGolpe3;
    }        
    //metodo que define el ataque de los vehiculos
    public float realizarAtaque(){
        if(tipoVehiculo =="Tanque"){
            ataque = numeroAleatorio();
            if(ataque <= 60){
                valorGolpe = 10f;
                valoresAtaque();
                System.out.println("\n  ---ATAQUE EXITOSO---");
                System.out.println("  ---DAÑO HECHO: "+valorGolpe);
            }else{
                valorGolpe = 0f;
                System.out.println("\n  ---ATAQUE FALLIDO---");
                System.out.println("  ---DAÑO HECHO: "+valorGolpe);
            }
        }
        if(tipoVehiculo =="Avión"){
            ataque = numeroAleatorio();
            if(ataque <= 70){
                valorGolpe = 7f;
                valoresAtaque();
                System.out.println("\n  ---ATAQUE EXITOSO---");
                System.out.println("  ---DAÑO HECHO: "+valorGolpe);
            }else{
                valorGolpe = 0f;
                System.out.println("\n  ---ATAQUE FALLIDO---");
                System.out.println("  ---DAÑO HECHO: "+valorGolpe);
            }
        }
        return valorGolpe;
    }
    //metodo que muestra informacion de los enemigos
    public void menuEnemigo(){
        System.out.println("\n| ENEMIGOS: ");
        System.out.println("| 1. ENEMIGO TANQUE 25-9");
        System.out.println("| 2. ENEMIGO AVIÓN KAMIKASE.");
        System.out.println("| 3. ENEMIGO HELICÓPTERO CAZA TROPAS");
        System.out.print("| SELECCIONE UN ENEMIGO: ");
    }
    int opcionEnemigo;
    //metodo que guarda el valor de la opcion de terrenos
    public int seleccionEnemigo(){
        opcionEnemigo = datosAtaque.nextInt();
        return opcionEnemigo;
    }
    //metodo que genera los valores para el ataque de los enemigos
    public void valoresAtaque(){
        switch(opcionEnemigo){
            case 1:
                valorGolpe1 = valorGolpe; 
                valorGolpe2 = 0f;
                valorGolpe3 = 0f;
                break;
            case 2:
                valorGolpe2 = valorGolpe; 
                valorGolpe1 = 0f;
                valorGolpe3 = 0f;
                break;
            case 3:
                valorGolpe3 = valorGolpe; 
                valorGolpe2 = 0f;
                valorGolpe1 = 0f;
                break;
                
        }
    }
    //metodo que muestra el proceso de ataque del enemigo
    public void ataqueEnemigo(){
        System.out.println("\n\n  \033[35m------ATAQUE ENEMIGO------\033[37m");
        realizarAtaqueEnemigo();
    }
    //nombres de los vehiculos
    public String nombre1(){
        return vehiculos.nombre1();
    }
    public String nombre2(){
        return vehiculos.nombre2();
    }
    public String nombre3(){
        return vehiculos.nombre3();
    }
}
