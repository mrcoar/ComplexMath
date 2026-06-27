package cl.maraneda.backend.dto;

import cl.maraneda.cplx.ComplexNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplexListOutputDTO implements Serializable {
    private List<String> result;
}
