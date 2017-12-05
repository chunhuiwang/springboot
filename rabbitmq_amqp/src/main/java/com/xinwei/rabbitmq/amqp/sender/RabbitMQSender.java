/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年11月2日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.rabbitmq.amqp.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 类简要描述
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author wangchunhui
 * 
 */

@Component
public class RabbitMQSender
{
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQSender.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String routingKey, String content)
	{
		try
		{
			logger.info(routingKey + " --->>> Sender : " + content);
			this.rabbitTemplate.convertAndSend(routingKey, content);
		}
		catch (AmqpException e)
		{
			e.printStackTrace();
			logger.error("RabbitMQSender send is error.", e);
		}
	}
}
