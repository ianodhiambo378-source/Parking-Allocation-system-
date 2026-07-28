package model;

public class Vehicle {

    private String vehicleId;
    private String plateNumber;
    private String ownerName;
    private String size;
    private String assignedSlot;
    private String status;

    public Vehicle(String vehicleId,
                   String plateNumber,
                   String ownerName,
                   String size) {

        this.vehicleId = vehicleId;
        this.plateNumber = plateNumber;
        this.ownerName = ownerName;
        this.size = size;
        this.status = "Parked";
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getSize() {
        return size;
    }

    public String getAssignedSlot() {
        return assignedSlot;
    }

    public void setAssignedSlot(String assignedSlot) {
        this.assignedSlot = assignedSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}