package com.springbasic.api.dto;

import lombok.Data;

@Data
public class PersonDTO {
    
    private Long id;
    private String firstName;
    private String LastName;
    private String gender;
    private String address;
}
