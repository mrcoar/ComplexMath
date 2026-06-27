package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BinaryImaginaryOperationInputDTO extends UnaryImaginaryOperationInputDTO{

    @Schema(
            description = "The second imaginary number required for the operation",
            example = "2.6i",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String input2;
}
