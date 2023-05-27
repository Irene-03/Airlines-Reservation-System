public enum MenuUser {
    CHANGE_PASSWORD,
    SEARCH_FLIGHT,
    BOOKING_TICKET,
    TICKET_CANCELLATION,
    BOOKED_TICKETS,
    ADD_CHARGE,
    FLIGHT_SCHEDULE,
    SIGN_OUT;

    public static MenuUser getValue(int ordinal){
        return values()[ordinal-1];
    }
}
