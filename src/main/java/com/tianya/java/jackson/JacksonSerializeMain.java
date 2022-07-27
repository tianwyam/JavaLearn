package com.tianya.java.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tianya.java.jackson.entity.AppInfoBean;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class JacksonSerializeMain {



    @Test
    public void testDeserialize() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(new Date().getTime());

        String jsonStr = "{\"id\":120,\"appName\":null,\"appAuthor\":null,\"appBirth\":null}" ;

        AppInfoBean app1 = objectMapper.readValue(jsonStr, AppInfoBean.class);

        System.out.println(app1);
        System.out.println(objectMapper.writeValueAsString(app1));

    }











}
