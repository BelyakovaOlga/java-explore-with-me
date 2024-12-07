package ru.practicum.ewm.сompilation.service;

import ru.practicum.ewm.сompilation.dto.CompilationDto;
import ru.practicum.ewm.сompilation.dto.NewCompilationDto;
import ru.practicum.ewm.сompilation.dto.UpdateCompilationDto;

import java.util.List;

public interface CompilationService {
    CompilationDto create(NewCompilationDto compilationDto);

    CompilationDto update(Long compId, UpdateCompilationDto update);

    void delete(Long compId);

    List<CompilationDto> get(Boolean pinned, Integer from, Integer size);

    CompilationDto findById(Long compId);
}
