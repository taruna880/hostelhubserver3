package com.usermanagement.modelresponse;

import com.usermanagement.modelentity.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private long id;
    private String userFullName;
    private String phoneNumber;
    private String email;
    private String roles;
}
