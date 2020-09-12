package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
		ApplicationContext applicationContext = context;

		ItemRepository itemRepository = (ItemRepository) applicationContext.getBean("itemRepository");
		System.out.println(itemRepository);

		Color color = (Color) applicationContext.getBean("getColor");
		System.out.println(color);
	}

}
