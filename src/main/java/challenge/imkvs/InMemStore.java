package challenge.imkvs;

import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by rahul on 16/8/18.
 */
public final class InMemStore {

    public static InMemStore instance = new InMemStore();
    private ConcurrentHashMap<String, ConcurrentHashMap<String, String>> map = new ConcurrentHashMap<>();

    private InMemStore() {
    }

    public void put(String namespace, String key, Serializable value) throws IOException {
        ConcurrentHashMap<String, String> bucket = map.computeIfAbsent(namespace, k -> new ConcurrentHashMap<>());
        bucket.put(key, serialize(value));
    }

    public Object get(String namespace, String key) throws IOException, ClassNotFoundException {
        ConcurrentHashMap<String, String> bucket = map.getOrDefault(namespace, new ConcurrentHashMap<>());
        return deserialize(bucket.get(key));
    }


    public Map<String, Object> values(String namespace) throws IOException, ClassNotFoundException {
        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<String, String> e : map.getOrDefault(namespace, new ConcurrentHashMap<>()).entrySet()) {
            result.put(e.getKey(), deserialize(e.getValue()));
        }
        return result;
    }

    private String serialize(Serializable object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    private Object deserialize(String s) throws IOException, ClassNotFoundException {
        if (null == s) {
            return null;
        }
        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }


}
