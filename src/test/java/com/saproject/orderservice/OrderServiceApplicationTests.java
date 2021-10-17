package com.saproject.orderservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
   public void checkOrderBindingFromUser() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order").
                accept(MediaType.APPLICATION_JSON).
                content("{\n" +
                        "  \"user\": {\n" +
                        "    \"id\": 1,\n" +
                        "    \"userName\": \"lemama\",\n" +
                        "    \"email\": \"bula@gmail.com\"\n" +
                        "  },\n" +
                        "  \"order\": [\n" +
                        "    {\n" +
                        "      \"name\": \"pizza\",\n" +
                        "      \"price\": \"17\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"name\": \"chickenNugget\",\n" +
                        "      \"price\": \"18\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"restaurantName\": \"pizzaranch\",\n" +
                        "  \"payment\": {\n" +
                        "    \"cardNumber\": \"600 8909 8897 4434\",\n" +
                        "    \"expireDate\": \"07/26\",\n" +
                        "    \"ccv\": \"679\"\n" +
                        "  }\n" +
                        "}").
                contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).
                andExpect(status().
                        isOk());
    }

}
