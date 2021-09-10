package case_study.models;

public class House extends Facility implements Comparable<House>{
    private String roomStandard;
    private int numberFloor;

    public House() {
    }

    public House(String roomStandard, int numberFloor) {
        this.roomStandard = roomStandard;
        this.numberFloor = numberFloor;
    }

    public House(String nameService, double useArea, double rentCost, int maxPeople, String rentType, String roomStandard, int numberFloor) {
        super(nameService, useArea, rentCost, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.numberFloor = numberFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return nameService +
                "," + useArea +
                "," + rentCost +
                "," + maxPeople +
                "," + rentType +
                "," + roomStandard +
                "," + numberFloor ;
    }
    public String showInfo() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", numberFloor=" + numberFloor +
                ", nameService='" + nameService + '\'' +
                ", useArea=" + useArea +
                ", rentCost=" + rentCost +
                ", maxPeople=" + maxPeople +
                ", rentType='" + rentType + '\'' +
                '}';
    }

    @Override
    public int compareTo(House o) {
        return 0;
    }
}
