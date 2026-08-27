package com.LogisticsRouteTracker;


class RestCheckpoint extends Checkpoint {
    public RestCheckpoint(String id, String location, double distance, double expected, double actual) {
        super(id, location, distance, expected, actual);
    }

    @Override
    public boolean isCritical() { return false; }

    @Override
    public String getType() { return "RestCheckpoint"; }

    @Override
    public double calculatePenalty() {
        if (isDelayed() && (actualDuration - expectedDuration) > 30) {
            return (actualDuration - expectedDuration) * 0.5;
        }
        return 0.0;
    }
}

