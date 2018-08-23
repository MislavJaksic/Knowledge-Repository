public class ControlFlow {

    public static void main(String[] args) {
        int i = 3;
        if (i != 3) { //-> must evaluate to a boolean value
            System.out.println("i is 3; will not print");
        } else {
            System.out.println("i is 3"); //-> prints
        }

        boolean is_prime;
        switch (i) {
            case 1:
                is_prime = false;
            case 2:
                is_prime = true;
            default:
                is_prime = false; //-> default result
        }
        System.out.println(is_prime); //-> false

        int con = 6;
        do {
            System.out.println("Executes at least once"); //-> prints
        } while (con < 5);

        while (con < 5) {
            System.out.println("Cannot be true; will not print");
        }

        int[] numbers = {1, 22, 333};
        for (int j = 0; j < numbers.length; j++) {
            System.out.println(numbers[j]); //-> 1 22 333
        }
        //Foreach
        for (int number : numbers) {
            System.out.println(number); //-> 1 22 333
        }

        //Labeled and unlabled break exist, as well as continue and return
    }
}
