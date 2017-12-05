/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年8月4日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.hessian.annotation.scan;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.stereotype.Component;

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
@Component
public class HessianServiceScanner implements BeanFactoryPostProcessor
{
	
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
	{
		// 获取所有使用HessianService注解的Bean名子
		String[] beanNames = beanFactory.getBeanNamesForAnnotation(HessianService.class);
		for (String beanName : beanNames)
		{
			String className = beanFactory.getBeanDefinition(beanName).getBeanClassName();
			String hessianServiceBeanName = null;
			String hessianServiceClassName = null;
			String hessianServiceProjectName = "";
			Class<?> clazz = null;
			try
			{
				// 获取配置中的Bean名及类型名
				clazz = Class.forName(className);
				HessianService hessianService = (HessianService) clazz.getAnnotation(HessianService.class);
				String project = hessianService.project();
				String name = hessianService.name();
				Class<?> type = hessianService.type();
				if (!project.equals(""))
				{
					hessianServiceProjectName = "/" + project;
				}
				if (!name.equals(""))
				{
					hessianServiceBeanName = name;
				}
				if (!type.getName().equals(Void.class.getName()))
				{
					hessianServiceClassName = type.getName();
				}
			}
			catch (ClassNotFoundException e)
			{
				throw new BeanInitializationException(e.getMessage(), e);
			}
			
			// 如果用户没有配置使用默认
			if (hessianServiceBeanName == null)
			{
				hessianServiceBeanName = beanName.replace("Impl", "");
				hessianServiceBeanName = hessianServiceProjectName + "/hessian/" + hessianServiceBeanName.substring(0, 1).toUpperCase() + hessianServiceBeanName.substring(1);
			}
			if (hessianServiceClassName == null)
			{
				// 获取第一个接口的类型的ClassName
				hessianServiceClassName = clazz.getInterfaces()[0].getName();
			}
			
			// 注册Bean到Spring
			BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(HessianServiceExporter.class);
			builder.addPropertyReference("service", beanName);
			builder.addPropertyValue("serviceInterface", hessianServiceClassName);
			((BeanDefinitionRegistry) beanFactory).registerBeanDefinition(hessianServiceBeanName, builder.getBeanDefinition());
		}
	}
	
}
