package es.uvigo.esei.aed1.activity9.airport;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AirportTestCase {

    private Airport airport;
    private Flight flight1;
    private Flight flight2;
    private Flight flight3;
    private Flight flight4;
    private Flight flight5;
    private Flight flight6;

    @BeforeEach
    public void setUp() {
        airport = new Airport(2);
        flight1 = new Flight("B876", "Madrid", "Paris");
        flight2 = new Flight("B747", "Vigo", "Barcelona");
        flight3 = new Flight("B765", "Santiago", "Barcelona");
        flight4 = new Flight("B747", "Vigo", "Barcelona");
        flight5 = new Flight("B765", "Santiago", "Barcelona");
        flight6 = new Flight("B876", "Madrid", "Paris");
    }

    /**
     * Test of constructor
     */
    @Test
    public void testConstructor() {
        Airport airport2 = new Airport(3);
        assertEquals(3, airport2.getNumRunways());
        
        Airport airport1 = new Airport(1);
        assertEquals(1, airport1.getNumRunways());
    }

    /**
     * Test of assignDestinationRunway method
     */
    @Test
    public void testAssignDestinationRunway() {
        airport.assignDestinationRunway(0, "Barcelona");
        airport.assignDestinationRunway(0, "Paris");
        
        assertEquals(2, airport.getNumRunways());
    }

    @Test
    public void testAssignDestinationMultipleRunways() {
        airport.assignDestinationRunway(0, "Barcelona");
        airport.assignDestinationRunway(1, "Paris");
        
        assertEquals(2, airport.getNumRunways());
    }

    /**
     * Test of assignFlightRunway method
     */
    @Test
    public void testAssignSingleFlight() {
        airport.assignDestinationRunway(0, "Paris");
        airport.assignFlightRunway(flight1);
        
        assertEquals(1, airport.getNumAssignedFlights());
    }

    @Test
    public void testAssignMultipleFlights() {
        airport.assignDestinationRunway(0, "Barcelona");
        airport.assignDestinationRunway(0, "Paris");
        airport.assignDestinationRunway(1, "Paris");
        
        airport.assignFlightRunway(flight1);
        airport.assignFlightRunway(flight2);
        airport.assignFlightRunway(flight3);
        
        assertEquals(3, airport.getNumAssignedFlights());
    }

    @Test
    public void testAssignFlightToProperRunway() {
        airport.assignDestinationRunway(0, "Barcelona");
        airport.assignDestinationRunway(1, "Paris");
        
        airport.assignFlightRunway(flight1); // destino Paris -> pista 1
        airport.assignFlightRunway(flight2); // destino Barcelona -> pista 0
        
        assertEquals(2, airport.getNumAssignedFlights());
    }

    @Test
    public void testAssignFlightBalancing() {
        airport.assignDestinationRunway(0, "Barcelona");
        airport.assignDestinationRunway(1, "Barcelona");
        
        // Ambas pistas tienen el destino Barcelona
        airport.assignFlightRunway(flight2); // Barcelona
        airport.assignFlightRunway(flight3); // Barcelona
        airport.assignFlightRunway(flight4); // Barcelona
        
        // Debe distribuir los vuelos de manera balanceada
        assertEquals(3, airport.getNumAssignedFlights());
    }

    /**
     * Test of takeoffFlight method
     */
    @Test
    public void testTakeoffFlight() {
        airport.assignDestinationRunway(0, "Paris");
        airport.assignFlightRunway(flight1);
        
        Flight departed = airport.takeoffFlight(0);
        assertEquals(flight1, departed);
        assertEquals(0, airport.getNumAssignedFlights());
    }

    @Test
    public void testTakeoffFlightFromEmptyRunway() {
        airport.assignDestinationRunway(0, "Paris");
        
        Flight departed = airport.takeoffFlight(0);
        assertNull(departed);
    }

    @Test
    public void testTakeoffMultipleFlights() {
        airport.assignDestinationRunway(0, "Barcelona");
        airport.assignDestinationRunway(1, "Paris");
        
        airport.assignFlightRunway(flight1);
        airport.assignFlightRunway(flight2);
        
        Flight f1 = airport.takeoffFlight(1); // Paris
        Flight f2 = airport.takeoffFlight(0); // Barcelona
        
        assertEquals(flight1, f1);
        assertEquals(flight2, f2);
        assertEquals(0, airport.getNumAssignedFlights());
    }

    /**
     * Test of getNumRunways method
     */
    @Test
    public void testGetNumRunways() {
        Airport airport1 = new Airport(1);
        assertEquals(1, airport1.getNumRunways());
        
        Airport airport3 = new Airport(3);
        assertEquals(3, airport3.getNumRunways());
        
        Airport airport5 = new Airport(5);
        assertEquals(5, airport5.getNumRunways());
    }

    /**
     * Test of getNumAssignedFlights method
     */
    @Test
    public void testGetNumAssignedFlightsEmpty() {
        assertEquals(0, airport.getNumAssignedFlights());
    }

    @Test
    public void testGetNumAssignedFlightsAfterAssignments() {
        airport.assignDestinationRunway(0, "Barcelona");
        airport.assignDestinationRunway(0, "Paris");
        airport.assignDestinationRunway(1, "Paris");
        
        airport.assignFlightRunway(flight1);
        assertEquals(1, airport.getNumAssignedFlights());
        
        airport.assignFlightRunway(flight2);
        assertEquals(2, airport.getNumAssignedFlights());
        
        airport.assignFlightRunway(flight3);
        assertEquals(3, airport.getNumAssignedFlights());
    }

    @Test
    public void testGetNumAssignedFlightsAfterTakeoff() {
        airport.assignDestinationRunway(0, "Barcelona");
        airport.assignDestinationRunway(1, "Paris");
        
        airport.assignFlightRunway(flight1);
        airport.assignFlightRunway(flight2);
        airport.assignFlightRunway(flight3);
        
        assertEquals(3, airport.getNumAssignedFlights());
        
        airport.takeoffFlight(0);
        assertEquals(2, airport.getNumAssignedFlights());
        
        airport.takeoffFlight(1);
        assertEquals(1, airport.getNumAssignedFlights());
    }

    /**
     * Integration test: simulate airport operations
     */
    @Test
    public void testAirportOperations() {
        airport.assignDestinationRunway(0, "Barcelona");
        airport.assignDestinationRunway(0, "Paris");
        airport.assignDestinationRunway(1, "Paris");
        
        airport.assignFlightRunway(flight1); // Paris
        airport.assignFlightRunway(flight2); // Barcelona
        airport.assignFlightRunway(flight3); // Barcelona
        airport.assignFlightRunway(flight4); // Barcelona
        airport.assignFlightRunway(flight5); // Barcelona
        airport.assignFlightRunway(flight6); // Paris
        
        assertEquals(6, airport.getNumAssignedFlights());
        
        // Despegar vuelos en orden alternado
        Flight f1 = airport.takeoffFlight(0);
        assertNotNull(f1);
        
        Flight f2 = airport.takeoffFlight(1);
        assertNotNull(f2);
        
        assertEquals(4, airport.getNumAssignedFlights());
    }

}
