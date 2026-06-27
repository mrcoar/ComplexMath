package cl.maraneda.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderedPairInputDTO implements Serializable {
    @Schema(
            description = "An Ordered Pair containing one real and one imaginary part",
            example = "[2, 4.1]",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private double[] cnumber;
}
