
package otrapractica;

import java.util.Scanner;

public class OpcionArmas {

    Scanner datosTienda = new Scanner(System.in);
    //variables a utilizar para la creacions de las armas
    Arma armasCreadas;
    protected String nombreArma,respaldoNombre;
    protected float ataque, punteria,precioAtaque,precioPunteria,precioTotal;    
    protected String armaCorta,armaLarga,tipoArma;
    protected final String armaC1 = "Browning M2",armaC2 = "Granada",armaC3 = "Espoleta VT",armaC4 = "Fusil M-16",armaC5 = "TOZ-34";
    protected final String armaL1 = "Bazooka",armaL2 = "M4-Sherman",armaL3 = "Obus",armaL4 = "Bomba Atómica";
    protected final float precioArma = 100f;
    int contadorCorto = 0,contadorLargo = 0,opcionArma;
    //arreglos para guardar las armas
    protected String arregloArmasCortas[] = new String[200]; 
    protected String arregloArmasLargas[] = new String[200];
    
    //metodos setter, getter y constructores    
    public String getTipoArma() {
        return tipoArma;
    }
    public float getPrecioTotal() {
        return precioTotal;
    }
    public float getPrecioAtaque() {
        return precioAtaque;
    }
    public float getPrecioPunteria() {
        return precioPunteria;
    }
    public float getAtaque() {
        return ataque;
    }
    public float getPunteria() {    
        return punteria;
    }
    public String getNombreArma() {
        return nombreArma;
    }
    public void setNombreArma(String nombreArma) {
        this.nombreArma = nombreArma;
    }        
    public String getArmaCorta() {
        return armaCorta;
    }
    public String getArmaLarga() {
        return armaLarga;
    }
    public OpcionArmas(Arma armasCreadas) {
        this.armasCreadas = armasCreadas;
    }
    
    //metodos propios de la clase
    public void mostrarArmas(){
        armasCreadas.ingresarArmas();       
    }
    //metodo para escoger el tipo de arma que se creara
    public void definirArma(){
        switch(armasCreadas.valorResultado()){
            case 1:
                System.out.println("\n  ---ELIGIÓ UN ARMA DE CORTO ALCANCE---\n");
                armasCortas();
                break;
            case 2:
                System.out.println("\n  ---ELIGIÓ UN ARMA DE LARGO ALCANCE---\n");
                armasLargas();
                break;
        }
    }
    //metodo para ingresar el nombre de las armas
    public String ingresarNombre(){
        System.out.print("INGRESE EL NOMBRE DE SU ARMA: ");
        return nombreArma = datosTienda.nextLine();
    }
    public String temporal(){
        return respaldoNombre = nombreArma;
    }
    //metodo que guarda los procesos para crear un arma
    public void armasCortas(){
        ingresarNombre();
        menuArmasCortas();
        seleccionArma();
        armaCorta();
        comprarAtaque();
        comprarPunteria();
        precioTotal();
        System.out.println("    ---ARMA GUARDADA CON ÉXITO---\n");
    }
    //metodo que muestra el menu de armas cortas
    public void menuArmasCortas(){
        System.out.println("\n| ARMAS DE CORTO ALCANCE:");
        System.out.println("| COSTO DE CADA ARMA:    Q 100.00");
        System.out.println("| 1. Browning M2---------Ametralladora Pesada");
        System.out.println("| 2. Granada-------------Explosivo");
        System.out.println("| 3. Espoleta VT---------Explosivo");
        System.out.println("| 4. Fusil M-16----------Fusil de Asalto");
        System.out.println("| 5. TOZ-34--------------Rifle");
    }
    //metodo que guarda la seleccion del arma
    public int seleccionArma(){
        System.out.print("| SELECCIONE EL TIPO DE ARMA: ");
        opcionArma = datosTienda.nextInt();
        return opcionArma;
    }
    //metodo para definir el arma
    public String armaCorta(){
        switch(opcionArma){
            case 1:
                tipoArma = armaC1;
                break;
            case 2:
                tipoArma = armaC2;
                break;
            case 3:
                tipoArma = armaC3;
                break;
            case 4:
                tipoArma = armaC4;
                break;
            case 5:
                tipoArma = armaC5;
                break;    
        }
        return tipoArma;
    }
    //metodo para la creacion de armas
    public void armasLargas(){
        ingresarNombre();
        menuArmasLargas();
        seleccionArma();
        armaLarga();
        comprarAtaque();
        comprarPunteria();
        precioTotal();
        System.out.println("    ---ARMA GUARDADA CON ÉXITO---");
    }
    //metodo que muestra el menu de armas largas
    public void menuArmasLargas(){
        System.out.println("\n| ARMAS DE LARGO ALCANCE:");
        System.out.println("| COSTO DE CADA ARMA:    Q 100.00");
        System.out.println("| 1. Bazooka-------------Lanzador de bombas");
        System.out.println("| 2. M4-Sherman----------Lanzador de bombas");
        System.out.println("| 3. Obus----------------Bombardero");
        System.out.println("| 4. Bomba Atómica-------Arma Nuclear");
    }
    //metodo para definir el tipo de arma 
    public String armaLarga(){
        switch(opcionArma){
            case 1:
                tipoArma = armaL1;
                break;
            case 2:
                tipoArma = armaL2;
                break;
            case 3:
                tipoArma = armaL3;
                break;
            case 4:
                tipoArma = armaL4;
                break;
        }
        return tipoArma;
    }
    //metodo para la definicion del atributo ataque
    public void comprarAtaque(){
        menuAtaque();
        valorAtaque();
        definirAtaque();
    }    
    public void menuAtaque(){
        System.out.println("\n| ATAQUE DEL ARMA:");
        System.out.println("| 1. 10 Puntos      - Q 50.00");
        System.out.println("| 2. 15 Puntos      - Q 60.00");
        System.out.println("| 3. 20 Puntos      - Q 75.00");
        System.out.println("| 4. 25 Puntos      - Q 100.00");
    }
    int opcionAtaque;
    //metodo para elegir el valor del ataque
    public int valorAtaque(){
        System.out.print("| ELIJA EL VALOR DEL ATAQUE: ");
        opcionAtaque = datosTienda.nextInt();
        return opcionAtaque;
    }
    //metodo para definir el ataque
    public float definirAtaque(){
        switch(opcionAtaque){
            case 1:
                ataque = 10f;
                precioAtaque = 50f;
                break;
            case 2:
                ataque = 15f;
                precioAtaque = 60f;
                break;
            case 3:
                ataque = 20f;
                precioAtaque = 75f;
                break;
            case 4:
                ataque = 25f;
                precioAtaque = 100f;
                break;
        }
        return ataque;
    }
    //metodo para incorporar punteria
    public void comprarPunteria(){
        menuPunteria();
        valorPunteria();
        definirPunteria();
    }
    public void menuPunteria(){
        System.out.println("\n| PUNTERIA DEL ARMA:");
        System.out.println("| 1. 60 %      - Q 60.00");
        System.out.println("| 2. 75 %      - Q 75.00");
        System.out.println("| 3. 80 %      - Q 80.00");
        System.out.println("| 4. 90 %      - Q 100.00");
    }
    int opcionPunteria;
    //metodo para elegir el valor de la punteria
    public int valorPunteria(){
        System.out.print("| ELIJA EL VALOR DE LA PUNTERIA: ");
        opcionPunteria = datosTienda.nextInt();
        return opcionPunteria;
    }
    public float definirPunteria(){
        switch(opcionPunteria){
            case 1:
                punteria = 60f;
                precioPunteria = 60f;
                break;
            case 2:
                punteria = 75f;
                precioPunteria = 75f;
                break;
            case 3:
                punteria = 80f;
                precioPunteria = 80f;
                break;
            case 4:
                punteria = 90f;
                precioPunteria = 100f;
                break;
        }
        return punteria;
    }
    public float precioTotal(){
        precioTotal = (precioArma + precioAtaque + precioPunteria);
        return precioTotal;
    }
    //metodos para  mostrar las armas creadas
    public void listadoArmas(){
        System.out.println("\n\n| NOMBRE DEL ARMA:  | "+getNombreArma()+"\n|");
        System.out.println("| Tipo de Arma      | "+getTipoArma());
        System.out.println("| Ataque:           | "+getAtaque());        
        System.out.println("| Punteria;         | "+getPunteria()+" %");
        System.out.println("| Precio Total:     | Q"+getPrecioTotal());
    }
    
}
