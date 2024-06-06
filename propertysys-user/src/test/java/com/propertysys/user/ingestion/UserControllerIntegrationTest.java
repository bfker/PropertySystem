package com.propertysys.user.ingestion;

import com.propertysys.user.model.User;
import com.propertysys.user.utils.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownContentTypeException;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        // Add a StringHttpMessageConverter to handle text/html responses
        RestTemplate plainRestTemplate = restTemplate.getRestTemplate();
        plainRestTemplate.getMessageConverters().add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
    }

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/user/user/register", request, String.class);

        assertEquals(200, response.getStatusCodeValue());
        // Assuming the response is a JSON string
        String responseBody = response.getBody();
        assertTrue(responseBody.contains("\"code\":200"));
        assertTrue(responseBody.contains("\"success\":true"));
    }

    @Test
    public void testLoginUser() {
        User user = new User();
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/user/user/login", HttpMethod.POST, request, String.class);

        assertEquals(200, response.getStatusCodeValue());
        // Assuming the response is a JSON string
        String responseBody = response.getBody();
        assertTrue(responseBody.contains("\"code\":200"));
        assertTrue(responseBody.contains("\"success\":true"));
    }
}
