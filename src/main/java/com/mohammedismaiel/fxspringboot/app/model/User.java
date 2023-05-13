package com.mohammedismaiel.fxspringboot.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String username;

    private String password;
}
