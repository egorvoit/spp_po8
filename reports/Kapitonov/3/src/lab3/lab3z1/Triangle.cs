namespace lab3z1;

public class Triangle
{
    private Triangle _triangle;
    public double A { get; set; }
    public double B { get; set; }
    public double C { get; set; }

    public Triangle(double a, double b, double c) // а - the bigger side
    {
        if (Math.Pow(A, 2) == Math.Pow(B, 2) + Math.Pow(C, 2))
        {
            A = a;
            B = b;
            C = c;
        }
        else
        {
            A = 3;
            B = 4;
            C = 5; 
        }
        
    }

    public Triangle()
    {
        A = 3;
        B = 4;
        C = 5;
    }
    
    
    
    public double CalcP()
    {
        return A + B + C;
    }

    public double CalcS()
    {
        double p = (A + B + C) / 2;
        return Math.Sqrt(p * (p - A) * (p - B) * (p - C));
    }

    public override string ToString()
    {
        return $"A:{A}, B:{B}, C:{C}";
    }

    public override bool Equals(object? obj)
    {
        if (A == ((Triangle)obj).A && B == ((Triangle)obj).B && C == ((Triangle)obj).C)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public bool Exists()
    {
        if (Math.Pow(A, 2) == Math.Pow(B, 2) + Math.Pow(C, 2))
        {
            return true;
        }
        return false;
    }
}