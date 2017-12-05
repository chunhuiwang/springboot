package com.xinwei.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.xinwei.jms.send.SendMsg;

@SpringBootApplication
@EnableJms
public class ActivemqJmsApplication implements CommandLineRunner
{
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public static void main(String[] args)
	{
		SpringApplication.run(ActivemqJmsApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception
	{
		for (String string : arg0)
		{
			System.out.println("arg0 = " + string);
		}
		jmsTemplate.send("testjms", new SendMsg());
	}
}
