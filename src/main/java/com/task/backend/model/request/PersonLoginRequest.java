package com.task.backend.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonLoginRequest {
    String personEmail;
    String personPassword;
}
