public class Thermostat implements SmartDevice {
    private String id;
    private int temperature;

    public Thermostat(String id, int temperature) {
        this.id = id;
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        System.out.println("Thermostat " + id + " is always on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat " + id + " cannot be turned off.");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " set to " + temperature + " degrees.");
    }

    public int getTemperature() {
        return this.temperature;
    }


    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return "thermostat";
    }
}
