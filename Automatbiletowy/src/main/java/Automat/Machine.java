package Automat;
import java.util.ArrayList;

public class Machine {
    private ArrayList<Money> listOfMoney;
    private double costOfTickets = 0;
    public Machine() {
        this.listOfMoney = new ArrayList<Money>();
    }
    public boolean addMoney(double value){
        listOfMoney.add(new Money(value));
        this.costOfTickets -= value;
        this.costOfTickets = round(this.costOfTickets, 2);
        if(this.costOfTickets <= 0){
            returnMoney();
            this.costOfTickets = 0;
            return true;
        }
        return false;
    }
    public void giveBackMoney(){
        if(listOfMoney.size() > 0){
            System.out.println("Zwracam:");
        }
        for (Money money : listOfMoney) {
            System.out.println(money.getValue() + "PLN");
        }
        listOfMoney.clear();
    }
    public void setTicketsToZero(){
        this.costOfTickets = 0.0;
    }
    private void returnMoney(){
        this.listOfMoney.clear();
        System.out.println("Reszta:");
        while(this.costOfTickets < 0){
            this.costOfTickets = round(this.costOfTickets, 2);
            if((this.costOfTickets + 50) <= 0){
                this.costOfTickets += 50;
                System.out.println("50 PLN:");
                continue;
            }
            if((this.costOfTickets + 20) <= 0){
                this.costOfTickets += 20;
                System.out.println("20 PLN:");
                continue;
            }
            if((this.costOfTickets + 10) <= 0){
                this.costOfTickets += 10;
                System.out.println("10 PLN:");
                continue;
            }
            if((this.costOfTickets + 5) <= 0){
                this.costOfTickets += 5;
                System.out.println("5 PLN:");
                continue;
            }
            if((this.costOfTickets + 2) <= 0){
                this.costOfTickets += 2;
                System.out.println("2 PLN:");
                continue;
            }
            if((this.costOfTickets + 1) <= 0){
                this.costOfTickets += 1;
                System.out.println("1 PLN:");
                continue;
            }
            if((this.costOfTickets + 0.5) <= 0){
                this.costOfTickets += 0.5;
                System.out.println("0.50 PLN:");
                continue;
            }
            if((this.costOfTickets + 0.2) <= 0){
                this.costOfTickets += 0.2;
                System.out.println("0.20 PLN:");
                continue;
            }
            if((this.costOfTickets + 0.1) <= 0){
                this.costOfTickets += 0.1;
                System.out.println("0.10 PLN:");
                continue;
            }
            if((this.costOfTickets + 0.05) <= 0){
                this.costOfTickets += 0.05;
                System.out.println("0.05 PLN:");
                continue;
            }
            if((this.costOfTickets + 0.02) <= 0){
                this.costOfTickets += 0.02;
                System.out.println("0.02 PLN:");
                continue;
            }
            if((this.costOfTickets + 0.01) <= 0){
                this.costOfTickets += 0.01;
                System.out.println("0.01 PLN:");
            }
            this.costOfTickets = round(this.costOfTickets, 2);
        }
    }
    public void addTicket(int index){
        if(index == 0){
            this.costOfTickets += 1.7;
        }
        else if(index == 1){
            this.costOfTickets += 2.3;
        }
        else if(index == 2){
            this.costOfTickets += 3;
        }
        else if(index == 3){
            this.costOfTickets += 3.4;
        }
        else if(index == 4){
            this.costOfTickets += 4.6;
        }
        else if(index == 5){
            this.costOfTickets += 6;
        }
        this.costOfTickets = round(this.costOfTickets, 2);
    }
    public boolean deleteTicket(int index){
        if(index == 0){
            this.costOfTickets -= 1.7;
        }
        else if(index == 1){
            this.costOfTickets -= 2.3;
        }
        else if(index == 2){
            this.costOfTickets -= 3;
        }
        else if(index == 3){
            this.costOfTickets -= 3.4;
        }
        else if(index == 4){
            this.costOfTickets -= 4.6;
        }
        else if(index == 5){
            this.costOfTickets -= 6;
        }
        this.costOfTickets = round(this.costOfTickets, 2);
        if(this.costOfTickets < 0){
            return true;
        }
        return false;
    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    public double getCostOfTickets(){
        return costOfTickets;
    }
}
