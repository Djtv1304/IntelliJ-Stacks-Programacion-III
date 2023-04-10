// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Stack;
public class Main {

    public static void main(String[] args) {

        Stack<String> primos = new Stack<>(); //Integer es el tipo de dato que va a tener mi stack
        String ejemplo1 = "[{()}]";
        String ejemplo2 = "[{(}]";

        for (int i=0; i<ejemplo1.length();i++) {
            if (ejemplo1.charAt(i) == '[' || ejemplo1.charAt(i) == '{' || ejemplo1.charAt(i) == '(' ) {
                primos.push(String.valueOf(ejemplo1.charAt(i)));
            }
            else {
                String signoComparar = primos.pop();
//primos.push(String.valueOf(ejemplo1.charAt(i)));
                if (signoComparar.equals("(")) {
                    if(ejemplo1.charAt(i) == ')') {
                        System.out.println("El cierre del parentesis es correcto");
                    }
                } else if (signoComparar.equals("[")) {
                    if(ejemplo1.charAt(i) == ']') {
                        System.out.println("El cierre del corchete es correcto");
                    }
                } else if (signoComparar.equals("{")) {
                    if(ejemplo1.charAt(i) == '}') {
                        System.out.println("El cierre de la llave es correcto");
                    }
                }
            }
            System.out.println("Impresion pila");
            System.out.println(primos);
        }

    }

}