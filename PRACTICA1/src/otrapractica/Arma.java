
package otrapractica;

import java.util.Scanner;

public class Arma {

    Scanner datosArma = new Scanner(System.in);
    protected int arma;
    protected String vacio = " ";
    
    //metodo getter y setter de arma:
    public int getArma() {
        return arma;
    }
    public void setArma(int arma) {
        this.arma = arma;
    }
    //metodo que muestra un menu para ingresar el tipo de arma que desee el usuario        
    public void ingresarArmas(){
        System.out.println("\n\n| INGRESE EL TIPO DE ARMA QUE DESEA INGRESAR: ");
        System.out.println("| 1. Arma corto alcance.");
        System.out.println("| 2. Arma largo alcance.");
        System.out.print("| ELIJA UNA OPCIÓN: ");        
    }
    //metodo que retorna el resultado de la eleccion del tipo de arma
    public int valorResultado(){
        return arma = datosArma.nextInt();
    }
    int copiaValor;
    //metodo que copia el valor de la respuesta, este sera utilizado en otra clase
    public int copiaOpcion(){
        copiaValor = arma;
        return copiaValor;
    }
    //metodo para ingresar un valor de tipo string en blanco como parametro
    public String inicioLista(){
        return vacio;
    }
}
