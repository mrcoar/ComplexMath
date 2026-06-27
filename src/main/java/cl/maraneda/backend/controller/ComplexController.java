package cl.maraneda.backend.controller;

import cl.maraneda.backend.dto.OrderedPairInputDTO;
import cl.maraneda.backend.service.ComplexService;
import cl.maraneda.cplx.ComplexNumber;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complexMath/complex")
@Tag(
        name = "Complex Numbers",
        description = "Operations for creating and manipulating complex numbers"
)
public class ComplexController {

    private final ComplexService complexService;

    @Autowired
    public ComplexController(ComplexService complexService){
        this.complexService = complexService;
    }

    @Operation(
            summary = "Obtains the conjugate of a complex number",
            description = """
                Receives an array of length two representing a complex number
                and generates it's conjugate (that is, the same complex number, 
                but with the sign inverted for the imaginary part).
                """
    )
    @ApiResponse(responseCode = "200", description = "Conjugate calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or not a ordered pair input")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/conjugate")
    public ResponseEntity<@NonNull String> conjugate(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Required complex number as an ordered pair to calculate the conjugate",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(
                        implementation = OrderedPairInputDTO.class
                )
            )
        )
        @RequestBody OrderedPairInputDTO input){
        ComplexNumber cnin = ComplexNumber.fromOrderedPair(input.getCnumber());
        ComplexNumber cnout = complexService.conjugate(cnin);
        return ResponseEntity.ok(cnout.toString());
    }
}
