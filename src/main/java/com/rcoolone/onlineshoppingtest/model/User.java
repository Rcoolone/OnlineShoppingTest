package com.rcoolone.onlineshoppingtest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.lang.module.ResolvedModule;

@AllArgsConstructor
@Builder
@Data
public class User {
    public String name;

    public String email;
}
