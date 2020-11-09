package paystack.api.constants;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Authorization implements CommandLineRunner {
    private static String key = null;

    public static String getKey() {
        return key;
    }

    @Override
    public void run(String... args) throws Exception {
        key = System.getenv("BEARER");
    }
}
