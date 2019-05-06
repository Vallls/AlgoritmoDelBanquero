
package sop2;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class SOP2 {
    
 private int necesarios[][], //Array Necesarios
            asignados[][], //Array Asignados
            maximos[][], //Array Maximos
            disponibles[][], //Array Disponibles
            rutas, //Variable Rutas
            ordenes; //Variable Ordenes
            Resultado res; //Grafica Final

    public SOP2(int rutas, int ordenes,int[][] disponibles,int[][]maximos, Resultado res) { //Constructor
        this.rutas = rutas;
        this.ordenes = ordenes;
        this.disponibles = disponibles;
        this.maximos = maximos;
        this.res = res;
    }

    public void MatricesFalt(){ //Llenar las matrices Asignados y Necesarios
      this.asignados = new int[this.ordenes][this.rutas];
      this.necesarios = new int[this.ordenes][this.rutas]; 
       int h;
       for(int i=0; i< ordenes; i++){
           for(int j=0; j< rutas; j++){
               h = (int) (Math.random() *(maximos[i][j]));
               if(h<=disponibles[0][j]){
                   asignados[i][j]=h;
                   disponibles[0][j]=disponibles[0][j]-h;
               }else{
                   asignados[i][j]=0;
               }
           }
       }
    
    
        for (int i = 0; i < ordenes; i++) {
            for (int j = 0; j < rutas; j++) //llenando matriz de necesarios
            {
                necesarios[i][j] = maximos[i][j] - asignados[i][j];
            }
        }
    MAMN mamn = new MAMN(this.ordenes,this.rutas,this.asignados,this.necesarios,this,this.res);
    mamn.setVisible(true);  

}
  
    public boolean chequear(int i) {
        //chequeando si todos los recursos para el proceso pueden ser asignados
        for (int j = 0; j < rutas; j++) {
            if (disponibles[0][j] < necesarios[i][j]) {
                return false;
            }
        }

        return true;
    }

    public void esSeguro() {
        boolean done[] = new boolean[ordenes];
        int j = 0;

        while (j < ordenes) {  //hasta que todos los procesos se asignen
            boolean asignado = false;
            for (int i = 0; i < ordenes; i++) {
                if (!done[i] && chequear(i)) {  //intentando asignar
                    for (int k = 0; k < rutas; k++) {
                        disponibles[0][k] = disponibles[0][k] - necesarios[i][k] + maximos[i][k];
                    }
                    System.out.println("Proceso asignado : " + i);
                    this.res.RES(i);
                    asignado = done[i] = true;
                    j++;
                }
            }
            if (!asignado) {
                break;  //si no esta asignado
            }
        }
        if (j == ordenes) //si todos los procesos estan asignados
        {
            System.out.println("\nAsignado de forma segura");
            JOptionPane.showMessageDialog(null, "Asignado de forma segura");
        } else {
            System.out.println("Todos los procesos se pueden asignar de forma segura");
            JOptionPane.showMessageDialog(null,"No se pueden asginar todos los procesos de forma segura");
            this.res.NORES();
        }
    }
   
    
}
