package hotel.tools;

import java.util.Scanner;

public class Read {
    public static Scanner sc = new Scanner(System.in);
    public static double readDouble(String message){
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.println("Valor no válido, ingrese un valor numerico: ");
            sc.next();
        }
        double value = sc.nextDouble();
        sc.nextLine();
        return value;
    }

    public static int readInt(String message){
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Valor no válido, ingrese un valor entero: ");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    public static String readString(String message){
        System.out.println(message);
        String value = sc.next();
        value += sc.nextLine();
        return value;
    }

    public static double validatePositiveDouble(String messege){
        double value;
        value = readDouble(messege);
        while (value <= 0){
            System.out.print("Valor no valido, ingrese un valor positivo: ");
            value = readDouble(messege);
        }
        return value;
    }

    public static double validateNoNegativeDouble(String messege){
        double value;
        value = readDouble(messege);
        while (value < 0){
            System.out.print("Valor no valido, ingrese un valor mayor o igual a cero: ");
            value = readDouble(messege);
        }
        return value;
    }

    public static int validatePositiveInt(String messege){
        int value;
        value = readInt(messege);
        while (value <= 0){
            System.out.print("Valor no valido, ingrese un valor positivo: ");
            value = readInt(messege);
        }
        return value;
    }

    public static double validateNoNegativeInt(String messege){
        int value;
        value = readInt(messege);
        while (value < 0){
            System.out.print("Valor no valido, ingrese un valor mayor o igual a cero: ");
            value = readInt(messege);
        }
        return value;
    }

}
