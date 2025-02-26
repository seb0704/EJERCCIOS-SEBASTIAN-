package org.example;
import java.util.Scanner;

public class Alcancia  {

    private int monedas20 = 0;
    private int monedas50 = 0;
    private int monedas100 = 0;
    private int monedas200 = 0;
    private int monedas500 = 0;

    public void agregarMoneda(int denominacion) {
        switch (denominacion) {
            case 20:
                monedas20++;
                break;
            case 50:
                monedas50++;
                break;
            case 100:
                monedas100++;
                break;
            case 200:
                monedas200++;
                break;
            case 500:
                monedas500++;
                break;
            default:
                System.out.println("Denominación no válida.");
        }
    }
    public void contarMonedas() {
        System.out.println("Cantidad de monedas:");
        System.out.println("$20: " + monedas20);
        System.out.println("$50: " + monedas50);
        System.out.println("$100: " + monedas100);
        System.out.println("$200: " + monedas200);
        System.out.println("$500: " + monedas500);
    }
    public void calcularTotal() {
        int total = (monedas20 * 20) + (monedas50 * 50) + (monedas100 * 100) +
                (monedas200 * 200) + (monedas500 * 500);
        System.out.println("Total ahorrado: $" + total);
    }
    public void romperAlcancia() {
        monedas20 = 0;
        monedas50 = 0;
        monedas100 = 0;
        monedas200 = 0;
        monedas500 = 0;
        System.out.println("¡Alcancía rota! Todo el dinero ha sido retirado.");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Alcancia alcancia = new Alcancia();
        int opcion;
        do {
            System.out.println("---------------------------------------------");
            System.out.println("*-*-*-*-*-*-ALCANCIA SEBAS-*-*-*-*-*-*-*-*");
            System.out.println("---------------------------------------------");
            System.out.println("\n1. Agregar moneda");
            System.out.println("2. Contar monedas");
            System.out.println("3. Calcular total ahorrado");
            System.out.println("4. Romper alcancía");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la denominación de la moneda ($20, $50, $100, $200, $500): ");
                    int denominacion = scanner.nextInt();
                    alcancia.agregarMoneda(denominacion);
                    break;
                case 2:
                    alcancia.contarMonedas();
                    break;
                case 3:
                    alcancia.calcularTotal();
                    break;
                case 4:
                    alcancia.romperAlcancia();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 5);
        scanner.close();
    }
}