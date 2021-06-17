package sample;

public class Client {
    private String surnameClient;
    private float price;

    public Client(String surnameClient, float price) {
        this.surnameClient = surnameClient;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getSurnameClient() {
        return surnameClient;
    }
}
