package com.kasiyanov.internationalizationdatabase.controller;

import com.kasiyanov.internationalizationdatabase.Dto.InputDto;
import com.kasiyanov.internationalizationdatabase.Dto.OutputDto;
import com.kasiyanov.internationalizationdatabase.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemController {

    private final ItemService itemService;

    @PostMapping(value = "/item", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public OutputDto findProductByName(@RequestBody InputDto inputDto) {
        return itemService.getByLanguageAndCode(inputDto);
    }
}
