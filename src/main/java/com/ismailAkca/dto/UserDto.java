package com.ismailAkca.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
}
