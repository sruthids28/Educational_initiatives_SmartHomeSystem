public class LightFactory extends SmartDeviceFactory {
    @Override
    public SmartDevice createDevice(String id) {
        return new Light(id);
    }
}
