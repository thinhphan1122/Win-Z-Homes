package entity;

public class Employee extends User {
    private String employeeCode;
    private String department;
    private String position;
    private long salary;

    public Employee(int id, String username, String password, String fullName, String address, String phoneNumber, String email, String employeeCode, String department, String position, long salary) {
        super(id, username, password, fullName, address, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    //Builder
    public Employee id(int id) {
        this.id = id;
        return this;
    }

    public Employee username(String username) {
        this.username = username;
        return this;
    }

    public Employee password(String password) {
        this.password = password;
        return this;
    }

    public Employee fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Employee address(String address) {
        this.address = address;
        return this;
    }

    public Employee phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Employee email(String email) {
        this.email = email;
        return this;
    }

    public Employee employeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
        return this;
    }

    public Employee position(String position) {
        this.position = position;
        return this;
    }

    public Employee department(String department) {
        this.department = department;
        return this;
    }

    public Employee salary(long salary) {
        this.salary = salary;
        return this;
    }

    public Employee createEmployee() {
        return new Employee(id, username, password, fullName, address, phoneNumber, email, employeeCode, position, department, salary);
    }
}
