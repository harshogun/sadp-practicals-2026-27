
package com.harsh.sadp.heartadapter;

public class HeartModel {

    private int heartRate;

    public HeartModel(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        if (heartRate <= 0) {
            throw new IllegalArgumentException(
                    "Heart rate must be positive."
            );
        }

        this.heartRate = heartRate;
    }
}
