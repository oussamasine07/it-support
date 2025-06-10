package com.itsupport.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {

    ADMIN,
    EMPLOYEE,
    TECHNICIAN;

    @JsonCreator
    public static Role fromString (String value) {
        try {
            return Role.valueOf(value.toUpperCase());
        }
        catch (Exception e) {
            return null;
        }
    }

    @JsonValue
    public String getValue() {
        return name();
    }

}
