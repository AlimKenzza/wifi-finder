package com.example.wifiapc.dto;

import lombok.Data;

import java.util.List;

@Data
public class CityDto {
    private Long id;
    private String name;
    private Double centerLat;
    private Double centerLng;
    private Integer hotspotsCount;
    private CountryDto country;
    private List<HotspotDto> hotspots;
}
