package org.dev.stethoscope.controller.user.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.dev.stethoscope.dto.UserGetDto;

@Getter
@Setter
@AllArgsConstructor
public class UserGetRs {
    private UserGetDto user;
}
