package hotel.persons;

import java.time.LocalDate;

public abstract class Employee extends Person{
    private static int idCount = 0;
    private int employeeId;
    public String position;
    private LocalDate startWorkshift;

    public Employee(String name, int document, int phone, String email, String adress, String position) {
        super(name, document, phone, email, adress);
        this.position = position;
        this.startWorkshift = LocalDate.now();
        this.employeeId = idCount++;
    }

    public Employee() {
        this.startWorkshift = LocalDate.now();
        this.employeeId = idCount++;
    }

    public LocalDate getStartWorkshift() {
        return startWorkshift;
    }

    public void setStartWorkshiftNow() {
        this.startWorkshift = LocalDate.now();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
