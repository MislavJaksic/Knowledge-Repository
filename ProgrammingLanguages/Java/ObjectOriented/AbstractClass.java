// Abstract classes cannot be instantiated
public abstract class AbstractClass {
    // Inheritor wil either also be abstract or will implement the methods

    public abstract void AbstractMethod();
    
    public void ConcreteMethod() {
        System.out.println("CONCRETE method in  abstract class");
    }
}