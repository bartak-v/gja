package com.vut.fit.gja.jersey.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Root resource (exposed at "/basic" path)
 */
@Path("links")
public class Basic {

    /**
     * Method handling HTTP GET requests.The returned object will be sent to
 the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response. try curl
     * http://localhost:8081/basic or open in browser
     * @throws java.io.FileNotFoundException
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public InputStream getIt() throws FileNotFoundException {

        File f = new File("src/main/webapp/page.html");
        return new FileInputStream(f);
    }

}
