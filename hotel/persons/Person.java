package hotel.persons;

public abstract class Person {
    public String name;
    public int document;
    public int phone;
    public String email;
    public String adress;

    public Person() {
    }

    public Person(String name, int document, int phone, String email, String adress) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
