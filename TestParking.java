package manager;

import model.Vehicle;

public class TestParking {

    public static void main(String[] args) {

        ParkingManager manager =
                new ParkingManager();

        Vehicle v1 =
                new Vehicle(
                        "V001",
                        "KDA123A",
                        "John",
                        "Small");

        manager.registerVehicle(v1);

        System.out.println(
                "Assigned Slot: "
                        + v1.getAssignedSlot());

        Vehicle found =
                manager.searchVehicle("V001");

        System.out.println(
                "Vehicle Found: "
                        + found.getOwnerName());
    }
}