package com.example.wifiapc.dto;

import lombok.Data;

@Data
public class GraphQlRequestBody {
    private String query;
    private Object variables;
}
