/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年10月31日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.kafka.topic.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

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
public class KafkaTopicProducer
{
	private static final Logger logger = LoggerFactory.getLogger(KafkaTopicProducer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String topic, String data)
	{
		ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(topic, data);
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>()
		{
			
			@Override
			public void onFailure(Throwable ex)
			{
				logger.error("onFailure", ex);
			}
			
			@Override
			public void onSuccess(SendResult<String, String> result)
			{
				ProducerRecord<String, String> producerRecord = result.getProducerRecord();
				logger.info("onSuccess --->>> key = " + producerRecord.key() + ", value = " + producerRecord.value());
			}
			
		});
	}
	
	public void sendMessage(String topic, String key, String data)
	{
		ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(topic, key, data);
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>()
		{
			
			@Override
			public void onFailure(Throwable ex)
			{
				logger.error("onFailure", ex);
			}
			
			@Override
			public void onSuccess(SendResult<String, String> result)
			{
				ProducerRecord<String, String> producerRecord = result.getProducerRecord();
				logger.info("onSuccess --->>> key = " + producerRecord.key() + ", value = " + producerRecord.value());
			}
			
		});
	}
}
