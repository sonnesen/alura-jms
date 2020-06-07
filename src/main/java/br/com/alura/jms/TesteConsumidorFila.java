package br.com.alura.jms;

import java.util.Properties;
import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class TesteConsumidorFila {

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		properties.setProperty("java.naming.provider.url", "tcp://localhost:61616");
		properties.setProperty("queue.financeiro","fila.financeiro");

		InitialContext context = new InitialContext(properties);
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection("user", "senha");

		connection.start();

		Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
		Destination destination = (Destination) context.lookup("financeiro");

		MessageConsumer consumer = session.createConsumer(destination);
		consumer.setMessageListener(message -> {
			try {
				TextMessage textMessage = (TextMessage) message;
//				message.acknowledge();
				System.out.println(textMessage.getText());
				session.commit();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		});

		new Scanner(System.in).nextLine();

		session.close();
		connection.close();
		context.close();
	}

}
