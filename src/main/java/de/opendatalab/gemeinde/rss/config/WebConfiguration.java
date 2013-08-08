package de.opendatalab.gemeinde.rss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

	private static final Integer ONE_YEAR = Integer.valueOf(31556926);
	private static final Integer ONE_DAY = Integer.valueOf(60 * 60 * 24);

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/css/**").addResourceLocations("/assets/css/");
		registry.addResourceHandler("/assets/js/**").addResourceLocations("/assets/js/");
		registry.addResourceHandler("/assets/img/**").addResourceLocations("/assets/img/");
	}
}
