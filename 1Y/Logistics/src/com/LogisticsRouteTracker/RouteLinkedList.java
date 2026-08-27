package com.LogisticsRouteTracker;

import java.util.LinkedList;

public class RouteLinkedList<T extends Checkpoint> {
    private LinkedList<T> checkpoints;

    public RouteLinkedList() {
        checkpoints = new LinkedList<>();
    }

    public void addCheckpoint(T checkpoint) {
        checkpoints.add(checkpoint);
    }

    public boolean removeCheckpoint(String checkpointId) {
        return checkpoints.removeIf(cp -> cp.checkpointId.equals(checkpointId));
    }

    public T findCheckpoint(String checkpointId) {
        for (T cp : checkpoints) {
            if (cp.checkpointId.equals(checkpointId)) return cp;
        }
        return null;
    }

    public double computeTotalDistance() {
        double total = 0;
        for (T cp : checkpoints) {
            total += cp.distanceFromLast;
        }
        return total;
    }

    public double computeTotalPenalty() {
        double total = 0;
        for (T cp : checkpoints) {
            total += cp.calculatePenalty();
        }
        return total;
    }

    public void printRoute() {
        int i = 1;
        for (T cp : checkpoints) {
            System.out.println(i++ + ". " + cp.getType() + " – " + cp.locationName +
                    " – " + (cp.isDelayed() ? "Delayed" : "On Time") +
                    " – Penalty: " + cp.calculatePenalty());
        }
    }

    public boolean checkCriticalRoute() {
        boolean deliveryPresent = false, fuelPresent = false;
        for (T cp : checkpoints) {
            if (cp instanceof DeliveryCheckpoint) deliveryPresent = true;
            if (cp instanceof FuelCheckpoint) fuelPresent = true;
        }
        return deliveryPresent && fuelPresent;
    }
}