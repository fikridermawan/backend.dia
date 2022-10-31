package com.task.backend;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonLoginRequest {
    String personEmail;
    String personPassword;
}
