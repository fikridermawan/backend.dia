package com.task.backend;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequest {
    private String personName;
    private String personPassword;
    private String personEmail;
    private String personPhone;
    private String personAddress;
    private String personCreateAt;
    private String personUpdateAt;
    private String status;
}
