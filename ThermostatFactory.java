public class ThermostatFactory extends SmartDeviceFactory {
    @Override
    public SmartDevice createDevice(String id) {
        return new Thermostat(id, 70); // Default temperature
    }
}