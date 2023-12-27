package org.dev.stethoscope.dto;

import lombok.Getter;
import lombok.Setter;
import org.dev.stethoscope.controller.user.rqrs.UserSaveRq;

@Getter
@Setter
public class UserSaveDto {
    private Long id;

    public static UserSaveDto of(UserSaveRq rq) {
        return null;
    }
}
