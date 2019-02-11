package com.o2o.config.web;


import com.google.code.kaptcha.servlet.KaptchaServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * 开启MVC 自动注入spring容器
 * 配置视图解析器——WebMvcConfigurationSupport
 * 当一个类实现ApplicationContextAware接口之后，就可以方便获得Application
 */


@Configuration
//等价于<mvc:annotation-driven />标签
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurationSupport implements ApplicationContextAware {
	//获取spring容器
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	//静态资源配置
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/upload/*")
				.addResourceLocations("file:///D:/idea_workspace/projectdev/image");
	}

	//定义默认的请求处理器
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

		configurer.enable();
	}


	//创建viewResolver，视图解析器
	@Bean(name = "viewResolver")
	public ViewResolver createViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//设置spring容器
		viewResolver.setApplicationContext(this.applicationContext);
		//取消缓存
		viewResolver.setCache(false);
		//设置解析前缀
		viewResolver.setPrefix("/WEB-INF/html/");
		//设置解析后缀
		viewResolver.setSuffix(".html");
		return  viewResolver;
	}

	//创建文件上传解析器
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("utf-8");
		//1024 * 1024 * 20
		multipartResolver.setMaxUploadSize(20971520);
		multipartResolver.setMaxInMemorySize(20971520);
		return multipartResolver;
	}


	//注册servlet，配置验证码
	@Value("${kaptcha.border}")
	private String border;
	@Value("${kaptcha.textproducer.font.color}")
	private String fcolor;
	@Value("${kaptcha.textproducer.font.size}")
	private String fsize;
	@Value("${kaptcha.textproducer.font.names}")
	private String fnames;
	@Value("${kaptcha.noise.color}")
	private String ncolor;
	@Value("${kaptcha.image.width}")
	private String width;
	@Value("${kaptcha.image.height}")
	private String height;
	@Value("${kaptcha.textproducer.char.string}")
	private String cstring;
	@Value("${kaptcha.textproducer.char.length}")
	private String clength;

	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		ServletRegistrationBean servlet = new ServletRegistrationBean(
				new KaptchaServlet(), "/Kaptcha");
		servlet.addInitParameter("kaptcha.border", border);
		servlet.addInitParameter("kaptcha.textproducer.font.color", fcolor);
		servlet.addInitParameter("kaptcha.textproducer.font.size", fsize);
		servlet.addInitParameter("kaptcha.textproducer.font.names", fnames);
		servlet.addInitParameter("kaptcha.noise.color", ncolor);
		servlet.addInitParameter("kaptcha.image.width", width);
		servlet.addInitParameter("kaptcha.image.height",height);
		servlet.addInitParameter("kaptcha.textproducer.char.string", cstring);
		servlet.addInitParameter("kaptcha.textproducer.char.length", clength);
		return servlet;
	}

//	//添加拦截器配置
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		String interceptPath = "/shopadmin/**";
//		//注册
//
//	}
}