package hotel.persons;

import hotel.Hotel;
import hotel.bills.Bill;
import hotel.bills.NormalBill;
import hotel.rooms.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Recepcionist extends Employee{
    private double valueAcumulated = 0;
    private ArrayList<String> bills = new ArrayList<String>();


    public Recepcionist(String name, int document, int phone, String email, String adress, String position) {
        super(name, document, phone, email, adress, position);
    }

    public String checkRoomAbailability() {
        String texto = "";
        int roomID = 0;
        boolean ocupated = false;
        String location = "";
        Room room;

        for(int i = 0; i< Hotel.rooms.size(); i++){
            room = Hotel.rooms.get(i);

            roomID = room.getRoomId();
            ocupated = room.isOccupied();
            location = room.getLocation();

            String statateOcupated;

            if(ocupated){
                statateOcupated = "ocupada";
            }else{
                statateOcupated = "disponible";
            }
            texto += ("La habitacion de id: "+ roomID + ", situada en: "+ location +", esta " + statateOcupated + " \n");
        }

        return texto;
    }

    public String concatenateBills(){
        String totalBills = "";
        for (int i=0; i<this.bills.size(); i++){
            totalBills += this.bills.get(i)+ "\n";
        }
        totalBills += "Total: "+this.valueAcumulated;
        return totalBills;
    }

    public String generateDailyBalance(){
        String dailyBalance = this.name + " inicio su turno a las "+ this.getStartWorkshift() + " y termino a las "+ LocalDate.now()+ "\n"+
                "El listado de las habitaciones es: \n" + this.checkRoomAbailability()+ "\n Las facturas durante el turno fueron:\n" +
                concatenateBills();

        valueAcumulated = 0;
        bills.clear();

        return dailyBalance;
    }

    public void acumulate(double value){
        this.valueAcumulated += value;
    }

    public void addBill(String bill){
        this.bills.add(bill);
    }

}
