/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年10月30日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.rabbitmq.amqp.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xinwei.rabbitmq.amqp.sender.RabbitMQSender;

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
@Configurable
@EnableScheduling
public class TestRabbitmqAmqpTask
{
	private static final Logger logger = LoggerFactory.getLogger(TestRabbitmqAmqpTask.class);
	
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	@Scheduled (cron = "0 0/1 * * * ?")
	public void cronRabbitmqAmqpTask()
	{
		Date currentDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		logger.info("Scheduling Tasks cronRabbitmqAmqpTask By Cron: The time is now " + currentDate);
		try
		{
			rabbitMQSender.sendMessage("helloAmqp", dateFormat.format(currentDate));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error("cronRabbitmqAmqpTask is error.", e);
		}
	}
}
