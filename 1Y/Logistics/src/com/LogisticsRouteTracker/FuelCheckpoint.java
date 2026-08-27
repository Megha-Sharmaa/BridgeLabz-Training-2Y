package com.LogisticsRouteTracker;
class FuelCheckpoint extends Checkpoint {
    public FuelCheckpoint(String id, String location, double distance, double expected, double actual) {
        super(id, location, distance, expected, actual);
    }

    @Override
    public boolean isCritical() { return true; }

    @Override
    public String getType() { return "FuelCheckpoint"; }

    @Override
    public double calculatePenalty() {
        return isDelayed() ? 10.0 : 0.0;
    }
}
