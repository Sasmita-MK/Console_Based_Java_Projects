public class Bus {
    private boolean seats[][];
    private int rows, columns;
    private String driverName, conductorDetails;
    private String busName, registrationNumber;
    private int id;
    private int crntrow, crntcol;
    
    public Bus(int rows, int columns, String driverName, String conductorDetails, String busName, String registrationNumber,
            int id) {
        seats = new boolean[rows][columns];
        this.driverName = driverName;
        this.conductorDetails = conductorDetails;
        this.busName = busName;
        this.registrationNumber = registrationNumber;
        this.id = id;
        crntrow = 0;
        crntcol = 0;
    }

    public boolean[][] getSeats() {
        return seats;
    }

    public void setSeats(boolean[][] seats) {
        this.seats = seats;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getConductorDetails() {
        return conductorDetails;
    }

    public void setConductorDetails(String conductorDetails) {
        this.conductorDetails = conductorDetails;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void displayBus() {
        System.out.println(this.id + " " + this.busName + " " + registrationNumber);
    }
    public int bookBus() {
        if(crntrow == rows-1 && crntcol == columns-1) return -1;
        if(crntcol == columns-1) crntrow++;
        seats[crntrow][crntcol] = false;
        return 1;
    }
}
