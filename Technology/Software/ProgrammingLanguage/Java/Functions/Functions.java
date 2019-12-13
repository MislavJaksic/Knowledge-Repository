public class Functions {

    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        double x_to_nth = nPowerX(x, n);
        System.out.println(x_to_nth);  // -> a big number

        passByValue(x, n);
        System.out.println(x);  // -> 2
        System.out.println(n);  // -> 10

        sumAll(1, 2, 3, 4, 5);
    }

    // Functions are declared as follows:
    // "_visibility _is_static _is_final _return_type _function_name(_parameter_types_and_names)"
    // Its called a function signature
    private static final double nPowerX(int x, int n) {
        if (n == 0) {
            return 1;
        }
        double power = x;
        for (int i = 1; i < n; i++) {
            power = power * x;
        }
        return power;
    }

    private static void passByValue(Integer x, Integer y) {
        int swapper = x;
        x = y;
        y = swapper;
    }

    // Variable number of arguments
    private static void sumAll(int... numbers) {
        for (int number : numbers) {
            System.out.print(number);  // -> 12345
        }
    }

    // Java supports overloading, not default paramater values
}
