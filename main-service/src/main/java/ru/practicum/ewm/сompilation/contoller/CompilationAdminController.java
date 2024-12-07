package ru.practicum.ewm.сompilation.contoller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.сompilation.dto.CompilationDto;
import ru.practicum.ewm.сompilation.dto.NewCompilationDto;
import ru.practicum.ewm.сompilation.dto.UpdateCompilationDto;
import ru.practicum.ewm.сompilation.service.CompilationService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/admin/compilations")
public class CompilationAdminController {
    private final CompilationService compilationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompilationDto create(@RequestBody @Valid NewCompilationDto compilationDto) {
        log.info("==> Запрос на создание подборки событий");
        return compilationService.create(compilationDto);
    }

    @PatchMapping("/{compId}")
    public CompilationDto update(@RequestBody @Valid UpdateCompilationDto update,
                                            @PathVariable Long compId) {
        log.info("==> Запрос на обнавление подборки событий");
        return compilationService.update(compId, update);
    }

    @DeleteMapping("/{compId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long compId) {
        log.info("==> Запрос на удаление подборки событий");
        compilationService.delete(compId);
    }
}
