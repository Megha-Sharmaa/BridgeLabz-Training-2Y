package com.LogisticsRouteTracker;

public class Main {
    public static void main(String[] args) {
        Driver d1 = new Driver("D1204", "Kavita Nair");

        d1.routeHistory.addCheckpoint(new DeliveryCheckpoint("C1", "Warehouse A", 30, 40, 50));
        d1.routeHistory.addCheckpoint(new FuelCheckpoint("C2", "Pump 12", 20, 15, 15));
        d1.routeHistory.addCheckpoint(new RestCheckpoint("C3", "Motel X", 40, 60, 65));
        d1.routeHistory.addCheckpoint(new DeliveryCheckpoint("C4", "Client Hub", 30, 45, 60));

        d1.printSummary();
    }
}