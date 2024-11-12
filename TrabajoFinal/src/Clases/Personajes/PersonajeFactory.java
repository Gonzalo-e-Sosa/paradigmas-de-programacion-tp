/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Personajes;
import java.util.Random;
/**
 *
 * @author Diego
 */
public class PersonajeFactory {

    private static Random random = new Random();
    
    public static Personaje crearMago() {
        //Selecciona aleatoriamente una subclase de Mago
        int cantAuror = 0;
        int cantEst = 0;
        int cantProf = 0;
        
        switch (random.nextInt(3)) {
            case 0:
                cantAuror++;
                return new Auror("Auror" + cantAuror, 100, 3, 100, 1.5);
            case 1:
                cantProf++;
                return new Profesor("Profesor" + cantProf, 100, 2, 100, 1.0);
            default:
                cantEst++;
                return new Estudiante("Estudiante" + cantEst, 100, 1, 100, 0.5);
        }
    }
    
    public static Personaje crearMortifago(){
        //Selecciona aleatoriamente una subclase de Mortifago
        int cantCom = 0;
        int cantSeg = 0;
        
        if(random.nextBoolean()){
            cantCom++;
            return new Comandante("Comandante" + cantCom, 100, 3, 100, 2);
        }else{
            cantSeg++;
            return new Seguidor("Seguidor" + cantSeg, 100, 2, 100 ,1);
        }
    }
}
