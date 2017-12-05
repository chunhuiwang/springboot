/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年8月3日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.hessian.annotation;

import com.caucho.hessian.client.HessianProxyFactory;
import com.xinwei.hessian.annotation.example.HessianExampleInterface;

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

public class TestHessian
{
	public static void main(String[] args)
	{
		
		HessianProxyFactory factory = new HessianProxyFactory();
		
		try
		{
			HessianExampleInterface hessianExampleInterface = (HessianExampleInterface) factory.create(HessianExampleInterface.class,
					"http://172.18.10.11:8106/hessian_annotation/hessian/HessianExampleInterface");
			String sayHessianService = hessianExampleInterface.sayHessianService("1111");
			System.out.println(sayHessianService);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
