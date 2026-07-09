package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TrinaryImaginaryRealAndIntOperationInputDTO extends BinaryImaginaryAndRealOperationInputDTO{
    @Schema(
            description = "The optional integer number used as third operand. By default, its value is zero.",
            example = "2",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED,
            type = "int"
    )
    private Integer iinput;
}
