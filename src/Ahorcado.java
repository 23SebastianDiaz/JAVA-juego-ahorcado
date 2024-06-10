import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "disciplina";
        int intentosMax = 10;
        int intentos = 0;
        boolean palabraCorrecta = false;

        char[] letrasCorrectas = new char[palabraSecreta.length()]; // Cuantas letras necesitan ser adiviandas.

        // imprime la cantidad de guiones.
        for (int i = 0; i < letrasCorrectas.length; i++) {
            letrasCorrectas[i] = '_';
        }

        // Recorre todo el juego hasta que adivine la palabra o pierda por intentos.
        while (!palabraCorrecta && intentos < intentosMax) {
                                                    //Se usa cuando tenemos una palabras de chars 
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasCorrectas) + " (" + palabraSecreta.length()
                    + " Letras)");
            System.out.println("Introduce un letra, por favor.");

            // Devuelve solo la primera letra que escriba, en minuscula.
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraAdivinada = false; 

            // Bucle para las palabras adivinadas
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) { // Si alguna letra de la palabra es igual a la letra ingresada.
                    letrasCorrectas[i] = letra; // Asigne en el indice que adivino la letra.
                    letraAdivinada = true; // Cambia estado de letraCorrecta para que no sume intentos.
                }
            }
            // Condicion para restar numeros de intentos si la letra no fue correcta (se
            // mantiene en false).
            if (!letraAdivinada) {
                intentos++; // Suma los intentos.
                System.out.println("Incorrecto! Te quedan " + (intentosMax - intentos) + " intentos.");
            }

            // Condicion para cuando las todos lo char de letras correctar sean iguales a la palabra secreta.
            if (String.valueOf(letrasCorrectas).equals(palabraSecreta)) {
                palabraCorrecta = true;
                System.out.println("Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
            }
        } //Cierra While

        // Condicion para cuando se acaben los intentos segun la descicion del while.
        if (!palabraCorrecta) {
            System.out.println("Que pena te has quedado sin intentos! GAME OVER.");
        }

        scanner.close();

    }
}
