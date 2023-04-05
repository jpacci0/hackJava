import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> names = Arrays.asList("spring", "java", "oop", "php");

        List<String> intruders = names.stream().filter(el -> el.equals("php")).toList();
        
        for(String string : intruders){
            System.out.println(string);
        }
    }
}
