package com.vut.fit.gja.jms_remote_logger;

/**
 *
 * @author xbarta47
 */
public class RemoteLogger {
    public static void main(String[] args) {
        try {
            // Look up a connection factory and queue using JNDI
            InitialContext context = new InitialContext();
            QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("java:/ConnectionFactory");
            Queue queue = (Queue) context.lookup("java:/jms/queue/test");

            // Create a connection and session
            try (JMSContext jmsContext = factory.createContext()) {
                // Create a message consumer
                JMSConsumer consumer = jmsContext.createConsumer(queue);

                // Receive and print all messages from the queue
                while (true) {
                    String message = consumer.receiveBody(String.class);
                    System.out.println(message);
                }
            }
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
