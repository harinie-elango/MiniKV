import java.util.HashMap;

public class sample {

    public static void main(String[] args) {

        HashMap<String, String> store = new HashMap<>();

        store.put("name", "alice");

        System.out.println(store.get("name"));

        store.remove("name");

        System.out.println(store.get("name"));
    }
}