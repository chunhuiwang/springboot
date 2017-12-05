/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年8月4日	| wanchunhui 	| 	create the file                       
 */

package com.xinwei.hessian.annotation.scan;

import java.lang.reflect.Field;
import java.net.MalformedURLException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.caucho.hessian.client.HessianProxyFactory;
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
@Component
public class HessianClientScanner implements ApplicationContextAware
{
	@Autowired
	private Environment environment;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames)
		{
			// 过滤出com.xinwei的包
			String className = beanFactory.getBeanDefinition(beanName).getBeanClassName();
			if (className != null && className.startsWith("com.xinwei"))
			{
				try
				{
					Class<?> clazz = Class.forName(className);
					Field[] declaredFields = clazz.getDeclaredFields();
					for (Field field : declaredFields)
					{
						// 获取HessianClient注解
						HessianClient annotation = field.getAnnotation(HessianClient.class);
						if (annotation != null)
						{
							String interfaceName = field.getType().getSimpleName();
							String value = annotation.value();
							String connectUrl = environment.getProperty(value);
							if (connectUrl != null && !connectUrl.equals(""))
							{
								// Hessian的URL处理
								char charAt = connectUrl.charAt(connectUrl.length() - 1);
								if (charAt == '/')
								{
									connectUrl = connectUrl + interfaceName;
								}
								else
								{
									connectUrl = connectUrl + "/" + interfaceName;
								}
								
								// 创建Hessian实例对象
								HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();
								hessianProxyFactory.setReadTimeout(annotation.readTimeout());
								hessianProxyFactory.setConnectTimeout(annotation.connectTimeout());
								
								// 设置到Spring中的实例属性中去
								Object object = hessianProxyFactory.create(field.getType(), connectUrl);
								field.setAccessible(true);
								field.set(beanFactory.getBean(beanName), object);
								field.setAccessible(false);
								
								Object bean = beanFactory.getBean(beanName);
								System.out.println("bean = " + bean);
							}
							
						}
					}
				}
				catch (ClassNotFoundException | MalformedURLException | IllegalArgumentException | IllegalAccessException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
