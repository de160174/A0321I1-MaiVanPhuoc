package case_study.models;

public abstract class Person {
    protected String name;
    protected String date;
    protected boolean gender;
    protected int idCard;
    protected String email;

    public Person() {
    }

    public Person(String name, String date, boolean gender, int idCard, String email) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.idCard = idCard;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
