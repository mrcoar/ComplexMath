package cl.maraneda.backend.service;

import cl.maraneda.cplx.ComplexNumber;
import org.springframework.stereotype.Service;

@Service
public interface ComplexService {
    public ComplexNumber conjugate(double real, double imaginary);
}
