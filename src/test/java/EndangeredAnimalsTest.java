import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void instantiatesAnimal_true() {
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Tiger", "okay", "young");
        assertEquals(true, testEndangeredAnimals instanceof EndangeredAnimals);
    }

    @Test
    public void getsAnimalName() {
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Tiger", "okay", "young");
        assertEquals("Tiger", testEndangeredAnimals.getName());
    }

    @Test
    public void getsAnimalType() {
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Tiger", "okay", "young");
        assertEquals("young", testEndangeredAnimals.getAge());
    }

    @Test
    public void getsAnimalHealth() {
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Tiger", "okay", "young");
        assertEquals("okay", testEndangeredAnimals.getHealth());
    }

    @Test
    public void savesIdToObject() {
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Tiger", "okay", "young");
        testEndangeredAnimals.save();
        EndangeredAnimals savedEndangeredAnimals = EndangeredAnimals.allEndAnimals().get(0);
        assertEquals(testEndangeredAnimals.getId(), savedEndangeredAnimals.getId());

    }


}


