
package es.uvigo.esei.aed1.activity9.airport;

import es.uvigo.esei.aed1.activity9.implementation.DinamicHashTable;
import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

public class Runway {
    private int numRunway;
    private DinamicHashTable<String> destinationsPartners;
    private Queue<Flight> flightsOnStandby;

    public Runway(int numRunway) {
        this.numRunway = numRunway;
        this.destinationsPartners = new DinamicHashTable<>(10);
        this.flightsOnStandby = new LinkedQueue<>();
    }

    public void assignDestination(String destination) {
        destinationsPartners.add(destination);
    }

    public void assignFlight(Flight v) {
        flightsOnStandby.add(v);
    }

    public Flight removeFlight() {
        if (!flightsOnStandby.isEmpty())
            return flightsOnStandby.remove();
        else
            return null;
    }

    public int getNumRunway() {
        return numRunway;
    }

    public boolean isDestination(String destination) {
        return destinationsPartners.search(destination);
    }

    public int numberFlight() {
        return flightsOnStandby.size();
    }
}
