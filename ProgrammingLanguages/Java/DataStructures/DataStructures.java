import java.util.ArrayList; //-> these are implementations
import java.util.LinkedList; //-> there are also more abstract interfaces:
import java.util.HashMap; //-> List, Map, Set
import java.util.HashSet; //-> use the interface when returning a structure to hide its implementation

public class DataStructures {

    public static void main(String[] args) {
        int n = 10;
        double[] zeroes = new double[n];  //-> set all to 0.0
        System.out.println(zeroes[2]); //-> 0.0
        
        double[] c = {0.0, 0.01, 0.002}; //-> custom init
        c[0] = 1.5;
        System.out.println(c.length); //-> 3

        String[][] multidimensional = {{"Arrays", "of", "different", "sizes"}, {"in", "an", "array"}};

        //Resizable array
        ArrayList d = new ArrayList();
        d.add(1);
        d.set(0, 11);
        d.get(0); //-> 11
        //Pop last element
        d.remove(d.size() - 1); //-> 11

        LinkedList animals = new LinkedList();
        animals.addFirst("Pig");
        animals.addLast("Cow");
        animals.get(0);
        animals.pop();

        HashMap<String, String> elements = new HashMap();
        elements.put("Au", "aurum");
        elements.put("Ag", "argentum");
        elements.containsKey("Au");
        elements.get("Au");

        HashSet<String> uniques = new HashSet();
        uniques.add("Mona Lisa");
        uniques.contains("Mona Lisa");
        
        CustomDataStructure struct = new CustomDataStructure(5);
    }
}

class CustomDataStructure {

    public int data;

    public CustomDataStructure(int data) {
        this.data = data;
    }
}
