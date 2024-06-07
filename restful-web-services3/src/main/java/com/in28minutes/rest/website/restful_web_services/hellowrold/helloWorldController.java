package com.in28minutes.rest.website.restful_web_services.hellowrold;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {
	// api - hello world
	private final MessageSource messageSource;

	public helloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	//   @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "hello world";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVarable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world %s", name));
	}

	@GetMapping(path = "/hello-world-internal")
	public String helloWorldInternationalization() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "default Message", locale);
	}
}
