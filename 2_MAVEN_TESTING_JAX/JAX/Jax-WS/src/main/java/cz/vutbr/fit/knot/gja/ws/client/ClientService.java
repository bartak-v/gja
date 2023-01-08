/*
 * Project: Examples for GJA course
 * Authors: Ing. Jan Kouřil
 *          Ing. Jaroslav Dytrych idytrych@fit.vutbr.cz
 * File: ServerService.java
 * Description: Example of Web Service handlers
 */

/**
 * @file ServerService.java
 *
 * @brief Example of Web Service handlers
 */

package cz.vutbr.fit.knot.gja.ws.client;

import jakarta.jws.HandlerChain;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebServiceClient;
import javax.xml.namespace.QName;
import java.net.URL;

/**
 * Server service
 */
@WebServiceClient(name = "ClientService",
                  targetNamespace = "http://server.ws.gja.knot.fit.vutbr.cz/",
                  wsdlLocation = "http://localhost:6666/ws/hello?wsdl")
@HandlerChain(file = "handler-client.xml")
public class ClientService extends Service {

  public ClientService(URL wsdlLocation, QName serviceName) {
    super(wsdlLocation, serviceName);
  }

}
