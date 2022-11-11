package com.example.wifiapc.controller;

import com.example.wifiapc.dto.CityDto;
import com.example.wifiapc.dto.CountryDto;
import com.example.wifiapc.service.WifiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WifiMapController {
    private final WifiService wifiService;

    @GetMapping
    public ResponseEntity<CityDto> getWifiByCityId(@RequestParam Long cityId) throws IOException {
        return ResponseEntity.ok(wifiService.getWifiByCityId(cityId));
    }

    @GetMapping("/countries")
    public ResponseEntity<List<CountryDto>> getCountries() throws IOException {
        return ResponseEntity.ok(wifiService.getCountries());
    }
}
