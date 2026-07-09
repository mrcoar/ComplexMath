package cl.maraneda.backend.service.impl;

import cl.maraneda.backend.service.ImaginaryService;
import cl.maraneda.cplx.ComplexNumber;
import cl.maraneda.cplx.ImaginaryMath;
import cl.maraneda.cplx.ImaginaryNumber;
import cl.maraneda.cplx.MathResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public double cos(ImaginaryNumber in) {
        return ImaginaryMath.cos(in);
    }

    @Override
    public ImaginaryNumber tan(ImaginaryNumber in) {
        return ImaginaryMath.tan(in);
    }

    @Override
    public double sec(ImaginaryNumber in) {
        return ImaginaryMath.sec(in);
    }

    @Override
    public ImaginaryNumber csc(ImaginaryNumber in) {
        return ImaginaryMath.csc(in);
    }

    @Override
    public ImaginaryNumber cot(ImaginaryNumber in) {
        return ImaginaryMath.cot(in);
    }

    @Override
    public ImaginaryNumber sinh(ImaginaryNumber in) {
        return ImaginaryMath.sinh(in);
    }

    @Override
    public double cosh(ImaginaryNumber in) {
        return ImaginaryMath.cosh(in);
    }

    @Override
    public ImaginaryNumber tanh(ImaginaryNumber in) {
        return ImaginaryMath.tanh(in);
    }

    @Override
    public double sech(ImaginaryNumber in) {
        return ImaginaryMath.sech(in);
    }

    @Override
    public ImaginaryNumber csch(ImaginaryNumber in) {
        return ImaginaryMath.csch(in);
    }

    @Override
    public ImaginaryNumber coth(ImaginaryNumber in) {
        return ImaginaryMath.coth(in);
    }

    @Override
    public ComplexNumber exp(ImaginaryNumber in) {
        return ImaginaryMath.exp(in);
    }

    @Override
    public ImaginaryNumber asin(ImaginaryNumber in) {
        return ImaginaryMath.asin(in);
    }

    @Override
    public ComplexNumber acos(ImaginaryNumber in) {
        return ImaginaryMath.acos(in);
    }

    @Override
    public ImaginaryNumber atan(ImaginaryNumber in) {
        return ImaginaryMath.atan(in);
    }

    @Override
    public ComplexNumber asec(ImaginaryNumber in) {
        return ImaginaryMath.asec(in);
    }

    @Override
    public ImaginaryNumber acsc(ImaginaryNumber in) {
        return ImaginaryMath.acsc(in);
    }

    @Override
    public ImaginaryNumber acot(ImaginaryNumber in) {
        return ImaginaryMath.acot(in);
    }

    @Override
    public ImaginaryNumber asinh(ImaginaryNumber in) {
        return ImaginaryMath.asinh(in);
    }

    @Override
    public ImaginaryNumber acosh(ImaginaryNumber in) {
        return ImaginaryMath.acosh(in);
    }

    @Override
    public ImaginaryNumber atanh(ImaginaryNumber in) {
        return ImaginaryMath.atanh(in);
    }

    @Override
    public ComplexNumber asech(ImaginaryNumber in) {
        return ImaginaryMath.asech(in);
    }

    @Override
    public ImaginaryNumber acsch(ImaginaryNumber in) {
        return ImaginaryMath.acsch(in);
    }

    @Override
    public ImaginaryNumber acoth(ImaginaryNumber in) {
        return ImaginaryMath.acoth(in);
    }

    @Override
    public double arg(ImaginaryNumber in) {
        return ImaginaryMath.arg(in);
    }

    @Override
    public ImaginaryNumber logI(double num){
        return ImaginaryMath.logI(num);
    }

    @Override
    public ComplexNumber logI(double num, ImaginaryNumber base, Integer k) {
        return k == null ? ImaginaryMath.logI(num, base) : ImaginaryMath.logI(num, base, k);
    }

    @Override
    public ComplexNumber logI(ImaginaryNumber num, ImaginaryNumber base, Integer k, Integer n) {
        if(k == null && n == null){
            return ImaginaryMath.logI(num, base);
        }
        if(k == null){
            return ImaginaryMath.logI(num, base, 0, n);
        }
        return ImaginaryMath.logI(num, base, k, Objects.requireNonNullElse(n, 0));
    }

    @Override
    public ComplexNumber logN(ImaginaryNumber num, double base, Integer k) {
        if(base != 10) {
            return k == null ? ImaginaryMath.logN(num, base) : ImaginaryMath.logN(num, base, k);
        }
        return k == null ? ImaginaryMath.log10(num) : ImaginaryMath.log10(num, k);
    }

    @Override
    public ComplexNumber log(ImaginaryNumber num, Integer k) {
        return k == null ? ImaginaryMath.log(num) : ImaginaryMath.log(num, k);
    }
}
