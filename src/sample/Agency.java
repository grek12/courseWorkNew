package sample;

import java.util.LinkedList;

public class Agency {
    private int realtorCount;//кол-во риелторов
    LinkedList<Realtor> realtor = new LinkedList<Realtor>();

    public Agency() {
        this.realtorCount = 0;

    }

    public int getRealtorCount() {
        return realtorCount;
    }//метод доступа кол-ва риелторов

    public void addRealtor(String surname, String phoneNumber) {
        realtor.add(new Realtor(surname, phoneNumber));
        realtorCount++;
    }

    public void removeRealtor(int index) {
        realtor.remove(index);
        realtorCount--;
    }

    public LinkedList<Realtor> getRealtor() {
        return realtor;
    }

    public Realtor getRealtorr(int i) {//метод доступа получения ссылки на риелтора
        if (realtor != null) {
            return realtor.get(i);
        }
        return null;
    }

    public void removeAll() {
        realtor.clear();
        realtorCount = 0;
    }

    public String getSumAgency(){
        float sumAgency=0;
        for(int i=0;i<realtorCount;i++){
            sumAgency = sumAgency + realtor.get(i).getPriceSum();

        }
        return String.valueOf(sumAgency);
    }

}

