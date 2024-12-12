package ru.practicum.ewm.request.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.request.RequestStatus;

import java.time.LocalDateTime;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParticipationRequestDto {
    Long id;

    Long requester;

    Long event;

    RequestStatus status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime created;
}
