package com.bufflabinc.test.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.io.PrintWriter;

@Api(value = "Index", tags = "Index")
@RestController
@RequiredArgsConstructor
public class IndexController {

    @Operation(summary = "로그인 페이지", description = "로그인 버튼이 존재하는 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @GetMapping("/")
    public void SNSLogin(HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println(
                "<html>" +
                    "<head>" +
                        "<title>안녕하세욤</title>" +
                    "</head>" +
                    "<body>" +
                        "<a href=\"http://localhost:8080/oauth2/authorization/google\">Login with Google</a>" +
                        "<br>" +
                        "<a href=\"http://localhost:8080/oauth2/authorization/kakao\">Login with Kakao</a>" +
                        "<br>" +
                        "<a href=\"http://localhost:8080/api/user/all\">get all user</a>" +
                        "<br>" +
                        "<a href=\"http://localhost:8080/swagger-ui/index.html\">Swagger</a>" +
                        "<br>" +
                        "<a href=\"http://localhost:8080/db\">db</a>" +
                    "</body>" +
                    "</html>"
        );
    }

}
