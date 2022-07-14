package com.elastic.demo.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Commerce {
    @JsonProperty("category")
    public List<String> category;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("email")
    public String email;

    @JsonProperty("manufacturer")
    public List<String> manufacturer;
}
