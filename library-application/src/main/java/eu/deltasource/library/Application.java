package eu.deltasource.library;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * This class is where the application gets assembled together.
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library api", version = "0.1", description = "Api for interactions with library"))
public class Application {

    @Autowired
    private LibraryDemoExecutor libraryDemoExecutor;

    @PostConstruct
    public void run() throws Exception {
        libraryDemoExecutor.exec();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public JavaTimeModule javaTimeModule() {
        return new JavaTimeModule();
    }
}