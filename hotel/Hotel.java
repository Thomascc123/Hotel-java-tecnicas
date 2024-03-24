package hotel;

import hotel.persons.*;
import hotel.rooms.*;
import java.util.ArrayList;
import hotel.tools.Read;

public class Hotel {
    public static ArrayList<Room> rooms;
    public static ArrayList<Employee> employees;

    static public Room agregateRoomNormal(){
        NormalRoom roomAux = new NormalRoom();

        double auxPricePerDay = Read.readDouble("ingrese el precio al dia de la habitacion: ");
        roomAux.setPricePerDay(auxPricePerDay);

        String locationRoom = Read.readString("Ingrese la ubicacion de la habitacion");
        roomAux.setLocation(locationRoom);

        return roomAux;
    }




}
