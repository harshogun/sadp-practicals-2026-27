
package com.harsh.sadp.heartadapter;

public class HeartModelAdapter implements BeatModel {

    private final HeartModel heartModel;

    public HeartModelAdapter(HeartModel heartModel) {
        this.heartModel = heartModel;
    }

    @Override
    public void start() {
        System.out.println("Heart model monitoring started.");
    }

    @Override
    public void stop() {
        System.out.println("Heart model monitoring stopped.");
    }

    @Override
    public int getBPM() {
        return heartModel.getHeartRate();
    }
}
