public final class GrandChild extends Child {
    // Classes marked with final cannot be inherited

    public GrandChild() {
        super();
        System.out.println("GRANDCHILD contructor");
    }

    @Override
    public void NoModifiers() {
        System.out.println("GRANDCHILD no modifiers");
    }

    public static void Static() {
        System.out.println("GRANDCHILD static");
    }

    public void GrandChildMethod() {
        System.out.println("GRANDCHILD method");
    }
}
