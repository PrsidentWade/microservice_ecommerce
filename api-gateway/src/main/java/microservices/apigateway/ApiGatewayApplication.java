package microservices.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("r1", p -> p.path("/product/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8086"))

                .route("r2", p -> p.path("/orders/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8081"))

                .route("r3", p -> p.path("/inventory/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8082"))
                .build();
    }

}
