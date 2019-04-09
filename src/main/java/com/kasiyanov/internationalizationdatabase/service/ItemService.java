package com.kasiyanov.internationalizationdatabase.service;

import com.kasiyanov.internationalizationdatabase.Dto.InputDto;
import com.kasiyanov.internationalizationdatabase.Dto.Language;
import com.kasiyanov.internationalizationdatabase.Dto.OutputDto;
import com.kasiyanov.internationalizationdatabase.entity.AttributeRu;
import com.kasiyanov.internationalizationdatabase.entity.ItemEn;
import com.kasiyanov.internationalizationdatabase.entity.ItemRu;
import com.kasiyanov.internationalizationdatabase.repository.ItemRuRepository;
import com.kasiyanov.internationalizationdatabase.repository.ItemEnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemService {

    private final ItemRuRepository itemRuRepository;
    private final ItemEnRepository itemEnRepository;
    private final OutputDto outputDto;

    public OutputDto getByLanguageAndCode(InputDto inputDto) {
        if (inputDto.getLanguage() == Language.EN) {
            Optional<ItemEn> item = itemEnRepository.findByCode(inputDto.getCode());
            item.ifPresent(itemEn -> {
                outputDto.setItemName(itemEn.getName());
                List<String> attributeName = new ArrayList<>();
                itemEn.getAttributes().forEach(it -> attributeName.add(it.getName()));
                outputDto.setAttributeNames(attributeName.toArray(new String[0]));
            });
        } else {
            Optional<ItemRu> item = itemRuRepository.findByCode(inputDto.getCode());
            item.ifPresent(itemRu -> {
                outputDto.setItemName(itemRu.getName());
                String[] attributeName = new String[itemRu.getAttributes().size()];
                List<AttributeRu> itemRus = new ArrayList<>(itemRu.getAttributes());
                for (int i = 0; i < attributeName.length; i++) {
                    attributeName[i] = itemRus.get(i).getName();
                }
                outputDto.setAttributeNames(attributeName);
            });
        }
        return outputDto;
    }
}
