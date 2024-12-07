package ru.practicum.ewm.location;

public class LocationMapper {
    public static Location toLocation(Location.LocationDto locationDto) {
        return Location.builder()
                .lat(locationDto.getLat())
                .lon(locationDto.getLon())
                .build();
    }


    public  static Location.LocationDto toLocationDto(Location location) {
        return Location.LocationDto.builder()
                .lat(location.getLat())
                .lon(location.getLon())
                .build();
    }
}
