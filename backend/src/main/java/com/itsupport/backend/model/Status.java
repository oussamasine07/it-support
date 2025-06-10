package com.itsupport.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

    PENDING,
    WORKING,
    RESOLVED;

    @JsonCreator
    public static Status fromString (String value) {
        try {
            return Status.valueOf(value.toUpperCase());
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
