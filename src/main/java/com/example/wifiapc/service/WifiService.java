package com.example.wifiapc.service;

import com.example.wifiapc.dto.*;
import com.example.wifiapc.util.GraphqlSchemaReaderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WifiService {
    private final RestTemplate restTemplate;

    private static final String wifiMapUrl= "https://api.wifimap.io/graphql_public_api";

    public CityDto getWifiByCityId(Long cityId) throws IOException {
        final String query = GraphqlSchemaReaderUtil.getSchemaFromFileName("getWifiByCityId");
        final String variables = GraphqlSchemaReaderUtil.getSchemaFromFileName("variables");
        final GraphQlRequestBody graphQlRequestBody = new GraphQlRequestBody();
        graphQlRequestBody.setQuery(query);
        graphQlRequestBody.setVariables(variables.replace("cityId", cityId + ""));

        RequestEntity<GraphQlRequestBody> request = new RequestEntity<>(graphQlRequestBody,HttpMethod.POST, URI.create(wifiMapUrl));
        return restTemplate.exchange(request, GraphQlResponseCity.class).getBody().getData().getCity();
    }

    public List<CountryDto> getCountries() throws IOException {
        final String query = GraphqlSchemaReaderUtil.getSchemaFromFileName("getCountries");
        final GraphQlRequestBody graphQlRequestBody = new GraphQlRequestBody();
        graphQlRequestBody.setQuery(query);

        RequestEntity<GraphQlRequestBody> request = new RequestEntity<>(graphQlRequestBody,HttpMethod.POST, URI.create(wifiMapUrl));
        return restTemplate.exchange(request, GraphQlResponseCountry.class).getBody().getData().getCountries();
    }
}
