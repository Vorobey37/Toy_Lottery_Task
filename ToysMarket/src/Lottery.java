import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class Lottery {

    ToyList toyList;
    ArrayList<Toy> randomToyList = new ArrayList<>();

    public Lottery(ToyList toyList) {
        this.toyList = toyList;
    }

    
    /**Этод метод создает список, в котором находятся все виды игрушек,
     * каждый из которых в количестве шанса выпадения (в сумме 100). Таким образом, если 
     * выбрать случайный элемент из списка, то он выпадет с вероятностью своего appearanceChance.
     * @return случайный элемент списка
     */
    public Toy getRandomToy(){

        Iterator<Toy> iterator = toyList.getToyList().iterator();

        while(iterator.hasNext()){
            Toy toy = iterator.next();
            for (int i = 0; i < toy.getAppearanceChance(); i++) {
                Toy newToy = new Toy();
                newToy.setId(toy.getId());
                newToy.setName(toy.getName());
                newToy.setAppearanceChance(toy.getAppearanceChance());
                randomToyList.add(newToy);
            }
        }

        Random rand = new Random();
        return randomToyList.get(rand.nextInt(randomToyList.size()));
    }



    /**Метод формирует очередь из полученных игрушек
     * @return
     */
    public LinkedList<Toy> getToyQueue(){

        LinkedList<Toy> toyQueue = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Сколько раз сыграть в лотерею?");
        int quantity = Integer.parseInt(scan.nextLine());
        scan.close();

        for (int i = 0; i < quantity; i++) {
            Toy toy = getRandomToy();
            toyQueue.add(toy);
        }

        return toyQueue;
    }



    /**Метод, который извлекает по очереди игрушки и записывает в файл.
     * @param toyQueue
     */
    public void getToyFromQueue(LinkedList<Toy> toyQueue){

        try (FileWriter fileWriter = new FileWriter("ToyPrizes.txt", false)) {

            fileWriter.write("Вам достаются следующие призы: ");
            fileWriter.append("\n");

            while (!toyQueue.isEmpty()){

                fileWriter.write(toyQueue.pop().toString());
                fileWriter.append("\n");

            }

            fileWriter.flush();

        } catch (Exception e) {
            System.out.println("Вот, что пошло не так: " + e);
        }    
    }   
}