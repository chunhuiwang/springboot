/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年11月2日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.rabbitmq.amqp.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
@RabbitListener (queues = "helloAmqp")
public class RabbitMQReceiver
{
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQReceiver.class);
	
	@RabbitHandler
	public void process(String content)
	{
		logger.info("helloAmqp ---<<< Receiver : " + content);
	}
}
