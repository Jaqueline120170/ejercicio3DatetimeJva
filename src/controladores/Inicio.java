package controladores;

import java.util.ArrayList;
import java.util.Scanner;

// Clase entidad para representar un mes
class Mes {
    private int numero;
    private String nombre;

    // Constructor
    public Mes(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    // Getter para obtener el nombre del mes
    public String getNombre() {
        return nombre;
    }
}

public class ProgramaMeses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mes> listaMeses = new ArrayList<>();

        // Solicitar al usuario ingresar el número y el nombre de cada mes
        for (int i = 1; i <= 12; i++) {
            System.out.print("Ingrese el nombre del mes para el número " + i + ": ");
            String nombreMes = scanner.nextLine();
            listaMeses.add(new Mes(i, nombreMes));
        }

        // Solicitar al usuario un número específico y mostrar el nombre del mes correspondiente
        while (true) {
            System.out.print("Ingrese un número de mes (1-12) para conocer su nombre (0 para salir): ");
            int numeroMes = scanner.nextInt();

            if (numeroMes == 0) {
                System.out.println("¡Hasta luego!");
                break;
            }

            if (numeroMes < 1 || numeroMes > 12) {
                System.out.println("Número de mes fuera del rango permitido. Por favor, ingrese un número entre 1 y 12.");
            } else {
                String nombreMes = obtenerNombreMes(listaMeses, numeroMes);
                System.out.println("El nombre del mes es: " + nombreMes);
            }
        }

        scanner.close();
    }

    // Método para obtener el nombre del mes a partir del número
    private static String obtenerNombreMes(ArrayList<Mes> listaMeses, int numeroMes) {
        for (Mes mes : listaMeses) {
            if (mes.getNumero() == numeroMes) {
                return mes.getNombre();
            }
        }
        return "Mes no encontrado";
    }
}