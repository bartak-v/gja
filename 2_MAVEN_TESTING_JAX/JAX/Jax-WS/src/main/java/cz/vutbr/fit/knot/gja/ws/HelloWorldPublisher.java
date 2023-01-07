/*
 * Project: Examples for GJA course
 * Authors: Ing. Jan Kouřil
 *          Ing. Jaroslav Dytrych idytrych@fit.vutbr.cz
 * File: HelloWorldPublisher.java
 * Description: Example JAX-WS Service Endpoint publisher
 */
/**
 * @file HelloWorldPublisher.java
 *
 * @brief Example JAX-WS Service Endpoint publisher
 */
package cz.vutbr.fit.knot.gja.ws;

import jakarta.xml.ws.Endpoint;

/**
 * Endpoint publisher
 */
public class HelloWorldPublisher {

    /**
     * Publisher main method, publishes a HelloWorldImpl web service at port
     * 6666
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:6666/ws/hello", new HelloWorldImpl());
        System.out.println("Server is published at port 6666!");
    }
}
