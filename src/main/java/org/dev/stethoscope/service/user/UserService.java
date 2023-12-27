package org.dev.stethoscope.service.user;

import org.dev.stethoscope.dto.UserGetDto;
import org.dev.stethoscope.dto.UserListGetDto;
import org.dev.stethoscope.dto.UserSaveDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public List<UserListGetDto> getList(String username) {
        return null;
    }

    public UserGetDto findByIdOrThrow(Long userId) {
        return null;
    }

    public boolean deleteById(Long userId) {
        return false;
    }

    public Long registerUser(UserSaveDto of) {
        return null;
    }

    public Long updateUser(UserSaveDto dto) {
        return null;
    }
}
