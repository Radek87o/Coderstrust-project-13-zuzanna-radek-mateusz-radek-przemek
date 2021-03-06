package pl.coderstrust.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mongodb.properties")
@ConditionalOnProperty(name = "pl.coderstrust.database", havingValue = "mongo")
@Import({MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class MongoConfiguration {
}
