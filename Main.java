import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CentralHub hub = new CentralHub();

        SmartDeviceFactory lightFactory = new LightFactory();
        SmartDeviceFactory thermostatFactory = new ThermostatFactory();
        SmartDeviceFactory doorLockFactory = new DoorLockFactory();

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Smart Home System!");

        while (true) {
            System.out.print("1)To AddDevice "); 
            System.out.print("2)To RemoveDevice ");
            System.out.print("3)To TurnOn ");
            System.out.print("4)To TurnOff ");
            System.out.print("5)To SetSchedule ");
            System.out.print("6)To AddTrigger ");
            System.out.print("7)StatusReport ");
            System.out.print("8)ScheduleReport ");
            System.out.print("9)TiggerReport ");
            System.out.print("10)To set temperature ");
            System.out.println("11)exit ");
            System.out.print("Enter the choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter device type (light, thermostat, door): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter device ID: ");
                    String id = scanner.nextLine();
                    addDevice(hub, type, id);
                    break;

                case 2:
                    System.out.print("Enter device ID: ");
                    id = scanner.nextLine();
                    removeDevice(hub, id);
                    break;

                case 3:
                    System.out.print("Enter device ID: ");
                    id = scanner.nextLine();
                    hub.turnOnDevice(id);
                    break;

                case 4:
                    System.out.print("Enter device ID: ");
                    id = scanner.nextLine();
                    hub.turnOffDevice(id);
                    break;

                case 5:
                    System.out.print("Enter device ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter time (HH:MM): ");
                    String time = scanner.nextLine();
                    System.out.print("Enter command (Turn On/Turn Off): ");
                    String scheduleCommand = scanner.nextLine();
                    hub.setSchedule(id, time, scheduleCommand);
                    break;

                case 6:
                    System.out.print("Enter condition (temperature): ");
                    String condition = scanner.nextLine();
                    System.out.print("Enter operator (>, <, =): ");
                    String operator = scanner.nextLine();
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter action (turnOn/turnOff(ID)): ");
                    String action = scanner.nextLine();
                    hub.addTrigger(condition, operator, value, action);
                    break;

                case 7:
                    hub.statusReport();
                    break;
                case 8:
                    hub.printSchedules();
                    break;
                case 9:
                    hub.printTriggers();
                    break;
                
                case 10:
                    System.out.print("Enter thermostat ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter temperature: ");
                    int temperature = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    hub.setTemperature(id, temperature);
                    break;
                    
                case 11:
                    System.out.println("Exiting Smart Home System...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Please try again.");
                    break;
            }
        }
    }

    private static void addDevice(CentralHub hub, String type, String id) {
        SmartDeviceFactory factory;

        switch (type.toLowerCase()) {
            case "light":
                factory = new LightFactory();
                break;
            case "thermostat":
                factory = new ThermostatFactory();
                break;
            case "door":
                factory = new DoorLockFactory();
                break;
            default:
                System.out.println("Unknown device type.");
                return;
        }

        SmartDevice device = new DeviceProxy(factory.createDevice(id));
        hub.addDevice(device);
    }

    private static void removeDevice(CentralHub hub, String id) {
        for (SmartDevice device : hub.getDevices()) {
            if (device.getId().equals(id)) {
                hub.removeDevice(device);
                return;
            }
        }
        System.out.println("Device with ID " + id + " not found.");
    }
}
