package ru.practicum.ewm.category;

import ru.practicum.ewm.category.dto.CategoryInDto;
import ru.practicum.ewm.category.dto.CategoryOutDto;

public class CategoryMapper {
    public static CategoryOutDto toCategoryOutDto(Category category) {
        return CategoryOutDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toCategory(CategoryInDto categoryInDto) {
        Category category = new Category(null,
                                         categoryInDto.getName());
        return category;
    }
}