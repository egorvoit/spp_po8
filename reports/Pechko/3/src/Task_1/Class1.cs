using Task_1;

MySet set1 = new MySet("Set1");
MySet set2 = new MySet("Set2", true);
set1.AddToList(3);

set1.AddToList(1);
set1.AddToList(4);
set1.AddToList(5);
set1.PrintValues();
set2.AddToList(4);
set2.AddToList(3);
set2.AddToList(6);
set2.PrintValues();
Console.WriteLine(set1.Equals(set1));
Console.WriteLine(set1.Equals(set2));
set1.Intersection(set2);
Console.WriteLine($"Does {set1.name} contain 1?");
Console.WriteLine(set1.ContainsEl(1));
Console.WriteLine($"Does {set2.name} contain 1?");
Console.WriteLine(set2.ContainsEl(1));
set2.Remove(1);
Console.WriteLine($"Does {set2.name} contain 1?");
Console.WriteLine(set2.ContainsEl(1));