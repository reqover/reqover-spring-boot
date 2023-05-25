package com.users.users;

import io.reqover.Reqover;
import io.reqover.rest.assured.SwaggerCoverage;
import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UsersApplicationTests {

    private final static String BASE_URI = "http://localhost:8080";

    @BeforeAll
    public static void configureRestAssured() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.filters(new SwaggerCoverage());
    }

    @AfterAll
    public static void after() {
        Reqover.dumpSpec(BASE_URI + "/api-docs");
    }

    @Test
    void testShouldGetListOfUsers() {
        RestAssured.get("/users").then()
                .statusCode(200);
    }

    @Test
    void testShouldGetUser() {
        RestAssured.get("/users/1").then()
                .statusCode(200)
                .body("name", Matchers.equalTo("Ivan"));
    }
}
