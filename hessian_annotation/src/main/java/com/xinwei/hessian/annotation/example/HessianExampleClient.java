/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年8月5日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.hessian.annotation.example;

import org.springframework.stereotype.Service;

import com.xinwei.hessian.annotation.HessianClient;

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
@Service
public class HessianExampleClient
{
	@HessianClient (value = "hessian.example.url", connectTimeout = 1000, readTimeout = 2000)
	private HessianExampleInterface hessianExampleInterface;
	
	public void testHessianClient()
	{
		String sayHessianService = hessianExampleInterface.sayHessianService("testHessianClient");
		System.out.println("sayHessianService = " + sayHessianService);
	}
	
}
