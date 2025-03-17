package dzamsheed.uz.gateway.config;

import dzamsheed.uz.gateway.auth.AuthFilter;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder, AuthFilter authFilter) {
        return builder.routes()
                .route("client-service", r -> r.path("/clients/**")
                        .filters(f -> f.filter(authFilter))
                        .uri("lb://CLIENT-SERVICE"))
                .route("auth-service", r -> r.path("/auth/**")
                        .uri("lb://AUTH-SERVICE"))
                .route("amqp-publisher", r -> r.path("/publisher/**")
                        .uri("lb://AMQP-PUBLISHER"))
                .route("keycloak-service", r -> r.path("/keycloak/**")
                        .uri("lb://KEYCLOAK-SERVICE"))
                .build();
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }
}
