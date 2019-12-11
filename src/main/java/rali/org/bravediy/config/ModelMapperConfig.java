package rali.org.bravediy.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    private static ModelMapper mapper;

    @Bean
    public ModelMapper modelMapper() {
        return mapper;
    }
}
