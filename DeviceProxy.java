public class DeviceProxy implements SmartDevice {
    private SmartDevice realDevice;

    public DeviceProxy(SmartDevice realDevice) {
        this.realDevice = realDevice;
    }

    @Override
    public void turnOn() {
        System.out.println("Proxy: Turning on device " + realDevice.getId());
        realDevice.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Proxy: Turning off device " + realDevice.getId());
        realDevice.turnOff();
    }

    @Override
    public String getStatus() {
        return "Proxy: " + realDevice.getStatus();
    }

    @Override
    public String getId() {
        return realDevice.getId();
    }

    @Override
    public String getType() {
        return realDevice.getType();
    }
}
