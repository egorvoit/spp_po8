using System;
using System.Threading.Tasks;

class Program
{
    static void Main(string[] args)
    {
        Task_2.Page page = new Task_2.Page();

        Console.WriteLine("Enter words for a page (separated by space), or type 'done' to finish:");

        bool addingWords = true;
        while (addingWords)
        {
            string input = Console.ReadLine();
            if (input.ToLower() == "done")
            {
                addingWords = false;
            }
            else
            {
                string[] wordStrings = input.Split(' ');
                foreach (string wordString in wordStrings)
                {
                    page.AddWord(new Task_2.Word(wordString));
                }
            }
        }

        Console.WriteLine("Number of words on the page: " + page.WordCount());
    }
}

