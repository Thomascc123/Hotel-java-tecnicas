package hotel.rooms;

public interface Room {
    public void ocupateRoom();
    public void unOcuppiedRoom();
    public Boolean isOccupied();
    public int getRoomId();
    public String getLocation();
    public void setLocation(String location);
    public double getPricePerDay();
    public void setPricePerDay(double pricePerDay);

}
