import java.util.HashMap;
import java.util.Scanner;

public class sample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, String> store = new HashMap<>();
        
        while(true){
            System.out.print("> ");
            String input = sc.nextLine();

            String[] parts = input.split(" ");

            if(parts[0].equals("SET")){
                String key = parts[1];
                String val = parts[2];

                store.put(key, val);
            }
            else if(parts[0].equals("GET")){
                String key = parts[1];
                String val = store.get(key);
                if(val == null) System.out.println("NOT FOUND");
                else System.out.println(val);
            }
            else if(parts[0].equals("DEL")){
                String key = parts[1];

                store.remove(key);
            }
            else if(parts[0].equals("EXIT")) break;
            else System.out.println("UNKNOWN COMMAND");
        }
        sc.close();
    }
}