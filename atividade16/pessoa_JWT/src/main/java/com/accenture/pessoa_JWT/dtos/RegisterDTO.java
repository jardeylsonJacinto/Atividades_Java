package com.accenture.pessoa_JWT.dtos;

import com.accenture.pessoa_JWT.enums.UserRoles;

public record RegisterDTO(String login, String password, UserRoles role) {

}
