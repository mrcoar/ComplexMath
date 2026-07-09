package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BinaryImaginaryAndOptionalIntOperationInputDTO extends UnaryImaginaryOperationInputDTO{
    @Schema(
            description = "The optional integer number in the operation",
            example = "2",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Integer iinput;
}
