public class DoorLock implements SmartDevice {
    private String id;
    private boolean locked;

    public DoorLock(String id) {
        this.id = id;
        this.locked = true; // Initially locked
    }

    @Override
    public void turnOn() {
        locked = false;
        System.out.println("Door " + id + " unlocked.");
    }

    @Override
    public void turnOff() {
        locked = true;
        System.out.println("Door " + id + " locked.");
    }

    @Override
    public String getStatus() {
        return "Door " + id + " is " + (locked ? "Locked" : "Unlocked");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return "door";
    }
}
