/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年10月31日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.kafka.topic.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
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
public class KafkaTopicConsumer
{
	private static final Logger logger = LoggerFactory.getLogger(KafkaTopicConsumer.class);
	
	@KafkaListener (topics = "myTestTopic")
	public void listen(ConsumerRecord<?, ?> cr) throws Exception
	{
		Object key = cr.key();
		Object value = cr.value();
		logger.info("myTopic key = " + key + ", value = " + value);
	}
}
