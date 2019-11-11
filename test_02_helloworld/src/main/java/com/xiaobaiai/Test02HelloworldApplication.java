package com.xiaobaiai;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
@Controller
public class Test02HelloworldApplication {
	private static final Logger LOGGER=LogManager.getLogger(Test02HelloworldApplication.class);
	
	@RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }
	public static void main(String[] args) {
		SpringApplication.run(Test02HelloworldApplication.class, args);
		LOGGER.debug("简单的日志记录测试 :  {}  + {}  =  {}", 1, 2, 3);
	}

}
