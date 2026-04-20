package es.uvigo.esei.aed1.activity9.airport;

public class Airport {

    private Runway[] runways;

    public Airport(int numRunways) {
        runways = new Runway[numRunways];

        for (int i = 0; i < numRunways; i++)
            runways[i] = new Runway(i);

    }

    public void assignDestinationRunway(int numRunway, String destination) {
        runways[numRunway].assignDestination(destination);
    }

    public void assignFlightRunway(Flight v) {
        /*
         * Runway targetRunway = null;
         * 
         * for (Runway runway : runways) { if (runway.isDestination(v.getDestination())) { if (targetRunway == null || runway.numberFlight() < targetRunway.numberFlight()) targetRunway = runway; } }
         * 
         * targetRunway.assignFlight(v);
         */

        int numFlights = Integer.MAX_VALUE;
        int numRunway = -1;

        for (int i = 0; i < runways.length; i++) {
            if (runways[i].isDestination(v.getDestination()) && runways[i].numberFlight() < numFlights) {
                numFlights = runways[i].numberFlight();
                numRunway = i;
            }
        }

        runways[numRunway].assignFlight(v);
    }

    public Flight takeoffFlight(int numRunway) {
        return runways[numRunway].removeFlight();
    }

    public int getNumRunways() {
        return runways.length;
    }

    public int getNumAssignedFlights() {
        int numAssignedFlights = 0;

        for (Runway runway : runways)
            numAssignedFlights += runway.numberFlight();

        return numAssignedFlights;
    }
}
