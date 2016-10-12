//Josué Alexis Ramírez Pérez 513622 4º Semestre
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresion;
import EstructurasdeDatos.*;
import java.util.*;
/**
 *
 * @author josuealexis96
 */
public class Expresion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String expresion;//Creamos un string
        expresion = solicitarExpresion();//En el string se estara guardando el metodo de
        //solicitar la expresión, osea, la expresión que se dio en su respectivo metodo
        if(evaluarExpresion(expresion)){//Se usa el metodo de evaluar la expresion pero en
            //la variable string que se creo anteriormente, la cual es "expresion"
            System.out.println("La expresión esta balanceada");//Se manda un mensaje informando
            //que si esta balanceada y la condición se cumple
        } 
        else {//En caso de que la condición no se cumpla se manda un mensaje mencionando que
            //la expresión dada no esta balanceada
            System.out.println("La expresión no esta balanceada");
        }
    }
    
    /**
     * 
     * @return 
     */
    public static String solicitarExpresion(){//Método que se usa para solicitar la empresión que estaremos
        //evaluando para ver si esta o no balanceada
        String e;//Se crea una variable de tipo string para guardar la expresión
        Scanner sc = new Scanner(System.in);//Se declara una variable Scanner para analizar la expresion
        System.out.println("Indroduce la expresión que deseas evaluar");
        e = sc.nextLine();//Se guarda la expresión dada en el string
        return e;//Regresa el String
    }
    
    /**
     * 
     * @param e, tiene como parametro un String es la expresión que se guardó en la variable
     * @return 
     */
    public static boolean evaluarExpresion(String e){//Se crea un metodo boolean para
        //evaluar la expresion y ver si esta balanceada
        Stacks s = new Stacks();//Se crea un objeto para mandar a llamar a la pila
        //desde la libreria
        char ex[] = e.toCharArray();//Se va separando caracter por caracter para analizar uno por uno
        for(int i = 0; i < ex.length; i++){//Empezamos por crear un ciclo for para recorrer todos los
            //caracteres
            if (ex[i]=='('){//Se verifica si al recorrer los caracteres, el caracter es un parentesis a la izquierda
                s.push(ex[i]);//De ser así, se guarda en la pila
            }
            else if (ex[i]=='{'){//Se verifica si al recorrer los caracteres, el caracter es una llave a la izquierda
                s.push(ex[i]);//De ser así, se guarda en la pila
            }
                else if (ex[i]=='['){//Se verifica si al recorrer los caracteres, el caracter es un corchete a la izquierda
                    s.push(ex[i]);//De ser así, se guarda en la pila
                }
                else if (ex[i]==')'){//Se verifica si al recorrer los caracteres, el caracter es un parentesis a la derecha
                    if(s.getTop().getData().equals('(')){//De ser así, se realiza una comparación con el dato
                        //que esta hasta la parte de arriba de la pila, haciendo una comparación de si el dato que
                        //se encuentra ahí es igual o diferente
                        s.pop();//De ser así, el parentesis
                    }
                    else{
                        return false;
                    }
                }
                else if (ex[i]=='}'){//Se verifica si al recorrer los caracteres, el caracter es una llave a la derecha
                    if(s.getTop().getData().equals('{')){
                        s.pop();
                    }
                    else{
                        return false;
                    }
                }
                else if (ex[i]==']'){//Se verifica si al recorrer los caracteres, el caracter es un corchete a la iderecha
                    if(s.getTop().getData().equals('[')){
                        s.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        return true;
    }
}