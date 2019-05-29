package Automat;
import java.util.ArrayList;

public class Machine {
    private ArrayList<Money> listOfMoney;
    private double costOfTickets = 0;
    private String text = "";
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

    public String getText(){
        return this.text;
    }
    public void clearText(){this.text = "";}
    public void setText(String text){ this.text += text;}

    public void giveBackMoney(){
        if(listOfMoney.size() > 0){
            this.setText("Zwracam: \n");
        }
        for (Money money : listOfMoney) {
            this.setText(money.getValue() + " PLN \n");
        }
        listOfMoney.clear();
    }
    public void setTicketsToZero(){
        this.costOfTickets = 0.0;
    }
    private void returnMoney(){
        this.listOfMoney.clear();
        if (this.costOfTickets < 0)
            this.setText("Reszta: \n");
        while(this.costOfTickets < 0){
            this.costOfTickets = round(this.costOfTickets, 2);
            if((this.costOfTickets + 50) <= 0){
                this.costOfTickets += 50;
                this.setText("50 PLN \n");
                continue;
            }
            if((this.costOfTickets + 20) <= 0){
                this.costOfTickets += 20;
                this.setText("20 PLN \n");
                continue;
            }
            if((this.costOfTickets + 10) <= 0){
                this.costOfTickets += 10;
                this.setText("10 PLN \n");
                continue;
            }
            if((this.costOfTickets + 5) <= 0){
                this.costOfTickets += 5;
                this.setText("5 PLN \n");
                continue;
            }
            if((this.costOfTickets + 2) <= 0){
                this.costOfTickets += 2;
                this.setText("2 PLN \n");
                continue;
            }
            if((this.costOfTickets + 1) <= 0){
                this.costOfTickets += 1;
                this.setText("1 PLN \n");
                continue;
            }
            if((this.costOfTickets + 0.5) <= 0){
                this.costOfTickets += 0.5;
                this.setText("0.50 PLN \n");
                continue;
            }
            if((this.costOfTickets + 0.2) <= 0){
                this.costOfTickets += 0.2;
                this.setText("0.20 PLN \n");
                continue;
            }
            if((this.costOfTickets + 0.1) <= 0){
                this.costOfTickets += 0.1;
                this.setText("0.10 PLN \n");
                continue;
            }
            if((this.costOfTickets + 0.05) <= 0){
                this.costOfTickets += 0.05;
                this.setText("0.05 PLN \n");
                continue;
            }
            if((this.costOfTickets + 0.02) <= 0){
                this.costOfTickets += 0.02;
                this.setText("0.02 PLN \n");
                continue;
            }
            if((this.costOfTickets + 0.01) <= 0){
                this.costOfTickets += 0.01;
                this.setText("0.01 PLN \n");
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
