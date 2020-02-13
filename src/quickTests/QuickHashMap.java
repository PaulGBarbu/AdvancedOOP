package quickTests;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QuickHashMap {
    private HashMap<String,String> hashMap = new HashMap<>();

    private void store(String key, String value){
        hashMap.put(key,value);
    }

    private Map<String, String> getAllData(){
        return hashMap;
    }

    private String getLand(String stadt){
        return hashMap.get(stadt);
    }

    private Set<String> getCities(String land){
        Set<String> result = new HashSet<>();
        for (Map.Entry<String, String> entry : hashMap.entrySet())
            if(entry.getValue().equals(land))
                result.add(entry.getKey());

        return result;
    }

    @Test
    public void testStuff(){
        store("Berlin","Deutschland");
        store("München","Deutschland");
        store("Warschau","Polen");

        System.out.println(getCities("Deutschland"));
    }
}
