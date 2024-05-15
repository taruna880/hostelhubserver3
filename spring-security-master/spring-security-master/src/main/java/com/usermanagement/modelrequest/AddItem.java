package com.usermanagement.modelrequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddItem {

    private String brand;
  @NotBlank(message = "Required")
    private String title;
    private  String description;
    @NotNull(message = "Required")
    private double price;
    private List<String> imageUrls;
  private String name;
  private Date date ;
  private String location;
  private String phoneNumber;
}