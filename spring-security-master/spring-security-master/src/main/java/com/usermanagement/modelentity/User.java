package com.usermanagement.modelentity;

import com.usermanagement.constants.ValidationMessageConstants.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import static com.usermanagement.constants.ValidationMessageConstants.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "full_name")
//    @NotBlank(message = "Full name is required")
//    @NotNull(message = "Full name cannot be null")
    private String fullName;

//    @NotBlank(message = "Phone number is required")
//    @Pattern(regexp="(^$|[0-9]{10})", message = "Phone number must be a 10-digit number")
    private String phoneNumber;

//    @NotNull(message = "Email is required")
//    @Column(name = "email")
//    @Email(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email format")
//    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotNull(message = "Password is required")
    @Column(name = "password")
    @NotBlank(message = "Password cannot be blank")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$",
            message = "Password must contain at least one lowercase letter, one uppercase letter, one digit, one special character, and be at least 8 characters long")
    public String password;

//    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private String roles ;
  //    public User() {
//
//        // Add default role upon user creation
//        roles.add(); // Assuming Role.USER is your default role
//    }
  //  private Boolean isVerified;

}
