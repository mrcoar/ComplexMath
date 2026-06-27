package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class UnaryImaginaryOperationInputDTO implements Serializable {
    @Schema(
            description = "The imaginary number required for the operation",
            example = "5.2i",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected String input;
}
