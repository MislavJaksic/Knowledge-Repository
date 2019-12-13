public class Generics {

    public static void main(String[] args) {
        // Upon instantiation T is replaced by a specific data type (non primitive)
        GenericClass<Integer> integer_generic = new GenericClass<>();
        integer_generic.setGenericMethod(25);
        System.out.println(integer_generic.getGenericMethod());  // -> 25

        GenericClass<String> string_generic = new GenericClass<>();
        string_generic.setGenericMethod("Twenty five");
        System.out.println(string_generic.getGenericMethod());  // -> Twenty five

        System.out.println(genericFunction(5));  // -> 5
        System.out.println(genericFunction("Return me!"));  // -> Return me!


        printData(string_generic);  // -> Twenty five

        boundedMethod((Integer) 25);  // -> 25
    }

    public static <P> P genericFunction(P input) {
        return input;
    }

    public static <V> void printData(GenericClass<V> param_object) {
        V output = param_object.getGenericMethod();
        System.out.println(output);
    }

    public static <V extends Number> void boundedMethod(V bounded_object) {
        System.out.println(bounded_object.intValue());
    }
}

class GenericClass<T> {
    private T data;

    // Cannot be overloaded because its generic
    public void setGenericMethod(T input) {
        this.data = input;
    }

    public T getGenericMethod() {
        return data;
    }
}
