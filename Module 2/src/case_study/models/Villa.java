package case_study.models;

public class Villa extends Facility implements Comparable<Villa>{
    private String roomStandard;
    private double poolArea;
    private int numberFloor;

    public Villa(String nameService, double useArea, double rentCost, int maxPeople, String rentType, String roomStandard, double poolArea, int numberFloor) {
        super(nameService, useArea, rentCost, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public Villa() {
    }

    public Villa(String roomStandard, double poolArea, int numberFloor) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
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
                "," + poolArea +
                "," + numberFloor;
    }
    public String showInfo() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberFloor=" + numberFloor +
                ", nameService='" + nameService + '\'' +
                ", useArea=" + useArea +
                ", rentCost=" + rentCost +
                ", maxPeople=" + maxPeople +
                ", rentType='" + rentType + '\'' +
                '}';
    }

    @Override
    public int compareTo(Villa o) {
        return 0;
    }
}
