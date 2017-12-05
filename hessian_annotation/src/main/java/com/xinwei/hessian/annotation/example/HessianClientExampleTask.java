/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年6月5日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.hessian.annotation.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
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
@Configurable
@EnableScheduling
public class HessianClientExampleTask
{
	// @Resource
	@Autowired
	private HessianExampleClient hessianExampleClient;
	
	@Scheduled (cron = "0 0/1 * * * ?")
	public void exampleTask()
	{
		System.out.println("hessianExampleClient = " + hessianExampleClient);
		hessianExampleClient.testHessianClient();
	}
}
