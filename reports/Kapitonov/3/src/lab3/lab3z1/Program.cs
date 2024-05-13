using lab3z1;

var t1 = new Triangle();
var t2 = new Triangle(6,8,10);
Console.WriteLine(t2);
Console.WriteLine(t2.Exists());
Console.WriteLine(t2.Equals(t1));
Console.WriteLine(t2.CalcP());
Console.WriteLine(t2.CalcS());
Console.ReadLine();