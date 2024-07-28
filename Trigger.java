public class Trigger {
    private String condition;
    private String operator;
    private int value;
    private String action;

    public Trigger(String condition, String operator, int value, String action) {
        this.condition = condition;
        this.operator = operator;
        this.value = value;
        this.action = action;
    }

    public String getCondition() {
        return condition;
    }

    public String getOperator() {
        return operator;
    }

    public int getValue() {
        return value;
    }

    public String getAction() {
        return action;
    }

    public String getStatus() {
        return "{Condition: " + condition + ", operator: \"" + operator + "\", Value: \"" + value + "\", Action: \""+ action+"\"}";
    }

}