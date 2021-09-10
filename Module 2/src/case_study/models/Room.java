package case_study.models;

public class Room extends Facility implements Comparable<Room> {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String nameService, double useArea, double rentCost, int maxPeople, String rentType, String freeService) {
        super(nameService, useArea, rentCost, maxPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }


    @Override
    public String toString() {
        return nameService +
                "," + useArea +
                "," + rentCost +
                "," + maxPeople +
                "," + rentType +
                "," + freeService;
    }
    public String showInfo() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                ", nameService='" + nameService + '\'' +
                ", useArea=" + useArea +
                ", rentCost=" + rentCost +
                ", maxPeople=" + maxPeople +
                ", rentType='" + rentType + '\'' +
                '}';
    }

    @Override
    public int compareTo(Room o) {
        return 0;
    }
}
