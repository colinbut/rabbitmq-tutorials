/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;

public class Send {



    public static void main(String[] args) throws IOException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(Broker.QUEUE_NAME, false, false, false, null);
        String message = "Hello Message";
        channel.basicPublish("", Broker.QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] sent " + message);
        channel.close();
        connection.close();
    }
}
