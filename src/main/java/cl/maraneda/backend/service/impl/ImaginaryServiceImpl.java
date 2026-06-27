package cl.maraneda.backend.service.impl;

import cl.maraneda.backend.service.ImaginaryService;
import cl.maraneda.cplx.ComplexNumber;
import cl.maraneda.cplx.ImaginaryMath;
import cl.maraneda.cplx.ImaginaryNumber;
import cl.maraneda.cplx.MathResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImaginaryServiceImpl implements ImaginaryService {
    @Override
    public MathResult pow(int exp) {
        return ImaginaryMath.pow(exp);
    }

    @Override
    public MathResult pow(ImaginaryNumber in, int exp) {
        return ImaginaryMath.pow(in, exp);
    }

    @Override
    public ComplexNumber pow(double base, ImaginaryNumber exp) {
        return ImaginaryMath.pow(base, exp);
    }

    @Override
    public ComplexNumber pow(ImaginaryNumber base, ImaginaryNumber exp, Integer k) {
        return k == null ? ImaginaryMath.pow(base, exp) : ImaginaryMath.pow(base, exp, k);
    }

    @Override
    public ImaginaryNumber sum(ImaginaryNumber[] ops) {
        return ImaginaryMath.sum(ops);
    }

    @Override
    public MathResult sum(double[] rops, ImaginaryNumber[] iops) {
        return ImaginaryMath.sum(rops, iops);
    }

    @Override
    public MathResult multiply(ImaginaryNumber[] ops) {
        return ImaginaryMath.multiply(ops);
    }

    @Override
    public MathResult multiply(double r, ImaginaryNumber i) {
        return ImaginaryMath.multiply(r, i);
    }

    @Override
    public MathResult multiply(double[] r, ImaginaryNumber[] i) {
        return ImaginaryMath.multiply(r, i);
    }

    @Override
    public double divide(ImaginaryNumber i1, ImaginaryNumber i2) {
        return ImaginaryMath.divide(i1, i2);
    }

    @Override
    public ImaginaryNumber divide(ImaginaryNumber i, double r) {
        return ImaginaryMath.divide(i, r);
    }

    @Override
    public MathResult divide(double r, ImaginaryNumber i) {
        return ImaginaryMath.divide(r, i);
    }

    @Override
    public double sgn(ImaginaryNumber i) {
        return ImaginaryMath.sgn(i);
    }

    @Override
    public MathResult sqrt(double num) {
        return ImaginaryMath.sqrt(num);
    }

    @Override
    public List<ComplexNumber> nrt(ImaginaryNumber in, int n) {
        return switch(n){
            case 1 -> List.of(new ComplexNumber(in));
            case 2 -> ImaginaryMath.sqrt(in);
            case 3 -> ImaginaryMath.cbrt(in);
            default -> ImaginaryMath.nrt(in, n);
        };
    }

    @Override
    public ImaginaryNumber sin(ImaginaryNumber in) {
        return ImaginaryMath.sin(in);
    }
}
