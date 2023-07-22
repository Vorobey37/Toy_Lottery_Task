
import java.util.HashSet;

public class ToyList {

    /**
     *Список с уникальными значениями (существующие виды игрушек)
     */
    private HashSet<Toy> toyList = new HashSet<>();


    public HashSet<Toy> getToyList() {
        return toyList;
    }


    /**Метод добавляет новый вид игрушек в список игрушек, при этом, если 
     * такой вид уже был, то новый не добавит.
     * @param toyDiscription - описание игрушки
     */
    public void addToy(String toyDiscription) {

        String[] descriptionElements = toyDiscription.split(" ");
        Toy toy = new Toy();
        toy.setId(Integer.parseInt(descriptionElements[0]));
        toy.setName(descriptionElements[1]);
        toy.setAppearanceChance(Integer.parseInt(descriptionElements[2]));
        toyList.add(toy);
    }    



    /** 
     * В целом, этот метод здесь нужен для красоты вывода информации
     */
    public void printListMessage(){

        System.out.println("Следующие виды игрушек участвуют в розыгрыше: " + toyList);
        System.out.println();
        System.out.println("Вероятность выпадения игрушек следующая: ");

        for (Toy toy : toyList) {
            System.out.println(toy.getName() + " - " + toy.getAppearanceChance() + "%");
        }

        System.out.println();
    }


    @Override
    public String toString() {

        String result = "";

        for (Toy toy : toyList) {
            result = result + toy.getName() + ", ";
        }
        result = result.substring(0, result.length() - 2);

        return result;
    }   
}
