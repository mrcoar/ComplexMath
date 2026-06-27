package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ImaginaryExpAndBasePowInputDTO extends UnaryImaginaryOperationInputDTO{

    @Schema(
            description = "The imaginary base which will be raised to the power of an imaginary number",
            example = "3i",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String base;

    @Schema(
            description = "Indicates that the kth value of the natural logarithm of the base will be used. If it's ommited, assume a zero",
            example = "4",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Integer k;
}
