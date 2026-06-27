package cl.maraneda.backend.service.impl;

import cl.maraneda.backend.service.ComplexService;
import cl.maraneda.cplx.ComplexMath;
import cl.maraneda.cplx.ComplexNumber;
import org.springframework.stereotype.Service;

@Service
public class ComplexServiceImpl implements ComplexService {
    @Override
    public ComplexNumber conjugate(ComplexNumber cn) {
        return ComplexMath.conjugate(cn);
    }
}
