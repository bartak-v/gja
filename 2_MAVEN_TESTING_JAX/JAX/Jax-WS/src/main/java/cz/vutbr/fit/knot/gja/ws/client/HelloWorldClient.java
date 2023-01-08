/*
 * Project: Examples for GJA course
 * Authors: Ing. Jan Kouřil
 *          Ing. Jaroslav Dytrych idytrych@fit.vutbr.cz
 *          Bc.  Marek Cigánik
 * File: HelloWorldClient.java
 * Description: Example JAX-WS Service Client
 */
/**
 * @file HelloWorldClient.java
 *
 * @brief Example JAX-WS Service Client
 */
package cz.vutbr.fit.knot.gja.ws.client;

import com.sun.xml.ws.fault.ServerSOAPFaultException;
import cz.vutbr.fit.knot.gja.ws.server.HelloWorld;
import jakarta.xml.ws.Service;
import java.net.URL;
import javax.xml.namespace.QName;

/**
 * Example JAX-WS Service Client
 */
public class HelloWorldClient {

    /**
     * Main method of the client. Connects to the Publisher at port 6666
     *
     * @param args Command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        // The port 6666 is just a one of free ports, not a recommendation
        URL url = new URL("http://localhost:6666/ws/hello?wsdl");

        // 1st argument service URI, refer to wsdl document above
        // 2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://server.ws.gja.knot.fit.vutbr.cz/", "HelloWorldImplService");

        ClientService service = new ClientService(url, qname);
        HelloWorld hello = service.getPort(HelloWorld.class);

        // on invalid mac address an exception is thrown
        try {
            System.out.println(hello.getHelloWorldAsString("fit"));
        } catch (ServerSOAPFaultException e) {
            e.printStackTrace();
        }
    }
}
