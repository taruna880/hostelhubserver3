package com.usermanagement.modelrequest;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import static com.usermanagement.constants.ValidationMessageConstants.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdate {

    @NotBlank(message = USER_FULL_NAME_REQUIRED)
    private String fullName;
    @NotBlank(message = USER_NAME_REQUIRED)
    private String phoneNumber;
    @NotBlank(message = EMAIL_REQUIRED)
    private String email;
}
