/*
 * Adapted from http://www.tutorialspoint.com/hibernate/hibernate_native_sql.htm
 */
package cz.vutbr.fit.gja;

/**
 * A simple entity used in this example.
 */
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    /**
     * Empty constructor for serialization
     */
    public Employee() {
    }

    /**
     * @param fname First name
     * @param lname Last name
     * @param salary employee salary
     */
    public Employee(String fname, String lname, int salary) {
        this.firstName = fname;
        this.lastName = lname;
        this.salary = salary;
    }

    /**
     * @return employee id. Not null after persisting
     */
    public int getId() {
        return id;
    }

    /**
     * @param id employee id used as primary key to DB
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return employee first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param first_name First name
     */
    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    /**
     * @return employee last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param last_name Last name
     */
    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    /**
     * @return employee salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary employee salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
