//fizz se è divisibile per 3
//buzz se è divisibile per 5
//fizzbuzz se è divisibile per 3 e per 5

class Fizzbuzz {
    public static void main(String[] args) {

        // for (int i = 1; i <= 100; i++) {
        //     String a = (i % 15 == 0) ? "Fizzbuzz" : ((i % 5 == 0) ? "buzz" : ((i % 3 == 0) ? "Fizz" : String.valueOf(i)));
        //     System.out.println(a);
        // }

        for(int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("Fizzbuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }

    }
}