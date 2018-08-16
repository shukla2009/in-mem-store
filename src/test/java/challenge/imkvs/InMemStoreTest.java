package challenge.imkvs;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by rahul on 16/8/18.
 */
public class InMemStoreTest {
    @BeforeClass
    public static void before() throws IOException {
        InMemStore.instance.put("hr", "001", new Person("Rahul", "Shukla"));
    }

    @Test
    public void put() throws Exception {
        InMemStore.instance.put("eng", "002", new Person("Pay", "SickCock"));
        assertEquals(new Person("Pay", "SickCock"), InMemStore.instance.get("eng", "002"));
    }

    @Test
    public void get() throws Exception {
        assertEquals(new Person("Rahul", "Shukla"), InMemStore.instance.get("hr", "001"));
    }

    @Test
    public void values() throws Exception {
        assertEquals(1, InMemStore.instance.values("hr").size());
    }

}