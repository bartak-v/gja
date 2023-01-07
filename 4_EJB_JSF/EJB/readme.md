# EJB Examples

## EJB StatefullBean and StatelessBean
- Two projects showing the difference between statefull and stateless beans. 
- The statefull bean project shows a bank account bean, which balance is preserved thanks to the bean being statefull across client requests.
- The stateless bean project is very simillar in structure. This time a @Stateless annotation is used on the bean because there is no point in holding a state of a calculator (at least not in this example, where are no intermediate results)
- applications runs at http://localhost:8080/StatefullBean and http://localhost:8080/StatelessBean