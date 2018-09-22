public class InterfaceImplementor implements SimpleInterface {
    //Class has to implement all interface methods
    
    private int number = 0;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return new Integer(number);
    }
}
