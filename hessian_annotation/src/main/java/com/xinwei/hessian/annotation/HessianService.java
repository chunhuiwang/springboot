/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年8月3日	| wanchunhui 	| 	create the file                       
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
@Target ({ ElementType.TYPE })
@Retention (RetentionPolicy.RUNTIME)
@Documented
public @interface HessianService
{
	/**
	 * project name at use jar deploy
	 * 
	 * @return
	 */
	String project() default "";
	
	/**
	 * Hessian deploy address e.g. /project/hessian/interface
	 * 
	 * @return
	 */
	String name() default "";
	
	/**
	 * Hessian deploy interface class
	 * 
	 * @return
	 */
	Class<?> type() default Void.class;
}
