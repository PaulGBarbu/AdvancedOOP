package PathFinding;

import org.junit.Test;

import java.time.Duration;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AirportPathFinding {

    private Collection<Flight> availableFlights;

    public Stream<Flight> getFlightsForOrigin(Airport origin) {
        return availableFlights.stream()
                .filter(x -> x.getOrigin() == origin);
    }

    public List<Flight> getShortestFlightByRoute(Airport origin, Airport destination){

        class TempList{
            private LinkedList<Flight> list = new LinkedList<>();
            private int duration = 0;

            public int getDuration() {
                return duration;
            }

            public void addFlight(Flight f){
                list.add(f);
                duration += f.getDuration().getSeconds();
            }

            public boolean checkList(){
                return list.getLast().getDestination() == destination;
            }
        }

        getFlightsForOrigin(origin)
                .forEach(x -> new TempList().addFlight(x));
        return null;
    }
}
