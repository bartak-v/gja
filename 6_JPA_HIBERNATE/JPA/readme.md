# JPA Examples

## JPA-SE

- Shows basic usage of entity manager.
- The application uses ObjectDB for its easy implementation (no DB configuaration needed).
- Objects of Point class are stored in local object database, then being queried upon.
- Example shows selecting all points from database and two aggregation functions.

## JPA-EE

- The example once again uses ObjectDB.
- Similar to usage in SE, but this example uses user input and HTTP protocol to create objects to save
- ServletContextListener initializes object database and closes it on application stop
- on HTTP request *GuestServlet* checks if parameter *name* is not null. If not, creates a new Guest and saves into the object db
- The parameter is set via form in *guest.jsp*ä
- application runs at http://localhost:8080/JPA-EE