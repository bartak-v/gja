# gja
A Java examples project for GJA class at BUT FIT


# 1 - Servlets + JSP example programs

### Prerequisites
 The project was developed in [Apache Netbeans 16](https://netbeans.apache.org/download/index.html) with [Eclipse Temurin JDK 17](https://adoptium.net/temurin/releases/?version=17) and [Eclipse Glassfish 7](https://projects.eclipse.org/projects/ee4j.glassfish/releases/7.0.0) (Jakarta EE 10 API). Other prerequisite is that the user is already familiar with deploying Java Web Applications onto the server. If not, user can read 
 the documentation of the provided tools - as that is out of scope of this project.

### Installation and run 
 - Install Glassfish 7 (either manually or through Netbeans)
 - Run Glassfish (either manually or through Netbeans) 
 - Deploy the compiled .war file onto the Glassfish server (defaultly through [http://localhost:4848](http://localhost:4848))
 - - You can also build the project yourself through standard practice in Netbeans (or manually using Maven.)

#### Servlet Example
 - The Servlet example is a Random Number Guessing game. The class implements HTTP requests and utilizes Cookies for primitive session keeping.
 - You can test the Example Servlet via  a web browser or "API-testing" program like [Postman](https://www.postman.com/) or CURL (manipulating raw HTTP requests sent to http://localhost:8080/servlet_jsp_example/ExampleServlet) - You need to use something like Postman to test DELETE and PUT methods - as they can't be called from HTML page.
 - You can test GET, POST, PUT, DELETE  HTTP requests on the Servlet. 

#### JSP Example