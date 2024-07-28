public class Light implements SmartDevice {
    private String id;
    private boolean status;

    public Light(String id) {
        this.id = id;
        this.status = false; // Initially off
    }

    @Override
    public void turnOn() {
        status = true;
        System.out.println("Light " + id + " turned on.");
    }

    @Override
    public void turnOff() {
        status = false;
        System.out.println("Light " + id + " turned off.");
    }

    @Override
    public String getStatus() {
        return "Light " + id + " is " + (status ? "On" : "Off");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return "light";
    }
}

