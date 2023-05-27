

public enum MenuAdmin {
    ADD_FLIGHT,
    UPDATE_FLIGHT,
    REMOVE_FLIGHT,
    FLIGHT_SCHEDULE,
    SIGN_OUT;

    public static MenuAdmin getValue(int ordinal){
        return values()[ordinal-1];
    }
}
