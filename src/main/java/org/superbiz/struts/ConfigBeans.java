package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import java.util.Arrays;
import java.util.Enumeration;

@Component
public class ConfigBeans {


    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new SiteMeshFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList(new String[]{"/*"}));
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean strutsPXFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new StrutsPrepareAndExecuteFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList(new String[]{"/", "/addUserForm.action", "/addUser.action", "/findUserForm.action",
                "/findUser.action", "/listAllUsers.action"
        }));
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }


}

