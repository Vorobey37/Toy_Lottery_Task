
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {

        String toyDescription1 = "1 Конструктор 10";
        String toyDescription2 = "2 Кукла 20";
        String toyDescription3 = "3 Мячик 30";
        String toyDescription4 = "4 Машинка 15";
        String toyDescription5 = "5 Калейдоскоп 25";
        String toyDescription6 = "5 Калейдоскоп 25"; //как пример, что по этим параметрам не добавится новая игрушка

        ToyList toyList = new ToyList();
        toyList.addToy(toyDescription1);
        toyList.addToy(toyDescription2);
        toyList.addToy(toyDescription3);
        toyList.addToy(toyDescription4);
        toyList.addToy(toyDescription5);
        toyList.addToy(toyDescription6); //как пример, что по этим параметрам не добавится новая игрушка

        toyList.printListMessage();
        
        Lottery lottery = new Lottery(toyList);
        
        LinkedList<Toy> toyQueue = lottery.getToyQueue();
        System.out.println(); 
        System.out.println("Вот, что Вам досталось: " + toyQueue);
        lottery.getToyFromQueue(toyQueue);

    }

    
}
