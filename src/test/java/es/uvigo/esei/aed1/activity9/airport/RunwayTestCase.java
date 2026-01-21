package es.uvigo.esei.aed1.activity9.airport;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class RunwayTestCase {

    private Runway runway;
    private Flight flight1;
    private Flight flight2;
    private Flight flight3;

    @BeforeEach
    public void setUp() {
        runway = new Runway(0);
        flight1 = new Flight("B876", "Madrid", "Paris");
        flight2 = new Flight("B747", "Vigo", "Barcelona");
        flight3 = new Flight("B765", "Santiago", "Barcelona");
    }

    /**
     * Test of assignDestination method
     */
    @Test
    public void testAssignDestination() {
        runway.assignDestination("Barcelona");
        assertTrue(runway.isDestination("Barcelona"), "Barcelona should be a valid destination");
    }

    @Test
    public void testAssignMultipleDestinations() {
        runway.assignDestination("Barcelona");
        runway.assignDestination("Paris");
        runway.assignDestination("London");
        
        assertTrue(runway.isDestination("Barcelona"));
        assertTrue(runway.isDestination("Paris"));
        assertTrue(runway.isDestination("London"));
    }

    @Test
    public void testAssignDuplicateDestination() {
        runway.assignDestination("Barcelona");
        runway.assignDestination("Barcelona");
        // Should contain only one Barcelona entry (no duplicates)
        assertTrue(runway.isDestination("Barcelona"));
    }

    /**
     * Test of isDestination method
     */
    @Test
    public void testIsDestinationExists() {
        runway.assignDestination("Paris");
        assertTrue(runway.isDestination("Paris"));
    }

    @Test
    public void testIsDestinationNotExists() {
        runway.assignDestination("Paris");
        assertFalse(runway.isDestination("Barcelona"));
    }

    @Test
    public void testIsDestinationEmpty() {
        assertFalse(runway.isDestination("Paris"), "Should not find destinations in an empty runway");
    }

    /**
     * Test of assignFlight and removeFlight methods
     */
    @Test
    public void testAssignSingleFlight() {
        runway.assignFlight(flight1);
        assertEquals(1, runway.numberFlight(), "Should have 1 flight assigned");
    }

    @Test
    public void testAssignMultipleFlights() {
        runway.assignFlight(flight1);
        runway.assignFlight(flight2);
        runway.assignFlight(flight3);
        
        assertEquals(3, runway.numberFlight(), "Should have 3 flights assigned");
    }

    @Test
    public void testRemoveFlight() {
        runway.assignFlight(flight1);
        runway.assignFlight(flight2);
        
        Flight removed = runway.removeFlight();
        assertEquals(flight1, removed, "Should remove the first flight (FIFO)");
        assertEquals(1, runway.numberFlight(), "Should have 1 flight remaining");
    }

    @Test
    public void testRemoveMultipleFlights() {
        runway.assignFlight(flight1);
        runway.assignFlight(flight2);
        runway.assignFlight(flight3);
        
        Flight f1 = runway.removeFlight();
        Flight f2 = runway.removeFlight();
        Flight f3 = runway.removeFlight();
        
        assertEquals(flight1, f1);
        assertEquals(flight2, f2);
        assertEquals(flight3, f3);
        assertEquals(0, runway.numberFlight(), "Should have no flights");
    }

    @Test
    public void testRemoveFlightFromEmpty() {
        Flight removed = runway.removeFlight();
        assertNull(removed, "Removing from an empty runway should return null");
        assertEquals(0, runway.numberFlight());
    }

    /**
     * Test of numberFlight method
     */
    @Test
    public void testNumberFlightEmpty() {
        assertEquals(0, runway.numberFlight(), "A new runway should have 0 flights");
    }

    @Test
    public void testNumberFlightAfterOperations() {
        assertEquals(0, runway.numberFlight());
        
        runway.assignFlight(flight1);
        assertEquals(1, runway.numberFlight());
        
        runway.assignFlight(flight2);
        assertEquals(2, runway.numberFlight());
        
        runway.removeFlight();
        assertEquals(1, runway.numberFlight());
    }

    /**
     * Test of getNumRunway method
     */
    @Test
    public void testGetNumRunway() {
        Runway runway0 = new Runway(0);
        Runway runway1 = new Runway(1);
        Runway runway5 = new Runway(5);
        
        assertEquals(0, runway0.getNumRunway());
        assertEquals(1, runway1.getNumRunway());
        assertEquals(5, runway5.getNumRunway());
    }

}
