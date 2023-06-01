package com.mithilesh.tms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotEmpty
    @Size(min = 3,message = "First Name must be minimum length of 3")
    private String firstName;

    @NotEmpty
    @Size(min = 3,message = "Last Name must be minimum length of 3")
    private String lastName;

    @NotEmpty
    @Email(message = "Email address is not valid")
    private String email;

    @NotEmpty
    @Size(min = 8,message = "Password length should be min 8 in length")
    private String password;

    @NotEmpty
    @Size(min = 3,message = "Role length should be min 3 in length")
    private String roles;
}
