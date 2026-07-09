package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BinaryImaginaryAndRealOperationInputDTO extends UnaryImaginaryOperationInputDTO{
    @Schema(
            description = "The real number used as second operand",
            example = "2",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected double rinput;
}
