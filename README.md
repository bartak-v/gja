# gja

A Java examples project for GJA class at BUT FIT

### Prerequisites

 The project was developed in [Apache Netbeans 16](https://netbeans.apache.org/download/index.html) with [Eclipse Temurin JDK 17](https://adoptium.net/temurin/releases/?version=17) and [Eclipse Glassfish 7](https://projects.eclipse.org/projects/ee4j.glassfish/releases/7.0.0) (Jakarta EE 10 API). Other prerequisite is that the user is already familiar with deploying Java Web Applications onto the server. If not, user can read
 the documentation of the provided tools - as that is out of scope of this project.

### Installation and run

- Install Glassfish 7 (either manually or through Netbeans)
- Run Glassfish (either manually or through Netbeans)
- Deploy the compiled .war file onto the Glassfish server (defaultly through [http://localhost:4848](http://localhost:4848))

- You can also build the project yourself through standard practice in Netbeans (or manually using Maven.)

### Deploying .war files to Glassfish (Linux but it should work on Windows too)

- Download and install GlassFish 7 on your computer. You can download it from the following link:
    <https://glassfish.java.net/download.html>

- Once GlassFish is installed, start the domain. You can start the domain by running the following command (in the glassfish folder -> glassfish/bin):
    `asadmin start-domain` - for this to work you have to have correctly set the JAVA_HOME environment variable to where you have your JDK installed.
    We recommend using [Eclipse Temurin JDK 17.0.5+8](https://adoptium.net/temurin/releases/?version=17). JAVA_HOME should be set to ...example_jdk_path/bin

- Next, open a web browser and navigate to the GlassFish Administration Console at the following URL:
    <http://localhost:4848/>

- If it wants login credentials, either leave them empty (username admin and empty password or you can follow <https://docs.oracle.com/cd/E18930_01/html/821-2416/giubb.html> it should be admin admin...)

- Log in to the Administration Console using the default username.

- In the left navigation menu, click on the "Applications" link.

- Click on the "Deploy..." button.

- In the "Deploy Applications" screen, click on the "Choose File" button and select the example .war file that you want to deploy.

- In the next screen, you can specify deployment options such as the context root and the target server (you can leave the defaults). Make any necessary changes and click on the "Finish" button to deploy the .war file.

- Click on the "Applications" on the left again and "Launch" the specified Application. It should show you the links, but we reccomend to change the Context Root in the application to something like /servlet_jsp_example (instead of /servlet_jsp_example-14374286702991946667.0 etc.) or just leave it and use it as the root of the examples.

- The .war file will now be deployed to GlassFish and should be accessible at the specified context root. You can check the URLs we specify in the examples section.

#### Servlet Examples

##### First example (/servlet_example)

- The Servlet example is a Random Number Guessing game. The class implements HTTP requests and utilizes Cookies for primitive session keeping.
- You can test the Example Servlet via  a web browser or "API-testing" program like [Postman](https://www.postman.com/) or cURL (manipulating raw HTTP requests sent to e.g.<http://localhost:8080/servlet_example/ExampleServlet>) - You need to use something like Postman to test DELETE and PUT methods - as they can't be called from HTML page.
- You can test GET, POST, PUT, DELETE  HTTP requests on the Servlet.
- By calling PUT manually you restart the game. By calling DELETE you delete the Cookies and Restart the Game (deletes your username, high score etc.) - this will be only available through cURL and/or Postman as they have different sessions than your browser.
- This example, showing basic capabilities of Servlets is also a deterrent example of why it is better to use something like JSP for HTML rendering.

##### Second example (/servlet_upload_example)

- Second Servlet example is an updated File Upload servlet using the capabilities of Jakarta EE 10 (Servlet 3.0+ in-house fileupload).
- You can deploy it the same way you did the first example (or any other .war as has been specified before).
- After deploying, you can should find it at <http://localhost:8080/servlet_upload_example/> or through Applications -> Launch in Glassfish Admin GUI.

### JSP Example
