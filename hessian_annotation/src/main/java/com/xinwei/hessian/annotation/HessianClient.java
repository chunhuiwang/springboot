/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年8月5日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.hessian.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
@Target ({ ElementType.FIELD })
@Retention (RetentionPolicy.RUNTIME)
@Documented
public @interface HessianClient
{
	/**
	 * Hessian URL Address e.g. "boss3.url"
	 * http://IP:PORT/project/hessian/ at application.properties keyName = boss3.url
	 * 
	 * @return
	 */
	String value();
	
	/**
	 * Hessian read timeout
	 * @return
	 */
	long readTimeout() default -1;
	
	/**
	 * Hessian connect timeout
	 * @return
	 */
	long connectTimeout() default -1;
}
