/*
 * Adapted from http://www.tutorialspoint.com/hibernate/hibernate_native_sql.htm
 */
package cz.vutbr.fit.gja;

import jakarta.persistence.Query;
import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {

    private static SessionFactory factory;

    public ManageEmployee() {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Method to CREATE an employee in the database
     *
     * @param fname First name
     * @param lname Last name
     * @param salary Salary
     * @return Returns ID of created employee
     */
    public Integer addEmployee(String fname, String lname, int salary) {
        // Session session = factory.openSession();
        Session session = factory.withOptions().interceptor(new MyInterceptor()).openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    /**
     * Method to READ all the employees using Scalar Query
     */
    public void listEmployeesScalar() {
        // Session session = factory.openSession();
        Session session = factory.withOptions().interceptor(new MyInterceptor()).openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "SELECT firstName, salary FROM Employee";
            Query query = session.createQuery(sql, Object[].class);
            //query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List<Object[]> data = query.getResultList();

            for (Object[] row : data) {
                System.out.println(row[0]);
                System.out.println(row[1]);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Method to READ all the employees using Entity Query
     */
    public void listEmployeesEntity() {
        // Session session = factory.openSession();
        Session session = factory.withOptions().interceptor(new MyInterceptor()).openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "FROM Employee";
            Query query = session.createQuery(sql, Employee.class);

            List<Employee> employees = query.getResultList();

            for (Employee employee : employees) {

                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Method to UPDATE salary for an employee
     *
     * @param EmployeeID ID of an employee
     * @param salary New salary
     */
    public void updateEmployee(Integer EmployeeID, int salary) {
        // Session session = factory.openSession();
        Session session = factory.withOptions().interceptor(new MyInterceptor()).openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, EmployeeID);
            employee.setSalary(salary);
            session.merge(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Method to DELETE an employee from the records
     *
     * @param EmployeeID ID of an employee
     */
    public void deleteEmployee(Integer EmployeeID) {
        // Session session = factory.openSession();
        Session session = factory.withOptions().interceptor(new MyInterceptor()).openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, EmployeeID);
            session.remove(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Method to create employee records in batches
     */
    public void addBatchEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            for (int i = 0; i < 100000; i++) {
                String fname = "First Name " + i;
                String lname = "Last Name " + i;
                Integer salary = i;
                Employee employee = new Employee(fname, lname, salary);
                session.persist(employee);
                if (i % 50 == 0) {
                    session.flush();
                    session.clear();
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
