public class Schedule {
    private String deviceId;
    private String time;
    private String command;

    public Schedule(String deviceId, String time, String command) {
        this.deviceId = deviceId;
        this.time = time;
        this.command = command;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getTime() {
        return time;
    }

    public String getCommand() {
        return command;
    }

    public String getStatus() {
        return "{device: " + deviceId + ", time: \"" + time + "\", command: \"" + command + "\"}";
    }
}