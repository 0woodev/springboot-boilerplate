package com.bufflabinc.test.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "Hello", tags = "hello")
@RestController
@RequestMapping("/api")
public class HelloController {

    @Operation(summary = "핼로우 출력", description = "앙")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }
}
