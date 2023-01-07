# JAX Examples

## JAX -WS

- Client and publisher, first run publisher. Client then connects to the publisher at port 6666 (if the port is not free on your machine, change it) and retrieves object HelloWorld. The call *hello.getHelloWorldAsString("fit")* seems to be executed on client side but it is actually executed in the publisher app and the result is retrieved through the port.

## Jersey

- A Jersey demo showing basic usage of the framework. The application runs at http://localhost:8080/jersey.
- There are 2 controller Classes, first *Basic* shows basic HTTP GET processing. Second *Arguments* shows retrieving user input multiple ways.