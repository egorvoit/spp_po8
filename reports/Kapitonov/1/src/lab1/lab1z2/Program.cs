int n = Convert.ToInt32(args[0]);
if(n <= 0)
{
    Console.WriteLine("Wrong size of array");
    return 0;
}
double[] arr = new double[n];
for (int i = 0; i < n; i++)
{
    arr[i] = Convert.ToDouble(args[i + 1]);
}
Reverse(arr);

foreach (var d in arr)
{
    Console.Write(d + " ");
}
return 0;

void Reverse(double[] arr)
{
    for (int i = 0; i < n / 2; i++)
    {
        (arr[i],arr[n-i-1])=(arr[n-i-1],arr[i]);
    }
    
}
