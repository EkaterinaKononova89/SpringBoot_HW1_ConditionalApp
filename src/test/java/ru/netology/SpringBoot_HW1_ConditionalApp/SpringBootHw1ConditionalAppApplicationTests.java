package ru.netology.SpringBoot_HW1_ConditionalApp;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers //3й вариант, добавляем аннотации @Testcontainers и @Container, поля GenericContainer<?> static, метод @BeforeAll/@BeforeEach не нужен
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootHw1ConditionalAppApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    @Container //3й вариант
    private static final GenericContainer<?> myAppDev = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    @Container // 3й вариант
    private static final GenericContainer<?> myAppProd = new GenericContainer<>("prodapp")
            .withExposedPorts(8081); // 8080?

//    @BeforeAll // 2й вариант, без аннотаций @Testcontainers и @Container, поля GenericContainer<?> static
//    public static void setUp() {
//        myAppDev.start();
//        myAppProd.start();
//    }

//    @BeforeEach // 1й вариант, без аннотаций @Testcontainers и @Container, поля GenericContainer<?> НЕ static
//    public void setUp() {
//        myAppDev.start();
//        myAppProd.start();
//    }

    @Test
    void contextLoadsDev() {
        ResponseEntity<String> forEntityDev = restTemplate.getForEntity("http://localhost:" + myAppDev.getMappedPort(8080) + "/profile", String.class);
        Assertions.assertEquals("Current profile is dev", forEntityDev.getBody());
    }

    @Test
    void contextLoadsProd() {
        ResponseEntity<String> forEntityProd = restTemplate.getForEntity("http://localhost:" + myAppProd.getMappedPort(8081) + "/profile", String.class);
        Assertions.assertEquals("Current profile is production", forEntityProd.getBody());
    }
}
