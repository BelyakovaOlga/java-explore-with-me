package ru.practicum.ewm.comment.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.comment.service.CommentService;
import ru.practicum.ewm.comment.dto.CommentInDto;
import ru.practicum.ewm.comment.dto.CommentOutDto;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/comments")
@RequiredArgsConstructor
public class CommentPrivateController {
    private final CommentService commentService;

    @PostMapping("/users/{userId}/events/{eventId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentOutDto create(@PathVariable Long userId,
                                @PathVariable Long eventId,
                                @Valid @RequestBody CommentInDto сommentInDto) {
        log.info("==> Добавление коментария: {} к событию = {} от пользовталея = {} ", сommentInDto.toString(), eventId, userId);
        return commentService.create(userId, eventId, сommentInDto);
    }

    @PatchMapping("/users/{userId}/{commentId}")
    public CommentOutDto update(@PathVariable Long userId, @PathVariable Long commentId,
                                @Valid @RequestBody CommentInDto updateCommentDto) {

        log.info("==> Обновление пользователем с userId = {}  коментария с commentId = {} ", userId, commentId);
        return commentService.update(userId, commentId, updateCommentDto);
    }

    @GetMapping("/users/{userId}/comments")
    public List<CommentOutDto> getByUser(@PathVariable Long userId) {
        log.info("==> Получение коментариев пользователя с userId = {} ", userId);
        return commentService.getByUser(userId);
    }

    @DeleteMapping("/users/{userId}/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId, @PathVariable Long commentId) {
        log.info("==> Удаление коментария id = {} пользователем id = {} ", userId, commentId);
        commentService.delete(userId, commentId);
    }

    @GetMapping("/users/{userId}/{commentId}")
    public CommentOutDto get(@PathVariable Long userId, @PathVariable Long commentId) {
        log.info("==> Получения коментария id = {} пользователем id = {} ", commentId, userId);
        return commentService.getByUserAndCommentId(userId, commentId);
    }
}
