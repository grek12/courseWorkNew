package sample;

import java.util.LinkedList;

public class Realtor {
    private String surname;
    private String numberPhone;
    private Float priceSum;
    private int clientCount;
    LinkedList<Client> client = new LinkedList<Client>();

    public Realtor(String surname, String numberPhone) {
        this.surname = surname;
        this.numberPhone = numberPhone;
        this.priceSum = getPriceSum();

    }

    protected void addClient(String surnameClient, float price) {
        client.add(new Client(surnameClient, price));
        clientCount++;
    }

    protected void removeClient(int index) {
        client.remove(index);
        clientCount--;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public LinkedList<Client> getClient() {
        return client;
    }

    public Float getPriceSum() {
        float sum = 0;
            for(int i=0;i<clientCount;i++){
                sum = client.get(i).getPrice()+sum;
            }

        return sum;
    }

    public int getClientCount() {
        return clientCount;
    }
}
