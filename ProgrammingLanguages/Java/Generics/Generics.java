public class Generics {

    public static void main(String[] args) {
        //When an object is created from a generic class, T will be replaced by the specified data type
        //A primitive type cannot be used to create a generic object
        GenericClass<Integer> IntegerObject = new GenericClass<>(); //-> the object behaves as if Integer is written instead of T
        IntegerObject.setGenericMethod(25);
        System.out.println(IntegerObject.getGenericMethod()); //-> 25
        //GenericClass<T> can handle call specified data types
        GenericClass<String> StringObject = new GenericClass<>();
        StringObject.setGenericMethod("Twenty five");
        System.out.println(StringObject.getGenericMethod());

        //GenericClass<Integer> != GenericClass<String> //-> they are not the same
        System.out.println(GenericFunction("Return me")); //-> Return me

        PrintData(StringObject);//-> Twenty five

        BoundedMethod((Integer) 25); //-> 25
    }
    //Has to be static if referenced from a static method

    public static <P> P GenericFunction(P input) {
        return input;
    }

    public static <V> void PrintData(GenericClass<V> someObject) {
        V output = someObject.getGenericMethod();
        System.out.println(output);
    }

    public static <V extends Number> void BoundedMethod(V boundedobject) {
        System.out.println(boundedobject.intValue());
    }
}

//Java Generics class has a data type as a parameter
class GenericClass<T> {

    private T data;

    public void setGenericMethod(T input) {
        this.data = input;
        if (input instanceof Integer) {
            System.out.println("Integer was stored");
        } else {
            System.out.println("Non Integer was stored");
        }
    }

    public T getGenericMethod() {
        //T newValue = new T(data); //-> cannot do that
        return data;
    }

    //Methods that have parameterised arguments cannot be overloaded
}
