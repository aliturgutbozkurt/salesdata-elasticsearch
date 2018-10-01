package com.turkninja;

import com.turkninja.util.BootstrapManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/configuration.properties")
public class ElasticsearchProjectApplication implements CommandLineRunner {

    private final BootstrapManager bootstrapManager;

    public ElasticsearchProjectApplication(BootstrapManager bootstrapManager) {
        this.bootstrapManager=bootstrapManager;
    }

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bootstrapManager.loadCsvSalesData();
    }
}
