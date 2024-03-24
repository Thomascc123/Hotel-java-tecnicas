package hotel.bills;

public class NormalBill implements Bill{
    private double total = 0;
    private String bill = "";

    @Override
    public void addBill(double price, String Service) {
        total += price;
        bill += Service+="\n";
    }

    @Override
    public String GenerateBill() {
        return bill;
    }

    @Override
    public double GenerateTotal() {
        return total;
    }

    @Override
    public void addTotal() {
        bill += "Total = "+total;
    }
}
