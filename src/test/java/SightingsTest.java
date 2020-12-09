import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {
    @Test
    public void sightingInstantiatesProperly() {
        Sightings sightings = new Sightings("", "", 1);
        assertEquals(true,sightings instanceof Sightings);
    }
    @Test
    public void getsAnimalIdProperly() {
        Sightings sightings = new Sightings("", "", 1);
        assertEquals(1,sightings.getAnimalId() );
    }
    @Test
    public void getsAnimalLocationProperly() {
        Sightings sightings = new Sightings("", "r", 1);
        assertEquals("",sightings.getLocation());
    }
    @Test
    public void getsRangerNameProperly() {
        Sightings sightings = new Sightings("", "", 1);
        assertEquals("",sightings.getRangerName());
    }
    @Test
    public void getsMoreThanOneSighting() {
        Sightings sightings = new Sightings("", "", 1);
        sightings.save();
        Sightings sightings1 = new Sightings(" ", "", 2);
        sightings1.save();
        assertTrue(Sightings.getallsightings().get(0).equals(sightings));
        assertTrue(Sightings.getallsightings().get(1).equals(sightings1));


    }

}