package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ImaginaryLogarithmInputDTO {
    @Schema(
            description = "The imaginary number and its kth value whose logarithm will be calculated",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private BinaryImaginaryAndOptionalIntOperationInputDTO num;

    @Schema(
            description = "The imaginary base and its nth value to calculate the logarithm",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private BinaryImaginaryAndOptionalIntOperationInputDTO base;
}
