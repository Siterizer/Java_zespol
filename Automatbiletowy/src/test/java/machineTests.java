import Automat.Machine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class machineTests {
    //private function from machine - testing
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }



    @Test
    public void returnsCorrectStateWhenEmpty(){
        Machine testMachine = new Machine();

        //no money so returns true that there is no money
        assertTrue(testMachine.addMoney(0));
    }

    @Test
    public void returnsCorrectStateWhenNotEmpty(){
        Machine testMachine = new Machine();
        testMachine.addTicket(1);

        assertFalse(testMachine.addMoney(0));
    }

    @Test
    public void addTicketTestingForIndexZeroFirst(){
        Machine testMachine = new Machine();
        testMachine.addTicket(0);
        assertEquals(1.7, testMachine.getCostOfTickets());
        testMachine.addTicket(1);
        assertEquals(4, testMachine.getCostOfTickets());
        testMachine.addTicket(2);
        assertEquals(7, testMachine.getCostOfTickets());
        testMachine.addTicket(3);
        assertEquals(10.4, testMachine.getCostOfTickets());

    }

    @Test
    public void addTicketTestingForIndexOneXFour(){
        Machine testMachine = new Machine();
        testMachine.addTicket(1);
        testMachine.addTicket(1);
        testMachine.addTicket(1);
        testMachine.addTicket(1);

        assertEquals(2.3*4, testMachine.getCostOfTickets());
    }

    @Test
    public void addTicketTestingAll(){
        Machine testMachine = new Machine();
        for(int i = 0; i<6; i++) {
            testMachine.addTicket(i);
        }

        assertEquals(1.7+2.3+3+3.4+4.6+6, testMachine.getCostOfTickets());
    }

    @Test
    public void addTicketTestingForIndexThreeTimesTen(){
        Machine testMachine = new Machine();
        for (int i = 0;i<10;i++) {
            testMachine.addTicket(3);
        }

        assertEquals(3.4*10, testMachine.getCostOfTickets());
    }

    @Test
    public void addTicketTestingRound(){
        Machine testMachine = new Machine();
        for(int i = 0; i<3; i++){
            testMachine.addTicket(4);
            testMachine.addTicket(5);
        }

        //4.6*3+6*3 return 31.7999... we want for it to be rounded so 31.8
        assertEquals(31.8, testMachine.getCostOfTickets());
    }

    @Test
    public void addTicketTestingBiggerNumberThanNormal(){
        Machine testMachine = new Machine();
        for(int i=0;i<100;i++){
            testMachine.addTicket(5);}

        assertEquals(6*100, testMachine.getCostOfTickets());
    }

    @Test
    public void deleteTicketsTestingReturns(){
        Machine testMachine = new Machine();
        testMachine.addTicket(1);

        //less than 0 returns true
        assertFalse(testMachine.deleteTicket(1));
        assertTrue(testMachine.deleteTicket(1));
    }

    @Test
    public void deleteTicketsTestingDeleting(){
        Machine testMachine = new Machine();
        testMachine.addTicket(1);
        testMachine.deleteTicket(1);

        //less than 0 returns true
        assertEquals(0, testMachine.getCostOfTickets());
    }

    @Test
    public void deleteTicketsRounding(){
        Machine testMachine = new Machine();
        for(int i = 0; i<3; i++){
            testMachine.addTicket(4);
            testMachine.addTicket(5);
        }
        for(int i = 0; i<3; i++){
            testMachine.deleteTicket(4);
            testMachine.deleteTicket(5);
        }

        assertEquals(0, testMachine.getCostOfTickets());
    }

    @Test
    public void resetingMoneyTest(){
        Machine testMachine = new Machine();
        for(int i = 0; i<3; i++){
            testMachine.addTicket(4);
            testMachine.addTicket(5);
        }

        testMachine.setTicketsToZero();
        assertEquals(0, testMachine.getCostOfTickets());
    }

    @Test
    public void addMoneyTestingAdding(){
        Machine testMachine = new Machine();
        testMachine.addTicket(1);
        testMachine.addMoney(2);

        assertEquals(0.3, testMachine.getCostOfTickets());

    }

    @Test
    public void addMoneyWeirdNumber(){
        Machine testMachine = new Machine();
        testMachine.addTicket(1);
        testMachine.addMoney(37);

        assertEquals(0, testMachine.getCostOfTickets());

    }

    @Test
    public void addMoneyReturn(){
        Machine testMachine = new Machine();
        testMachine.addTicket(1);
        testMachine.addMoney(37);

        assertTrue(testMachine.addMoney(2.3));

    }
}
