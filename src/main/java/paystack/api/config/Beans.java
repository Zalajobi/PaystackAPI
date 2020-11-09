package paystack.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import paystack.api.core.ApiQuery;

@Configuration
public class Beans {

    @Bean(name = "apiQuery")
    public ApiQuery apiQuery() {
        return new ApiQuery();
    }
}
