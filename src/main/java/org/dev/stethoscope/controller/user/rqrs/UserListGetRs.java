package org.dev.stethoscope.controller.user.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.dev.stethoscope.dto.UserListGetDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserListGetRs {
    private List<UserListGetDto> users;
}
