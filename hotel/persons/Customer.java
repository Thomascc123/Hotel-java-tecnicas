package hotel.persons;

import hotel.bills.Bill;
import hotel.rooms.*;

public abstract class Customer extends Person{
    private static int idCount = 0;
    private int customerId;
    public String creditCart;
    public Bill bill;
    private Room room;

    public Customer(String name, int document, int phone, String email, String adress, String creditCart, Bill bill, Room room) {
        super(name, document, phone, email, adress);
        this.customerId = ++idCount;
        this.creditCart = creditCart;
        this.bill = bill;
        this.room = room;
        this.room.ocupateRoom();
    }

    public String getCreditCart() {
        return creditCart;
    }

    public void setCreditCart(String creditCart) {
        this.creditCart = creditCart;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void clearRoom(){
        this.room.unOcuppiedRoom();
        this.room = null;
    }


}
