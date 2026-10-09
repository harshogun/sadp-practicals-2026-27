
package com.harsh.sadp.mobile;

public class Main {

    public static void main(String[] args) {
        testMobile(new BrandAFactory(), "Brand A");
        System.out.println();
        testMobile(new BrandBFactory(), "Brand B");
    }

    private static void testMobile(
            MobileFactory factory, String brandName) {

        System.out.println("--- " + brandName + " ---");

        Camera camera = factory.createCamera();
        VideoRecorder recorder = factory.createVideoRecorder();

        camera.takePhoto();
        recorder.recordVideo();
    }
}
