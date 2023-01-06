# gja

A Java examples project for GJA class at BUT FIT.
This is the global readme with all information and all examples. 
This readme has been copied (and further specified for concrete examples) in each of the examples folders so they can be distributed separately.
Also the .war files are included with each project for people that just want to try them out without installing the necessary development tools.

### Javadoc Documentation

Automatically generated Javadoc documentation can be found in the `doc/` folder. Open the `index.html` in each documentation to see the Javadoc.

### Prerequisites

 The project was developed in [Apache Netbeans 16](https://netbeans.apache.org/download/index.html) with [Eclipse Temurin JDK 17](https://adoptium.net/temurin/releases/?version=17) and [Eclipse Glassfish 7](https://projects.eclipse.org/projects/ee4j.glassfish/releases/7.0.0) (Jakarta EE 10 API). Other prerequisite is that the user is somehow familiar with deploying Java Web Applications onto the server. If not, user can read
 the provided documentation.

### Installation and run

- Install Glassfish 7 (either manually or through Netbeans)
- Run Glassfish (either manually or through Netbeans)
- Deploy the compiled .war file onto the Glassfish server (defaultly through [http://localhost:4848](http://localhost:4848))

- You can also build the project yourself through standard practice in Netbeans (or manually using Maven.)

### Deploying .war files to Glassfish (Linux but it should work on Windows too)

- The projects contain `.war` 

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

<div style="page-break-after: always"></div>

#### Servlet Examples

##### First example (/servlet_example/ExampleServlet)

- For deployment see [Section on .war deployment](#deploying-war-files-to-glassfish-linux-but-it-should-work-on-windows-too).
- The Servlet example is a Random Number Guessing game. The class implements HTTP requests and utilizes Cookies for primitive session keeping.
- You can test the Example Servlet via  a web browser or "API-testing" program like [Postman](https://www.postman.com/) or cURL (manipulating raw HTTP requests sent to e.g.<http://localhost:8080/servlet_jsp_example/ExampleServlet>) - You need to use something like Postman to test DELETE and PUT methods - as they can't be called from HTML page.
- You can test GET, POST, PUT, DELETE  HTTP requests on the Servlet.
- By calling PUT manually you restart the game. By calling DELETE you delete the Cookies and Restart the Game (deletes your username, high score etc.) - this will be only available through cURL and/or Postman as they have different sessions than your browser.
- This example, showing basic capabilities of Servlets is also a deterrent example of why it is better to use something like JSP for HTML rendering.

##### Second example (/servlet_upload_example/)

- Second Servlet example is an updated multiple File Upload servlet using the capabilities of Jakarta EE 10 (Servlet 3.0+ in-house fileupload).
- It's capabilities are to upload multiple files and validate them in some ways (check that they are images, their size etc.).
- You can also view the uploaded images through simple HTML page.
- You can deploy it the same way you did the first example ([Section on .war deployment](#deploying-war-files-to-glassfish-linux-but-it-should-work-on-windows-too)).
- After deploying, you should find it at <http://localhost:8080/servlet_upload_example/> or through Applications -> Launch in Glassfish Admin GUI.

#### JSP Examples 2.0

- For deployment see [Section on .war deployment](#deploying-war-files-to-glassfish-linux-but-it-should-work-on-windows-too).
- After deployment, you should find the app running on <http://localhost:8080/JSPExamples/>
- This is a set of JSP examples that showcase various JSP scenarios.
- User can test simple `calendar` shopping `cart` `mail` and `number guesser game`.
- We have updated and refactored the older GJA JSP examples, because they are pretty all-embracing already.
- They have been refactored to run out of box with JDK 17 and Glassfish 7 and support deployment from Netbeans.
- New unified Bootstrap UI (similar to the new servlet examples) has been created and the functionality of the project has been tested with Glassfish 7 and JDK 17.
- Compiled .war is added to the root of the projects for easy deployment.
- Javadoc has been generated and put into `doc/`.
