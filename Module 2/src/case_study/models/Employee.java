package case_study.models;

public class Employee extends Person{
    private String employeeId;
    private String level;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String employeeId, String level, String position, double salary) {
        this.employeeId = employeeId;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name, String date, boolean gender, int idCard, String email, String employeeId, String level, String position, double salary) {
        super(name, date, gender, idCard, email);
        this.employeeId = employeeId;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return name +
                "," + date +
                "," + gender +
                "," + idCard +
                "," + email+
                "," +employeeId +
                "," + level +
                "," + position +
                "," + salary;
    }
    public String showInfo() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", gender=" + gender +
                ", idCard=" + idCard +
                ", email='" + email + '\'' +
                '}';
    }
}
