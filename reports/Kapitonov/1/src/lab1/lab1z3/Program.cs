string input = args[0];

int i1 = 0, i2 = input.Length - 1;

input = input.ToLower().Replace('ё', 'е');

while (i1 != i2)
{
    
    if (!Char.IsLetter(input[i1]))
    {
        i1 += 1;
        continue;
    }
    if (!Char.IsLetter(input[i2]))
    {
        i2 -= 1;
        continue;
    }
    if (input[i1] == input[i2])
    {
        i1++;
        i2--;
    }
    else
    {
        Console.WriteLine("Not palindrome");
        return;
    }
}

Console.WriteLine("Palindrome");