string[] text;
using(StreamReader sr = new StreamReader("input.txt"))
{
    text = sr.ReadToEnd().Split('\n',' ','-','.',',',';',':','!','?','(',')','[',']','{','}');
}

for (int i = 0; i < text.Length; i++)
{
    text[i] = text[i].Trim();
}

var etalon = text[0];
Console.WriteLine($"Etalon: {etalon}");
foreach (var s in text.Skip(1))
{ 
    if (s.Contains(etalon[..(etalon.Length / 2 + 1)]))
    {
        Console.WriteLine(s);
    }
}