package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BinaryImaginaryAndRequiredIntOperationInputDTO extends UnaryImaginaryOperationInputDTO{
    @Schema(
            description = "The exponent the imaginary number will be raised to the power of",
            example = "2",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private int iinput;
}
