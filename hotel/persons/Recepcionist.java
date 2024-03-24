package hotel.persons;

import hotel.Hotel;
import hotel.rooms.*;

public class Recepcionist extends Employee{
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
}
