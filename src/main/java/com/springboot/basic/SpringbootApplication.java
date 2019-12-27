package com.springboot.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {


    @Autowired
    private YAMLConfig yamlConfig;


    /**
     * Setter inject data from Prop/YML as STATIC variable
     */
    @Value("${my.prop}")
    public void setBenjiSta(String prop) {
        SpringbootApplication.staticProp = prop;
    }

    @Value("${my.yml}")
    public void setBenjiStaYml(String yml) {
        SpringbootApplication.staticYml = yml;
    }

    private static String staticProp;

    private static String staticYml;

    /**
     * Variable inject data from Prop/YML as None STATIC variable
     */
    @Value("${servers[0]}")
    public String serverFirst;

    public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		// Data find from environment, if not find, then go to EMPTY env files to find.
        System.out.println("Prop - Value tag injection as static value: " + staticProp);
        System.out.println("Yml - Value tag injection as static value: " + staticYml);
	}

    public void run(String... args) throws Exception {
        /**
         * Read from YAML config
         */
        System.out.println("using environment: " + yamlConfig.getEnvironment());
        System.out.println("name: " + yamlConfig.getName());
        System.out.println("servers: " + yamlConfig.getServers());

        /**
         * Read from @Value
         */
        System.out.println("servers[0]: " + serverFirst.toString());
    }

}
