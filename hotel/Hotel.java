package hotel;

import hotel.persons.*;
import hotel.rooms.*;
import java.util.ArrayList;
import hotel.tools.Read;

public class Hotel {
    public static ArrayList<Room> rooms;
    public static Recepcionist recepcionistActual;

    public Hotel() {
        startShift();
        rooms = new ArrayList<>();
    }

    static public Room agregateRoomNormal(){
        NormalRoom roomAux = new NormalRoom();

        double auxPricePerDay = Read.validatePositiveDouble("ingrese el precio al dia de la habitacion: ");
        roomAux.setPricePerDay(auxPricePerDay);

        String locationRoom = Read.readString("Ingrese la ubicacion de la habitacion");
        roomAux.setLocation(locationRoom);

        return roomAux;
    }

    public static void createRooms(){
        int numRooms = Read.validatePositiveInt("Ingrese el numero de habitaciones que desesa agregar: ");
        for (int i = 0; i<numRooms; i++){
            rooms.add(agregateRoomNormal());
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
    public static int accessIndexRoomWithID(int id){
        int index = -1;
        for (int i = 0; i<rooms.size(); i++){
            if (rooms.get(i).getRoomId() == id){
                index = i;
                i = rooms.size()+1;
            }
        }
        if (index == -1){
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

}
