public final class GrandChild extends Child {
    // Classes marked with final cannot be inherited

    public GrandChild() {
        super();
        System.out.println("GRANDCHILD contructor");
    }

    @Override
    public void noModifiersMethod() {
        System.out.println("GRANDCHILD no modifiers");
    }

    public static void staticMethod() {
        System.out.println("GRANDCHILD static");
    }

    public void grandChildMethod() {
        System.out.println("GRANDCHILD method");
    }
}
