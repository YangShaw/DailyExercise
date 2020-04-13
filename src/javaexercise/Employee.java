package javaexercise;

public class Employee extends Person {

    private String office;
    private double wages;
    private MyDate employedDate;

    public Employee() {
        super();
    }

    public Employee(String name, String addr, String phone, String email, String office, double wages,
                    MyDate employedDate) {
        super(name, addr, phone, email);
        // TODO Auto-generated constructor stub
        this.office = office;
        this.wages = wages;
        this.employedDate = employedDate;
    }

    @Override
    public String toString() {
        return "Employee [name=" + this.getName() + "]";
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getWages() {
        return wages;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }

    public MyDate getEmployedDate() {
        return employedDate;
    }

    public void setEmployedDate(MyDate employedDate) {
        this.employedDate = employedDate;
    }


}
