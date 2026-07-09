package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TrinaryTwoImaginariesAndOptionalIntInputDTO extends UnaryImaginaryOperationInputDTO{

    @Schema(
            description = "The second imaginary required number for the operation",
            example = "3i",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String base;

    @Schema(
            description = "The integer optional number for the operation",
            example = "4",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Integer k;
}
