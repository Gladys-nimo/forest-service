import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {
//    @Rule
//    public DataBaseRule database = new DatabaseRule;

    @Test
    public void instantiatesAnimal_true() {
        Endangered testEndangered = new Endangered("Tiger", "okay", "young");
        assertEquals(true, testEndangered instanceof Endangered);
    }

    @Test
    public void getsAnimalName() {
        Endangered testEndangered = new Endangered("Tiger", "okay", "young");
        assertEquals("Tiger", testEndangered.getName());
    }

    @Test
    public void getsAnimalType() {
        Endangered testEndangered = new Endangered("Tiger", "okay", "young");
        assertEquals("young", testEndangered.getAge());
    }

    @Test
    public void getsAnimalHealth() {
        Endangered testEndangered = new Endangered("Tiger", "okay", "young");
        assertEquals("okay", testEndangered.getHealth());
    }

    @Test
    public void savesIdToObject() {
        Endangered testEndangered = new Endangered("Tiger", "okay", "young");
        testEndangered.save();
        Endangered savedEndangered = Endangered.allEndAnimals().get(0);
        assertEquals(testEndangered.getId(), savedEndangered.getId());

    }


}


