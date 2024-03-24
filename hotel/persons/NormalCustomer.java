package hotel.persons;

import hotel.bills.*;
import hotel.rooms.Room;

public class NormalCustomer extends Customer{
    public NormalCustomer(String name, int document, int phone, String email, String adress, String creditCart, Bill bill, Room room) {
        super(name, document, phone, email, adress, creditCart, bill, room);
    }
}
