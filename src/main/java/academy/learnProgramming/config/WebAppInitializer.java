package academy.learnProgramming.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        log.info("onStartUp");

        // == Create the spring application context  ==
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();

        context.register(WebConfig.class);

        // == Create Dispatcher Servlet ==

        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(context);

        // == register and configure the dispatcher servlet in the servlet ==
        // Note that there are many servlets, hence the need to put the name
        //of the servlet you are registering

        ServletRegistration.Dynamic registration =
                servletContext.addServlet(DISPATCHER_SERVLET_NAME,dispatcherServlet);

        registration.setLoadOnStartup(1);
        registration.addMapping("/");

    }
}
