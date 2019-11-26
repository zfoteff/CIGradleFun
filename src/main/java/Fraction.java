import java.util.Scanner;

public class Fraction
{
    protected int numerator;
    protected int denominator;

    public Fraction()
    {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int n, int d)
    {
        numerator = n;

        if (d == 0)
        {
            System.out.println("Divide by 0 error");
            System.exit(0);
        }

        denominator = d;
    }

    public String toString()
    {
        return ""+numerator+"/"+denominator;
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public double getRealValue()
    {
        return ((double) numerator/denominator);
    }

    public Fraction reduce(Fraction fraction)
    {
        int gcd = fraction.gcd();
        int newNumerator = fraction.numerator/gcd;
        int newDenominator = fraction.denominator/gcd;

        Fraction temp = new Fraction(newNumerator, newDenominator);
        return temp;
    }

    public Fraction add(Fraction fraction)
    {
        Fraction f1 = reduce(this);
        Fraction f2 = reduce(fraction);
        Fraction result;
        int resultNumerator;
        int resultDenominator;

        if (f1.denominator == f2.denominator)
        {
            resultNumerator = f1.numerator + f2.numerator;
            resultDenominator = f1.denominator;
        }

        else
        {
            resultNumerator = (f1.numerator * f2.denominator) + (f2.numerator * f1.denominator);
            resultDenominator = f1.denominator * f2.denominator;
        }

        result = new Fraction(resultNumerator, resultDenominator);
        result = reduce(result);

        return  result;
    }

    public boolean equals(Fraction fraction)
    {
        Fraction f1 = this;
        Fraction f2 = fraction;

        f1 = reduce(f1);
        f2 = reduce(f2);


        if (f1.numerator == f2.numerator && f1.denominator == f2.denominator)
            return true;

        return false;
    }

    public int compareTo(Fraction fraction)
    {
        Fraction f1 = reduce(this);
        Fraction f2 = reduce(fraction);

        int compare = 0;

        if (f1.getRealValue() < f2.getRealValue())
            compare = -1;

        else if (f1.getRealValue() == f2.getRealValue())
            compare = 0;

        else if (f1.getRealValue() > f2.getRealValue())
            compare = 1;

        return compare;
    }

    protected int gcd()
    {
        int a = numerator;
        int b = denominator;

        if (a == 0 || b == 0)
            return -1;

        int remainder = 0;
        while (b != 0)
        {
            remainder = a % b;
            a = b;
            b = remainder;
        }

        return remainder;
    }
}
