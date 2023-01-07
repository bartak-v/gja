/*
 * Adapted from http://www.tutorialspoint.com/hibernate/hibernate_annotations.htm
 */
package cz.vutbr.fit.gja;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * A Employee class with annotations for Hibernate. Class has annotation @Table
 * for DB table specification, fields have @Column annotations. See
 * https://www.techferry.com/articles/hibernate-jpa-annotations.html for all
 * possible annotations.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private int salary;

    /**
     * Empty constructor
     */
    public Employee() {
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param first_name
     */
    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    /**
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param last_name
     */
    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    /**
     *
     * @return salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     *
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
