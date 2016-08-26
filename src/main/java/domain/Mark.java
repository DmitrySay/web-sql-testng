package domain;


public class Mark {

    private int id;
    private int studentId;
    private String name;
    private String surname;
    private int mark;
    
	
    public void setId(int id) {
        this.id = id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getMark() {
        return mark;
    }

    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
    @Override
    public String toString()
    {
        return "( id " +this.id+ ", studentId " +this.studentId+ ", name " +this.name+ ", surname " +this.surname+ ", mark " +this.mark +" )";
    }

}
