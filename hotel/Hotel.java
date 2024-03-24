package hotel;

import hotel.bills.NormalBill;
import hotel.persons.*;
import hotel.rooms.*;
import java.util.ArrayList;
import hotel.tools.Read;
import hotel.bills.*;

public class Hotel {
    public static ArrayList<Room> rooms;
    public static Recepcionist recepcionistActual;
    public static ArrayList<Customer> customers = new ArrayList<Customer>();

    public Hotel() {
        startShift();
        rooms = new ArrayList<Room>();
    }

    static public Room createRoomNormal(){
        NormalRoom roomAux = new NormalRoom();

        double auxPricePerDay = Read.validatePositiveDouble("ingrese el precio al dia de la habitacion: ");
        roomAux.setPricePerDay(auxPricePerDay);

        String locationRoom = Read.readString("Ingrese la ubicacion de la habitacion");
        roomAux.setLocation(locationRoom);

        return roomAux;
    }

    public static void agregateRooms(){
        int numRooms = Read.validatePositiveInt("Ingrese el numero de habitaciones que desesa agregar: ");
        for (int i = 0; i<numRooms; i++){
            rooms.add(createRoomNormal());
        }
        System.out.println("las habitaciones fueron registradas con exito");
    }

    public static void modifyRoom(){
        int idRoom = Read.readInt("Ingrese el id de la habitacion que quiere editar: ");
        int indexAux = accessIndexRoomWithID(idRoom);
        if (indexAux <= -1){
            System.out.println("La habitacion con el id "+idRoom+" No existe");
        } else if (indexAux >= 0) {

            int option = Read.readInt("1. Ubicacion." +
                                    "\n2. Precio al dia." +
                                    "\nIngrese el numero del valor que quiere modificar: ");
            menuEditRoom(option,indexAux);
        }
    }

    public static  void menuEditRoom(int option, int index){
        switch (option){
            case 1:
                double newPricePerDay = Read.validateNoNegativeDouble("Ingrese el nuevo precio de la habitacion: ");
                rooms.get(index).setPricePerDay(newPricePerDay);
                break;
            case 2:
                String newLocation = Read.readString("Ingrese la nueva ubicacion de la habitacion: ");
                rooms.get(index).setLocation(newLocation);
                break;
            default:
                System.out.println("Valor no valido, ingrese un numero entre las opciones.");
                break;
        }
    }
    public static int accessIndexRoomWithID(int id){ // obtiene la posicion de una habitacion en el arraylist con el id
        int index = -1;
        for (int i = 0; i<rooms.size(); i++){
            if (rooms.get(i).getRoomId() == id){
                index = i;
                i = rooms.size()+1;
            }
        }
        if (index == -1){ // si no se encuentra en el arraylist retorna -1
            return -1;
        }else if(index >= 0){
            return index;
        }
        return -1;
    }

    public static int accessIndexCustomerWithID(int id){ // obtiene la posicion de un cliente en el arraylist con el id
        int index = -1;
        for (int i = 0; i<customers.size(); i++){
            if (customers.get(i).getCustomerId() == id){
                index = i;
                i = customers.size()+1;
            }
        }
        if (index == -1){ // si no se encuentra en el arraylist retorna -1
            return -1;
        }else if(index >= 0){
            return index;
        }
        return -1;
    }

    public static void startShift(){
        String name = Read.readString("Ingrese el nombre del recepcionista: ");
        int document = Read.validatePositiveInt("Ingrese el documento del recepcionista: ");
        int phone = Read.validatePositiveInt("Ingrese el telefono del recepcionista: ");
        String email = Read.readString("Ingrese el correo del recepcionista: ");
        String address = Read.readString("Ingrese la direccion del recepcionista");
        String position = Read.readString("Ingrese el puesto del recepcionista");

        recepcionistActual = new Recepcionist(name, document, phone, email, address, position);
    }

    public static int countRoomsFree(){
        int countFreeRooms = 0;
        for (int i = 0; i<rooms.size(); i++){
            if(rooms.get(i).isOccupied() == false){
                countFreeRooms++;
            }
        }
        return countFreeRooms;
    }

    public static int isOccupied(int id){ //retorna 1 si la habitacion esta ocupada 0 si esta libre y -1 si no existe
        int state = accessIndexRoomWithID(id);
        if (state == -1){ // la habitacion no existe
            return -1;
        } else if (rooms.get(state).isOccupied() == true) { // la habitacion esta ocupada
            return 1;
        }else { // la habitacion esta libre
            return 0;
        }
    }

    public static void agregateCustomer(){
        int roomId = 0;
        int validate = 0;

        if (countRoomsFree() <= 0){
            System.out.println("No hay habitaciones disponibles");
        }else{

            do {
                System.out.println(recepcionistActual.checkRoomAbailability());
                roomId = Read.validateNoNegativeInt("Ingrese el ID de la habitacion que quiere asignar: ");
                validate = isOccupied(roomId);
                if (validate == -1){
                    System.out.println("La habitacion no existe, ingrese un id valido");
                }else if (validate == 1){
                    System.out.println("La habitacion esta ocupada, seleccione una habitacion libre");
                }
            }while(validate == -1 || validate == 1);

            Room room = rooms.get(accessIndexRoomWithID(roomId));
            registerCustomer(room);
        }
    }

    public static void registerCustomer(Room room){
        String name = Read.readString("Leer el nombre del cliente: ");
        int document = Read.validatePositiveInt("Ingrese el numero de documento del cliente: ");
        int phone = Read.validatePositiveInt("Ingrese el telefono del cliente: ");
        String email = Read.readString("Ingrese el correo del cliente: ");
        String direction = Read.readString("Ingrese la direccion del cliente: ");
        String creditCard = Read.readString("Ingrese la tarjeta de credito del cliente: ");
        Bill bill = new NormalBill();

        NormalCustomer customer = new NormalCustomer(name, document, phone, email, direction, creditCard, bill, room);
    }

    public static void customerExpense(int customerId, double price, String service){
        int indexCustomer = accessIndexCustomerWithID(customerId);
        if (indexCustomer == -1){
            System.out.println("No existe el cliente con esa id.");
        }else{
            customers.get(indexCustomer).bill.addBill(price, service);
        }
    }

    public static void checkOutCustomer(int customerId){
        int indexCustomer = accessIndexCustomerWithID(customerId);
        if (indexCustomer == -1){
            System.out.println("No existe el cliente con esa id.");
        }else{
            Customer exitCustomer = customers.get(indexCustomer);
            exitCustomer.bill.addTotal(); // calcula la factura total

            Bill billCustomer = exitCustomer.bill;

            recepcionistActual.addBill(billCustomer.GenerateBill());
            recepcionistActual.acumulate(billCustomer.GenerateTotal()); // le pasa la factura al recepcionista

            exitCustomer.clearRoom(); // vacia la habitacion

            customers.remove(exitCustomer); //quita al cliente del arraylist de clientes
        }
    }

    public static void endShift(){
        System.out.println(recepcionistActual.checkRoomAbailability());
        recepcionistActual = null;
    }
}
