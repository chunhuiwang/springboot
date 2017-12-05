/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2016年12月27日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.jms.send;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

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

public class SendMsg implements MessageCreator
{
	
	@Override
	public Message createMessage(Session session) throws JMSException
	{
		System.out.println("Send message");
		return session.createTextMessage("Hello JMS");
	}
	
}
