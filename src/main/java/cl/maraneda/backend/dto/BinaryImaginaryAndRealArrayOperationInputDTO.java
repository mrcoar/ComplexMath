package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BinaryImaginaryAndRealArrayOperationInputDTO extends ImaginaryArrayInputDTO {

    @Schema(
            description = "An array of real numbers",
            example = "[2, 3, 4]",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private double[] rops;
}
