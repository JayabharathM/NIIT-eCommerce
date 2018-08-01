package com.shopping.FashionWorldBackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration
{
	 @Bean("myBean")
	 public MyBean getMyBean()
     {
    	 return new MyBean();
     }

}
