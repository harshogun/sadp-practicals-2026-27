
package com.harsh.sadp.proxy;

public class ProxyImage implements Image {

    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }

        realImage.display();
    }
}
