package entity;

public class Employee extends User {
    private String employeeCode;
    private String position;
    private String department;
    private long salary;

    public Employee(int id, String username, String password, String fullName, String nationalIdentificationNumber, String hometown, int age, String sex, String occupation, String address, String phoneNumber, String email, String employeeCode, String position, String department, long salary) {
        super(id, username, password, fullName, nationalIdentificationNumber, hometown, age, sex, occupation, address, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }

    public Employee(){}

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", hometown='" + hometown + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", occupation='" + occupation + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
