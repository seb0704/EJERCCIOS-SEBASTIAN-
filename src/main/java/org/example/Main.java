package org.example;

import java.util.Scanner;

public class Main {

    static int votosMario = 0, votosCesar = 0, votosFelipe = 0;
    static long costoMario = 0, costoCesar = 0, costoFelipe = 0;
    static int totalVotos = 0;

    static final int COSTO_INTERNET = 700000;
    static final int COSTO_RADIO = 200000;
    static final int COSTO_TV = 600000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion, opcionJurado, medio;

        do {

            System.out.println("\n-*-*-*-*-* VOTA POR TU CANDIDATO EN LAS ELECCIONES DEL MUNICIPIO PREMIER -*-*-*-*-*");
            System.out.println("1. Mario");
            System.out.println("2. Cesar");
            System.out.println("3. Felipe");
            System.out.println("4. Menú del jurado");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 3) {

                System.out.println("\nSeleccione el medio de publicidad que influyó en su voto:");
                System.out.println("1. Internet ($" + COSTO_INTERNET + ")");
                System.out.println("2. Radio ($" + COSTO_RADIO + ")");
                System.out.println("3. Televisión ($" + COSTO_TV + ")");
                System.out.print("Opción: ");
                medio = scanner.nextInt();

                long costoVoto = obtenerCosto(medio);
                if (costoVoto == 0) {
                    System.out.println("Medio inválido. Voto no registrado.");
                } else {
                    switch (opcion) {
                        case 1:
                            votosMario++;
                            costoMario += costoVoto;
                            System.out.println("Voto para Mario CARGADO.");
                            break;
                        case 2:
                            votosCesar++;
                            costoCesar += costoVoto;
                            System.out.println("Voto para Cesar CARGADO.");
                            break;
                        case 3:
                            votosFelipe++;
                            costoFelipe += costoVoto;
                            System.out.println("Voto para Felipe CARGADO.");
                            break;
                    }
                    totalVotos++;
                }
            } else if (opcion == 4) {

                System.out.println("\n-*-*-*-*-* MENÚ DEL JURADO -*-*-*-*-*");
                System.out.println("1. Costo de campaña de cada candidato");
                System.out.println("2. Vaciar todas las urnas de la votación");
                System.out.println("3. Conocer el número total de votos");
                System.out.println("4. Porcentaje de votos obtenidos por cada candidato");
                System.out.println("5. Costo promedio de campaña en las elecciones");
                System.out.print("Seleccione una opción: ");
                opcionJurado = scanner.nextInt();

                switch (opcionJurado) {
                    case 1:
                        System.out.println("\nCosto de campaña:");
                        System.out.println("Mario: $" + costoMario);
                        System.out.println("Cesar: $" + costoCesar);
                        System.out.println("Felipe: $" + costoFelipe);
                        break;
                    case 2:

                        votosMario = votosCesar = votosFelipe = 0;
                        costoMario = costoCesar = costoFelipe = 0;
                        totalVotos = 0;
                        System.out.println("\nLas urnas han sido vaciadas. Se ha reiniciado la votación.");
                        break;
                    case 3:
                        System.out.println("\nNúmero total de votos: " + totalVotos);
                        System.out.println("Votos por candidato:");
                        System.out.println("Mario: " + votosMario);
                        System.out.println("Cesar: " + votosCesar);
                        System.out.println("Felipe: " + votosFelipe);
                        break;
                    case 4:
                        if(totalVotos > 0) {
                            System.out.printf("\nPorcentaje de votos:%n");
                            System.out.printf("Mario: %.", (votosMario * 100.0) / totalVotos);
                            System.out.printf("Cesar: %.", (votosCesar * 100.0) / totalVotos);
                            System.out.printf("Felipe: %.", (votosFelipe * 100.0) / totalVotos);
                        } else {
                            System.out.println("\nNo hay votos registrados.");
                        }
                        break;
                    case 5:
                        if(totalVotos > 0) {
                            long costoTotal = costoMario + costoCesar + costoFelipe;
                            System.out.println("\nCosto promedio por voto: $" + (costoTotal / totalVotos));
                        } else {
                            System.out.println("\nNo hay votos para calcular el costo promedio.");
                        }
                        break;
                    default:
                        System.out.println("\nOpción inválida en el menú del jurado.");
                        break;
                }
            } else if (opcion != 5) {
                System.out.println("\nOpción no válida. Intente nuevamente.");
            }

        } while (opcion != 5);

        System.out.println("\nPrograma finalizado.");
        scanner.close();
    }

    public static long obtenerCosto(int medio) {
        if (medio == 1) {
            return COSTO_INTERNET;
        } else if (medio == 2) {
            return COSTO_RADIO;
        } else if (medio == 3) {
            return COSTO_TV;
        } else {
            return 0;
        }
    }
        };
