package com.omidmohebbise.springopenapi.controller;


import com.omidmohebbise.springopenapi.controller.dto.PersonBasicDTO;
import com.omidmohebbise.springopenapi.controller.dto.PersonDetailDTO;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Person Controller Service")
@OpenAPIDefinition(info = @Info(title = "HR APIs", version = "1.0", description = "API for performing operations"))

public class PersonController {

    @GetMapping("/{id}")
//    @SecurityRequirement(name="security needed")
    @Operation(summary = "Get person basic info by id", description = "Endpoint to get Person necessary information.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "return id, name and family as necessary info"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public ResponseEntity<PersonBasicDTO> getPersonBasicInfo(@PathVariable Long id) {
        if (id == 1)
            return ResponseEntity.ok(new PersonBasicDTO(id, "Omid ", "Mohebbi"));
        else return ResponseEntity.notFound().build();

    }

    @GetMapping("/detail/{id}")
    //Hide documentation
    @Hidden
    @Operation(summary = "Get person detail info by id", description = "Endpoint to get Person detail information.")
    @ApiResponse(description = "return all person information")
    public ResponseEntity<PersonDetailDTO> getPersonDetailInfo(@PathVariable Long id) {
        return ResponseEntity.ok(new PersonDetailDTO(id, "Omid ", "Mohebbi" , 10 , "Amsterdam, Iran"));
    }


}
