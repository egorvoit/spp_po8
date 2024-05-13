namespace lab4z2;

public class MyString
{
    public List<MyWord> MyStrings { get; set; }

    public override string ToString()
    {
        return string.Join(" ", MyStrings.Select(x => x.ToString()));
    }
    
}

public class MyWord
{
    public List<MyChar> Chars { get; set; }

    public override string ToString()
    {
        return string.Join("", Chars.Select(x => x.Value));
    }
}

public class MyChar
{
    public char Value { get; set; }
}