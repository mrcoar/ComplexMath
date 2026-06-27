package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ImaginaryArrayInputDTO {
    @Schema(
            description = "An array of Strings in which each element must be a valid imaginary number. Also, the array's length must be greater than one",
            example = "[\"i\", \"2i\", \"3i\"]",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String[] ops;
}
