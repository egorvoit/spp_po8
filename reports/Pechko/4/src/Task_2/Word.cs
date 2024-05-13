using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task_2
{
    internal class Word
    {
        private string text;

        public Word(string text)
        {
            this.text = text;
        }

        public string GetText()
        {
            return text;
        }
    }
}
