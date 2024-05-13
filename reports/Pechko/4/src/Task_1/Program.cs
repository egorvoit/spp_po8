using Task1;

Mobile myMobile = new Mobile();
myMobile.AddModel("iPhone 13", "Properties: A15 Bionic, 6.1\" Super Retina XDR display");
myMobile.AddModel("Samsung Galaxy S21", "Properties: Exynos 2100, 6.2\" Dynamic AMOLED 2X");
List<string> iPhoneModels = myMobile.FindModels("iPhone 13");
foreach (var model in iPhoneModels)
{
    Console.WriteLine("- " + model);
}
Console.WriteLine("All Models:");
myMobile.PrintAllModels();