package hotel.rooms;

public class NormalRoom implements Room{
    private static int idCount = 0;
    private int roomId;
    private Boolean occupied;
    public double pricePerDay;
    public String location;

    public NormalRoom() {
        this.roomId = ++idCount;
    }

    public NormalRoom(double pricePerDay, String location) {
        this.roomId = ++idCount;
        ocupateRoom();
        this.location = location;
        this.pricePerDay = pricePerDay;
    }

    public int getRoomId() {
        return roomId;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void ocupateRoom() {
        this.occupied = true;
    }

    @Override
    public void unOcuppiedRoom() {
        this.occupied = false;
    }

    @Override
    public Boolean isOccupied() {
        return this.occupied;
    }
}
