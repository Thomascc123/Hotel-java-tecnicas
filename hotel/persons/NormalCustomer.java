package hotel.persons;

import hotel.bills.NormalBill;
import hotel.rooms.Room;

public class NormalCustomer extends Customer{
    public NormalCustomer(String name, int document, int phone, String email, String adress, String creditCart, NormalBill bill, Room room) {
        super(name, document, phone, email, adress, creditCart, bill, room);
    }
}
