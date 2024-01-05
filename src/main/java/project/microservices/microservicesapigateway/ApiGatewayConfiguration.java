package project.microservices.microservicesapigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gateWayRouter(RouteLocatorBuilder builder) {
		
		// --> http://httpbin.org:80/get
		
		/*  Utilized Eureka service registry to access the registered server, then put 
		the URLs for that server (example: http://localhost:8000/length-exchange/** 
									OR     http://localhost:8000/currency-exchange/from/km/to/m 
		*/
		// lb:// stand for load balancing
		return builder.routes()
				.route(p -> p.path("/get")
				.filters(f -> f
						.addRequestHeader("Header", "headerValue")
						.addRequestParameter("Parameter", "parameterValue"))
				.uri("http://httpbin.org:80"))
				.route(p -> p.path("/length-exchange/**")
						.uri("lb://length-exchange-service"))
				.route(p -> p.path("/length-conversion/**")
						.uri("lb://length-conversion-service"))
				.route(p -> p.path("/length-conversion-feign/**")
						.uri("lb://length-conversion-service"))
				.route(p -> p.path("/length-conversion-new/**")
						.filters(f -> f.rewritePath(
								"/length-conversion-new/(?<segment>.*)", 
								"/length-conversion-feign/${segment}"))
						.uri("lb://length-conversion-service"))
				.build();
		
	}

}
