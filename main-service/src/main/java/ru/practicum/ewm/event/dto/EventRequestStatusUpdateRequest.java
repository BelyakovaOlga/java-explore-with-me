package ru.practicum.ewm.event.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.practicum.ewm.request.RequestStatus;

import java.util.Set;

@Data
@Builder
public class EventRequestStatusUpdateRequest {
    @NotNull
    private Set<Long> requestIds;
    @NotNull
    private RequestStatus status;
}
