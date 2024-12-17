import java.util.ArrayList;

public class Admin {
    private String password;
    private ArrayList<Bus> buses;
    private int totalBuses;
    public Admin() {
        password = "admin";
        buses = new ArrayList<>();
        totalBuses = 0;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Bus> getBuses() {
        return buses;
    }

    public void registerBus(Bus bus) {
        buses.add(bus);
        totalBuses++;
    }

    public void deleteBus(int id) {
        for(int i=0 ; i<totalBuses ; i++) {
            int crntId = buses.get(i).getId();
            if(crntId == id) {
                buses.remove(i);
                break;
            }
        }
    }
}
