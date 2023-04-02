import java.util.ArrayList;
import java.util.List;

public class Numeri<T extends Number> {
    
    private T[] array;
    
    public Numeri(T[] array) {
        this.array = array;
    }
    
    public List<T> filterEven() {
        List<T> evenList = new ArrayList<>();
        for (T element : array) {
            if (element.intValue() % 2 == 0) {
                evenList.add(element);
            }
        }
        return evenList;
    }
    
    public List<T> filterOdd() {
        List<T> oddList = new ArrayList<>();
        for (T element : array) {
            if (element.intValue() % 2 != 0) {
                oddList.add(element);
            }
        }
        return oddList;
    }
    
    public List<T> filterPrime() {
        List<T> primeList = new ArrayList<>();
        for (T element : array) {
            if (isPrime(element.intValue())) {
                primeList.add(element);
            }
        }
        return primeList;
    }
    
    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
