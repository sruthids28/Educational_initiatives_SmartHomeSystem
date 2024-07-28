import java.util.ArrayList;
import java.util.List;

public class CentralHub {
    private List<SmartDevice> devices = new ArrayList<>();
    private List<Schedule> schedules = new ArrayList<>();
    private List<Trigger> triggers = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
        System.out.println("Added " + device.getType() + " with ID " + device.getId());
    }

    public void removeDevice(SmartDevice device) {
        devices.remove(device);
        System.out.println("Removed " + device.getType() + " with ID " + device.getId());
    }

    public void turnOnDevice(String id) {
        for (SmartDevice device : devices) {
            if (device.getId().equals(id)) {
                device.turnOn();
                notifyDevices();
                break;
            }
        }
    }

    public void turnOffDevice(String id) {
        for (SmartDevice device : devices) {
            if (device.getId().equals(id)) {
                device.turnOff();
                notifyDevices();
                break;
            }
        }
    }

    public void setSchedule(String id, String time, String command) {
        schedules.add(new Schedule(id, time, command));
        System.out.println("Scheduled " + command + " for device " + id + " at " + time);
    }

    public void addTrigger(String condition, String operator, int value, String action) {
        triggers.add(new Trigger(condition, operator, value, action));
        System.out.println("Added trigger: " + condition + " " + operator + " " + value + " -> " + action);
    }

    private void notifyDevices() {
        for (SmartDevice device : devices) {
            System.out.println(device.getStatus());
        }
    }

    public void statusReport() {
        for (SmartDevice device : devices) {
            System.out.println(device.getStatus());
        }
    }
    public void printSchedules() {
        for (Schedule schedule : schedules) {
            System.out.println(schedule.getStatus());
        }
    }

    public void printTriggers() {
        for (Trigger trigger : triggers) {
            System.out.println(trigger.getStatus());
        }
    }

    public void setTemperature(String id, int temperature) {
        for (SmartDevice device : devices) {
            if (device.getId().equals(id) && device instanceof Thermostat) {
                ((Thermostat) device).setTemperature(temperature);
                break;
            }
        }
    }

    public int getTemperature(String id) {
        for (SmartDevice device : devices) {
            if (device.getId().equals(id) && device instanceof Thermostat) {
                return ((Thermostat) device).getTemperature();
            }
        }
        return -1;  // Return an invalid temperature if not found
    }



    public List<SmartDevice> getDevices() {
        return devices;
    }
}
