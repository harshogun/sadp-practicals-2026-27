
package com.harsh.sadp.mobile;

public class BrandBFactory implements MobileFactory {

    @Override
    public Camera createCamera() {
        return new BrandBCamera();
    }

    @Override
    public VideoRecorder createVideoRecorder() {
        return new BrandBVideoRecorder();
    }
}
