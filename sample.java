import java.util.HashMap;
import java.util.Scanner;

public class sample{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        HashMap<String, Long> expiry = new HashMap<>();
        HashMap<String, String> store = new HashMap<>();

        while(true){
            System.out.println("> ");
            String input = sc.nextLine();
            String[] parts = input.split(" ");

            String command = parts[0];

            if(command.equals("SET")){
                String key = parts[1];
                String value = parts[2];

                store.put(key, value);

                if(parts.length == 5 && parts[3].equals("EX")){
                    long seconds = Long.parseLong(parts[4]);
                    long expiryTime = System.currentTimeMillis() + seconds * 1000;
                    expiry.put(key, expiryTime);
                }
            }

            else if(command.equals("GET")){
                String key = parts[1];

                if(expiry.containsKey(key)){
                    if(expiry.get(key) <= System.currentTimeMillis()){
                        expiry.remove(key);
                        store.remove(key);
                        System.out.println("NOT FOUND");
                        continue;
                    }
                }
                
                String value = parts[2];

                if(value == null) System.out.println("NOT FOUND");
                else System.out.println(value);
            }

            else if(command.equals("DEL")){
                String key = parts[1];

                store.remove(key);
                expiry.remove(key);
            }

             else if (parts[0].equals("EXIT")) {

                break;
            }

            else {

                System.out.println("UNKNOWN COMMAND");
            }
        }

        sc.close();
    }
}