var arr = args.Select(int.Parse);
double average = arr.Average();
double d = arr.Average(x => Math.Pow(x - average, 2));

Console.WriteLine($"Avg: {average}\n" +
                  $"Disp: {d}");
return 0;

