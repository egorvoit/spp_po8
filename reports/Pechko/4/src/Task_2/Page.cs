using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task_2
{
    internal class Page
    {
        private List<Word> words;

        public Page()
        {
            this.words = new List<Word>();
        }

        public int WordCount()
        {
            return words.Count;
        }

        public List<Word> GetWords()
        {
            return words;
        }

        public void AddWord(Word word)
        {
            words.Add(word);
        }
    }
}
