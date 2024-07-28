public class DoorLockFactory extends SmartDeviceFactory {
    @Override
    public SmartDevice createDevice(String id) {
        return new DoorLock(id);
    }
}