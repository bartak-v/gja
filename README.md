# gja
A Java examples project for GJA class at BUT FIT


# 1 - Servlets + JSP example program

### Prerequisites
 The project was developed in [Apache Netbeans 16](https://netbeans.apache.org/download/index.html) with [Eclipse Temurin JDK 17](https://adoptium.net/temurin/releases/?version=17) and [Eclipse Glassfish 7](https://projects.eclipse.org/projects/ee4j.glassfish/releases/7.0.0) (Jakarta EE 9.1 API). Other prerequisite is that the user is already familiar with deploying Java Web Applications onto the server. If not, user can read 
 the documentation of provided tools - as that is out of scope of this project.

### Installation and run 
 - Install Glassfish 7 (either manually or through Netbeans)
 - Run Glassfish (either manually or through Netbeans) 
 - Deploy the compiled .war file onto the Glassfish server (defaultly through [http://localhost:4848](http://localhost:4848))
 - - You can also build the project yourself through standard practice in Netbeans (or manually using maven.)

#### Servlet Example
 - The Servlet example is a Random Number Guessing game. The class implements all HTTP requests and utilizes Cookies.
 - You can test the Example Servlet via program like [Postman](https://www.postman.com/) (manipulating raw HTTP requests sent to http://localhost:8080/servlet_jsp_example/ExampleServlet)
 or through a web browser at the same addres.
 - You can test all standard HTTP requests on the 

#### JSP Example