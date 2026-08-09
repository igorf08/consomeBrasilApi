package com.igorf08.consomeApiBrasil.mapper;

import com.igorf08.consomeApiBrasil.dto.CepResponseDTO;
import com.igorf08.consomeApiBrasil.dto.CoordinatesDTO;
import com.igorf08.consomeApiBrasil.dto.LocationDTO;
import com.igorf08.consomeApiBrasil.model.CepModel;
import org.springframework.stereotype.Component;

@Component
public class CepMapper {

    public CepModel toModel(CepResponseDTO response) {

        String lng = null;
        String lat = null;

        if (response.location() != null && response.location().coordinates() != null) {
            lng = response.location().coordinates().longitude();
            lat = response.location().coordinates().latitude();
        }

        return new CepModel(
                response.cep(),
                response.state(),
                response.city(),
                response.neighborhood(),
                response.street(),
                response.timezoneName(),
                lng,
                lat
        );
    }

    public CepResponseDTO toResponse(CepModel response) {
        CoordinatesDTO coordinates = new CoordinatesDTO(response.getLongitude(), response.getLatitude());

        LocationDTO location = new LocationDTO("coordenadas", coordinates);

        return new CepResponseDTO(
                response.getCep(),
                response.getState(),
                response.getCity(),
                response.getNeighborhood(),
                response.getStreet(),
                response.getTimezoneName(),
                location
        );
    }
}
