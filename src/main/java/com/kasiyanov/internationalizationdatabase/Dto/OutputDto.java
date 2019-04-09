package com.kasiyanov.internationalizationdatabase.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class OutputDto {

    private String itemName;
    private String[] attributeNames;
}
