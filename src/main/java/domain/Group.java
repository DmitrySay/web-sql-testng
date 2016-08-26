package domain;


public class Group {
    private int id;
    private int number;
    private String department;


    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getDepartment() {
        return department;
    }


    @Override
    public String toString()
    {
        return "( id "+this.id+", number "+this.number+", department "+this.department+" )";
    }

}
