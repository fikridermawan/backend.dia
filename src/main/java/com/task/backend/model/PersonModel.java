package com.task.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_fikri")
@Getter
@Setter
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int personId;
    @Column(name = "name")
    private String personName;
    @Column(name = "password")
    private String personPassword;
    @Column(name = "email")
    private String personEmail;
    @Column(name = "phone")
    private String personPhone;
    @Column(name = "address")
    private String personAddress;
    @Column(name = "resume")
    private String personResume;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "dd-MMMM-yyyy hh:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "create_at")
    private LocalDateTime personCreateAt;@JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "dd-MMMM-yyyy hh:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "update_at")
    private LocalDateTime personUpdateAt;
    @Column(name = "status",  columnDefinition = "enum('Y','N'")
    private String personStatus;
}
