/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2016年12月27日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.jms.recv;

import org.springframework.jms.annotation.JmsListener;
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
public class RecvMsg
{
	@JmsListener (destination = "testjms")
	public void receiveMessage(String message)
	{
		System.out.println("Recv : " + message);
	}
}
