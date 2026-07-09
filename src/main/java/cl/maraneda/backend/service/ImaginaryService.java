package cl.maraneda.backend.service;

import cl.maraneda.cplx.ComplexNumber;
import cl.maraneda.cplx.ImaginaryNumber;
import cl.maraneda.cplx.MathResult;

import java.util.List;

public interface ImaginaryService {
    MathResult pow(int exp);
    MathResult pow(ImaginaryNumber in, int exp);
    ComplexNumber pow(double base, ImaginaryNumber exp);
    ComplexNumber pow(ImaginaryNumber base, ImaginaryNumber exp, Integer k);

    ImaginaryNumber sum(ImaginaryNumber[] ops);
    MathResult sum(double[] rops, ImaginaryNumber[] iops);

    MathResult multiply(ImaginaryNumber[] ops);
    MathResult multiply(double r, ImaginaryNumber i);
    MathResult multiply(double[] r, ImaginaryNumber[] i);

    double divide(ImaginaryNumber i1, ImaginaryNumber i2);
    ImaginaryNumber divide(ImaginaryNumber i, double r);
    MathResult divide(double r, ImaginaryNumber i);

    double sgn(ImaginaryNumber i);

    MathResult sqrt(double num);
    List<ComplexNumber> nrt(ImaginaryNumber in, int n);

    ImaginaryNumber sin(ImaginaryNumber in);
    double cos(ImaginaryNumber in);
    ImaginaryNumber tan(ImaginaryNumber in);
    double sec(ImaginaryNumber in);
    ImaginaryNumber csc(ImaginaryNumber in);
    ImaginaryNumber cot(ImaginaryNumber in);

    ImaginaryNumber sinh(ImaginaryNumber in);
    double cosh(ImaginaryNumber in);
    ImaginaryNumber tanh(ImaginaryNumber in);
    double sech(ImaginaryNumber in);
    ImaginaryNumber csch(ImaginaryNumber in);
    ImaginaryNumber coth(ImaginaryNumber in);

    ComplexNumber exp(ImaginaryNumber in);

    ImaginaryNumber asin(ImaginaryNumber in);
    ComplexNumber acos(ImaginaryNumber in);
    ImaginaryNumber atan(ImaginaryNumber in);
    ComplexNumber asec(ImaginaryNumber in);
    ImaginaryNumber acsc(ImaginaryNumber in);
    ImaginaryNumber acot(ImaginaryNumber in);

    ImaginaryNumber asinh(ImaginaryNumber in);
    ImaginaryNumber acosh(ImaginaryNumber in);
    ImaginaryNumber atanh(ImaginaryNumber in);
    ComplexNumber asech(ImaginaryNumber in);
    ImaginaryNumber acsch(ImaginaryNumber in);
    ImaginaryNumber acoth(ImaginaryNumber in);

    double arg(ImaginaryNumber in);

    ImaginaryNumber logI(double num);
    ComplexNumber logI(double num, ImaginaryNumber base, Integer k);
    ComplexNumber logI(ImaginaryNumber num, ImaginaryNumber base, Integer k, Integer n);
    ComplexNumber logN(ImaginaryNumber num, double base, Integer k);
    ComplexNumber log(ImaginaryNumber num, Integer k);
}
