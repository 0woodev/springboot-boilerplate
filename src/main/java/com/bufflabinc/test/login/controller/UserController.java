package com.bufflabinc.test.login.controller;

import com.bufflabinc.test.login.controller.dto.UserResponseDto;
import com.bufflabinc.test.login.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "User", tags = "User")
@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private final UserService userService;


    @Operation(summary = "전체 유저 조회", description = "전체 유저를 조회합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
