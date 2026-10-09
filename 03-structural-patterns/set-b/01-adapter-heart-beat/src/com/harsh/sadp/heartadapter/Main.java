package com.harsh.sadp.heartadapter;

public class Main {

    public static void main(String[] args) {

        HeartModel heart = new HeartModel(72);

        BeatModel beat = new HeartModelAdapter(heart);

        beat.start();

        System.out.println(
                "Current BPM: " + beat.getBPM()
        );

        heart.setHeartRate(85);

        System.out.println(
                "Updated BPM: " + beat.getBPM()
        );

        beat.stop();
    }
}
