/*
 * Project: Examples for GJA course
 * Authors: Ing. Jan Kouřil
 *          Ing. Jaroslav Dytrych idytrych@fit.vutbr.cz
 *          Bc.  Marek Cigánik
 * File: HelloWorldImpl.java
 * Description: Example JAX-WS Service Implementation
 */
/**
 * @file HelloWorldImpl.java
 *
 * @brief Example JAX-WS Service Implementation
 */
package cz.vutbr.fit.knot.gja.ws.server;

import jakarta.jws.HandlerChain;
import jakarta.jws.WebService;

/**
 * Service Implementation
 */
@WebService(endpointInterface = "cz.vutbr.fit.knot.gja.ws.server.HelloWorld")
@HandlerChain(file = "handler-server.xml")
public class HelloWorldImpl implements HelloWorld {

    /**
     * Gets hello world string with given name
     *
     * @param name Name
     * @return Returns hello world string with given name
     */
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }
}
