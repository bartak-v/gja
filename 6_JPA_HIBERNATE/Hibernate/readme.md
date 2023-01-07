# Hibernate Examples

## HibernateExample and HibernateAnnotation

- Usage of Hibernate framework. A MySQL connection needs to be configured in *hibernate.cfg.xml*. The example also provides SQL file for table creation.
- There is a *Employee* class and *Employee.hbm.xml* mapping defined upon the class. The mapping is registered in *hibernate.cfg.xml*.
- *ManageEmployee* class implements operations:
      - addBatchEmployees() - usage of persist() and flush() to execute SQL commands in batches
      - addEmployee(fname, lname, salary) - add record to table
      - deleteEmployee(ID) - delete record from table by ID
      - listEmployeesEntity() - select all records
      - listEmployeesScalar() - projection
      - updateEmployee(ID, salary) - update record by ID
- *MyInterceptor* has methods, which are called on Hibernate events like *onSave*.  The interceptor is created when a DB session is created:
```Java
// Session session = factory.openSession();
Session session = factory.withOptions().interceptor(new MyInterceptor()).openSession();
```
- HiberhnateAnnotation is a project (with no fuctionality) with annotation Employee mapping instead of XML.