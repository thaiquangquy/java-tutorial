package design_patterns.structural.bridge;

import design_patterns.structural.bridge.devices.Device;
import design_patterns.structural.bridge.devices.Radio;
import design_patterns.structural.bridge.devices.Tv;
import design_patterns.structural.bridge.remotes.AdvancedRemote;
import design_patterns.structural.bridge.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    private static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
