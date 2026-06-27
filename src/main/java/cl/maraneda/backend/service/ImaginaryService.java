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
}
