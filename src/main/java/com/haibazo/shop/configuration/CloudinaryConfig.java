package com.haibazo.shop.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary getCloudinary(){
        Map config = new HashMap();
        config.put("cloud_name", "dpigvaz8s");
        config.put("api_key", "119311214788832");
        config.put("api_secret", "DEXThfyc66CcqVsniyx1SDn8fho");
        config.put("secure", true);
        return new Cloudinary(config);
    }

}
