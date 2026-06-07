package cl.maraneda.backend.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UnaryComplexOperationInputDTO implements Serializable {
    private double[] cnumber;
}
