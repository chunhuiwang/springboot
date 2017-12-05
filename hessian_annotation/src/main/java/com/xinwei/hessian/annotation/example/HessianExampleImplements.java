/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年8月3日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.hessian.annotation.example;

import org.springframework.stereotype.Service;

import com.xinwei.hessian.annotation.HessianService;

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
// @HessianService (name = "/hessian_annotation/hessian/HessianExampleInterface", type = HessianExampleInterface.class)
@HessianService (project = "hessian_annotation")
@Service ("hessianExampleInterface")
public class HessianExampleImplements implements HessianExampleInterface
{
	
	@Override
	public String sayHessianService(String hessianName)
	{
		return "Hello " + hessianName;
	}
	
}
