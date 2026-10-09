
package com.harsh.sadp.mobile;

public class BrandAFactory implements MobileFactory {

    @Override
    public Camera createCamera() {
        return new BrandACamera();
    }

    @Override
    public VideoRecorder createVideoRecorder() {
        return new BrandAVideoRecorder();
    }
}
