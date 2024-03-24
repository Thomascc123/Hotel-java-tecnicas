package hotel.bills;

public interface Bill {
    public void addBill(double price, String Service);
    public String GenerateBill();
    public  double GenerateTotal();
    public void addTotal();


}
