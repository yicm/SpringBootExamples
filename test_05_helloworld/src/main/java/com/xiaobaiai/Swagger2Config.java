package com.xiaobaiai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean("UsersApis_V1")
    public Docket usersApisV1() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("用户管理接口V1")
        		// select()返回的是ApiSelectorBuilder对象，而非Docket对象
                .select()
                
                .apis(RequestHandlerSelectors.basePackage("com.xiaobaiai.user"))
                .paths(Predicates.or(
                        PathSelectors.ant("/api/v1/users/**"),
                        PathSelectors.ant("/api/v1/users/*")))      
                // build()返回的是Docket对象
                .build()
                // 测试API时的主机URL
                .host("https://xiaobaiai.net")    
                // API前缀
                .pathProvider(new RelativePathProvider(null) {
                    @Override
                    public String getApplicationBasePath() {
                        return "/prefix";
                    }
                })
                .apiInfo(apiInfo());
    }
    
    @SuppressWarnings("unchecked")
	@Bean("UsersApis_V21")
    public Docket usersApisV2() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("用户管理接口V2")
        		// select()返回的是ApiSelectorBuilder对象，而非Docket对象
                .select()
                
                .apis(RequestHandlerSelectors.basePackage("com.xiaobaiai.user"))
                .paths(Predicates.or(
                        PathSelectors.ant("/api/v2/users/**"),
                        PathSelectors.ant("/api/v2/users/*"),
                        PathSelectors.regex("/api/v2/users.*")))      
                // build()返回的是Docket对象
                .build()
                // 测试API时的主机URL
                .host("https://xiaobaiai.net")    
                // API前缀
                .pathProvider(new RelativePathProvider(null) {
                    @Override
                    public String getApplicationBasePath() {
                        return "/prefix";
                    }
                })
                .apiInfo(apiInfo());
    }
    
    @Bean
    public Docket productsApis() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("产品管理接口")
        		// select()返回的是ApiSelectorBuilder对象，而非Docket对象
                .select()
                
                .apis(RequestHandlerSelectors.basePackage("com.xiaobaiai.product"))
                .paths(Predicates.or(
                        PathSelectors.ant("/api/v1/products/**"),
                        PathSelectors.ant("/api/v1/products/*")))              
                // build()返回的是Docket对象
                .build()
                // 测试API时的主机URL
                .host("localhost:8080")    
                // API前缀
                .pathProvider(new RelativePathProvider(null) {
                    @Override
                    public String getApplicationBasePath() {
                        return "";
                    }
                })
                .apiInfo(apiInfo())
                .tags(new Tag("产品操作分组1", "产品查询相关操作."),
                        new Tag("产品操作分组2", "产品添加或删除相关操作."),
                        new Tag("产品操作分组3", "产品更新相关操作."),
                        new Tag("产品操作分组4", "产品相关全部操作."));
    }
    
    public ApiInfo apiInfo() {
    	// API负责人的联系信息
    	final Contact contact = new Contact(
    			"Ethan", "https://xiaobaiai.net", "ycm_hy@163.com");
        return new ApiInfoBuilder()
        	// API文档标题
            .title("X系统平台接口文档")
            // API文档描述
            .description("用户/产品相关API, 更多请关注公众号: 小白AI 或微信小程序：小白AI博客")
            // 服务条款URL
            .termsOfServiceUrl("https://github.com/yicm")
            // API文档版本
            .version("1.0")
            // API负责人的联系信息
            .contact(contact)
            // API的许可证Url
            .licenseUrl("http://license.coscl.org.cn/MulanPSL")
            .license("MulanPSL")
            .build();
    }
}
