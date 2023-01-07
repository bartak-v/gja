package cz.vutbr.fit.gja;

/**
 *
 * Main class of Hibernate example
 */
class Main {

    /**
     * Hibernate example main method. Creates 4 employees, updates 1, deletes 1,
     * shows projection and list of all employees in the DB-
     *
     * @param args
     */
    public static void main(String[] args) {

        ManageEmployee ME = new ManageEmployee();

        /* Add few employee records in database */
        Integer empID1 = ME.addEmployee("Zara", "Ali", 2000);
        Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee("John", "Paul", 5000);
        Integer empID4 = ME.addEmployee("Mohd", "Yasee", 3000);

        // usage of persist() and flush() to execute SQL in batches
        // ME.addBatchEmployees();
        /* Update employee's records */
        ME.updateEmployee(empID1, 5000);

        /* Delete an employee from the database */
        ME.deleteEmployee(empID2);

        /* List down employees and their salary using Scalar Query */
        ME.listEmployeesScalar();

        /* List down complete employees information using Entity Query */
        ME.listEmployeesEntity();
    }
}
