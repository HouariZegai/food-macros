package com.houarizegai.foodmacros.config;

import com.houarizegai.foodmacros.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@RequiredArgsConstructor
@Configuration
public class GraphqlConfig {

    private final FoodService foodService;

    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return builder -> {
            builder.type("Customer", wiring -> wiring
                    .dataFetcher("macro", env -> foodService.getFoodMacro(env.getSource())));
            builder.type("Query", wiring -> wiring
                    .dataFetcher("foods", env -> foodService.getFoods())
                    .dataFetcher("foodById", env -> foodService.getFoodById(Integer.parseInt(env.getArgument("id")))));
        };
    }
}
