package test;

import hotel.*;
import hotel.tools.Read;

public class test {
    public static Hotel hotel = new Hotel();
    public static void main(String[] args) {
        int option = 0;
        do {
            System.out.println("1. Terminar turno de trabajo\n" +
                    "2. Agregar habitaciones\n" +
                    "3. Añadir clientes\n" +
                    "4. Recibir la habitacion de un cliente\n" +
                    "5. Editar Habitacion\n" +
                    "6. Consultar Habitaciones disponibles\n" +
                    "7. hacer un cobro\n" +
                    "8. Consultar listado de clientes\n" +
                    "9. salir\n");

            option = Read.readInt("ingresa una opcion: ");
            menu(option);
        }while (option != 9);
    }

    public static void menu(int option){
        int idAux = 0;
        switch (option){
            case 1:
                Hotel.endShift();
                Hotel.startShift();
                break;
            case 2:
                Hotel.agregateRooms();
                break;
            case 3:
                Hotel.agregateCustomer();
                break;
            case 4:
                idAux = Read.validateNoNegativeInt("Ingrese el id del cliente: ");
                Hotel.checkOutCustomer(idAux);
                break;
            case 5:
                Hotel.modifyRoom();
                break;
            case 6:
                System.out.println(Hotel.recepcionistActual.checkRoomAbailability());
                break;
            case 7:
                idAux = Read.validateNoNegativeInt("Ingrese el id del cliente: ");
                String bill = Read.readString("Ingrese lo que le cobrara al cliente: ");
                double price = Read.validateNoNegativeDouble("Ingrese el valor de lo que le cobrara al cliente");
                Hotel.customerExpense(idAux,price,bill );
                break;
            case 8:
                Hotel.printCustomers();
                break;
            case 9:

                break;
            default:
                System.out.println("Valor no valido, ingrese un entero entre 1 y 8");
                break;

        }
    }
}
