package com.example.wifiapc.dto;

import lombok.Data;

@Data
public class HotspotDto {
    private String name;
    private String ssid;
    private String address;
    private Double downloadSpeed;
    private Long lastConnectedAt;
    private Double lat;
    private Double lng;
}
