package model.bean;

public class Service {
    private String service_id;
    private String service_name;
    private int service_area;
    private double service_cost;
    private int service_max_people;
    private String standard_room;
    private String description;
    private double pool_area;
    private int number_of_floor;
    private String rent_type_id;
    private String service_type_id;

    public Service() {
    }

    public Service(String service_id, String service_name) {
        this.service_id = service_id;
        this.service_name = service_name;
    }

    public Service(String service_id, String service_name, int service_area, double service_cost, int service_max_people, String standard_room, String description, double pool_area, int number_of_floor, String rent_type_id, String service_type_id) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_max_people = service_max_people;
        this.standard_room = standard_room;
        this.description = description;
        this.pool_area = pool_area;
        this.number_of_floor = number_of_floor;
        this.rent_type_id = rent_type_id;
        this.service_type_id = service_type_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getService_area() {
        return service_area;
    }

    public void setService_area(int service_area) {
        this.service_area = service_area;
    }

    public double getService_cost() {
        return service_cost;
    }

    public void setService_cost(double service_cost) {
        this.service_cost = service_cost;
    }

    public int getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(int service_max_people) {
        this.service_max_people = service_max_people;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_of_floor() {
        return number_of_floor;
    }

    public void setNumber_of_floor(int number_of_floor) {
        this.number_of_floor = number_of_floor;
    }

    public String getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(String rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public String getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(String service_type_id) {
        this.service_type_id = service_type_id;
    }
}
