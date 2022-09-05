public record IOTEvent(int id, String location, double temp, int battery) {

    @Override
    public String toString() {
        return id + "," + location + "," + temp + "," + battery;
    }
}
