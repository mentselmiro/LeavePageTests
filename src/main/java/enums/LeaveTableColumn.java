package enums;

public enum LeaveTableColumn {
    FROM ("From"),
    TO("To"),
    DAYS("Days"),
    DAYS_OFF("Days off"),
    STATUS("Status"),
    ACTIONS ("Actions");

    String name;

    LeaveTableColumn(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
