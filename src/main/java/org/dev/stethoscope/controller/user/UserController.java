package org.dev.stethoscope.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dev.stethoscope.controller.BaseController;
import org.dev.stethoscope.controller.user.rqrs.UserGetRs;
import org.dev.stethoscope.controller.user.rqrs.UserListGetRs;
import org.dev.stethoscope.controller.user.rqrs.UserSaveRq;
import org.dev.stethoscope.dto.UserGetDto;
import org.dev.stethoscope.dto.UserListGetDto;
import org.dev.stethoscope.dto.UserSaveDto;
import org.dev.stethoscope.service.user.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Tag(name = "사용자")
@RequiredArgsConstructor
@RequestMapping
@RestController
public class UserController extends BaseController {
    private final UserService userService;

    @Operation(summary = "User List")
    @GetMapping("/list")
    public UserListGetRs getList(@Parameter(description = "User Name") @RequestParam(required = false) String username) {
        List<UserListGetDto> users = userService.getList(username);
        return new UserListGetRs(users);
    }

    @Operation(summary = "User Details")
    @GetMapping("/{userSn}")
    public UserGetRs getUser(@Parameter(description = "User ID") @PathVariable Long userSn) {
        UserGetDto user = userService.findByIdOrThrow(userSn);
        return new UserGetRs(user);
    }

    @Operation(summary = "User Deletion")
    @DeleteMapping("/{userSn}")
    public boolean deleteUser(@Parameter(description = "User ID") @PathVariable Long userSn) {
        return userService.deleteById(userSn);
    }

    @Operation(summary = "User Registration")
    @PostMapping
    public Long registerUser(@RequestBody UserSaveRq rq) {
        return userService.registerUser(UserSaveDto.of(rq));
    }

    @Operation(summary = "User Update")
    @PutMapping("/{userSn}")
    public Long updateUser(@Parameter(description = "User ID") @PathVariable Long userSn,
                           @RequestBody UserSaveRq rq) {
        UserSaveDto dto = UserSaveDto.of(rq);
        dto.setId(userSn);
        return userService.updateUser(dto);
    }
}
