package dzamsheed.uz.payment_service.config;

import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
//    @Bean
//    public XStreamSerializer xStreamSerializer() {
//        XStreamSerializer serializer = XStreamSerializer.builder().build();
//        serializer.getXStream().addPermission(AnyTypePermission.ANY);
//        return serializer;
//    }

//    @Bean
//    @Primary
//    public Serializer axonSerializer() {
//        return JacksonSerializer.defaultSerializer();
//    }
}
