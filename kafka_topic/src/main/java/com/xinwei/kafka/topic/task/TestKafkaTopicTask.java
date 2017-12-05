/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年10月30日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.kafka.topic.task;

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

import com.xinwei.kafka.topic.producer.KafkaTopicProducer;

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
public class TestKafkaTopicTask
{
	private static final Logger logger = LoggerFactory.getLogger(TestKafkaTopicTask.class);
	
	@Autowired
	private KafkaTopicProducer kafkaTopicProducer;
	
	@Scheduled (cron = "0 0/1 * * * ?")
	public void cronKafkaTopicTask()
	{
		Date currentDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		logger.info("Scheduling Tasks cronKafkaTopicTask By Cron: The time is now " + currentDate);
		try
		{
			kafkaTopicProducer.sendMessage("myTestTopic", "dateKey", dateFormat.format(currentDate));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error("cronKafkaTopicTask is error.", e);
		}
	}
}
