package Mixin;

import org.junit.Test;

public class TestMixin {
    /**
     * This one is a Stateless Mixin as far as I'm concerned since Interfaces can only have constance
     * meaning you cant have a counter to lets say count the amount of cargo everytime its loaded
     */
    @Test
    public void testMixin(){
        AircraftCarrier ac = new AircraftCarrier();
        ac.land();                  // Method implemented in Airport
        ac.loadCargo();             // Method implemented in Ship
        ac.aircraftCarrierMethod(); // Method implemented in AircraftCarrier
    }
}
