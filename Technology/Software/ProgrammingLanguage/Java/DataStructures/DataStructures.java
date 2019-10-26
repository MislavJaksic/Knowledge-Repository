import java.util.ArrayList;  // -> these are implementations
import java.util.LinkedList;  // -> there are also more abstract interfaces:
import java.util.HashMap;  // -> List, Map, Set
import java.util.TreeSet;  // -> use the interface when returning a structure to hide its implementation

public class DataStructures {

    public static void main(String[] args) {
        // Arrays
        int n = 10;
        double[] zeroes = new double[n];   // -> {0.0, 0.0, 0.0, ...}

        double[] A = {0.0, 0.01, 0.002};
        A[0] = 1.0;
        // A[3] = 4.0;
        int length = A.length;  // -> 3

        String[][] multidimensional = {{"Arrays", "of", "different", "sizes"}, {"in", "an", "array"}};

        // Array List: resizable array
        ArrayList d = new ArrayList();
        d.add(1);  // -> [1]
        d.set(0, 22);  // -> [22]
        d.get(0);  // -> 22
        // Pop last element
        d.remove(d.size() - 1);  // -> 22

        // Singly Linked List
        LinkedList animals = new LinkedList();
        animals.addFirst("Pig");
        animals.addLast("Cow");
        animals.get(0);
        animals.pop();
        animals.size();

        // Hash Table: map keys to values
        HashMap<String, String> elements = new HashMap();
        elements.put("Au", "aurum");
        elements.put("Ag", "argentum");
        elements.containsKey("Au");
        elements.get("Au");

        // Ordered Set: unique and ordered values
        TreeSet<String> ordered_uniques = new TreeSet();
        ordered_uniques.add("Add");
        ordered_uniques.add("A");
        ordered_uniques.add("Few");
        ordered_uniques.add("Strings");
        ordered_uniques.contains("Unknown");
        ordered_uniques.first();
        ordered_uniques.size();

        CustomDataStructure struct = new CustomDataStructure(5);
    }
}

class CustomDataStructure {
    public int data;

    public CustomDataStructure(int data) {
        this.data = data;
    }
}
