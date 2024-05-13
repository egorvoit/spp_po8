using System;
using System.Collections.Generic;

namespace Task_1
{
    internal class MySet
    {
        private List<int> _list;
        public string name;

        public List<int> List
        {
            set { _list = value; }
            get { return _list; }
        }

        public MySet(string name, bool initialize = false)
        {
            this.name = name;
            _list = new List<int>();
            if (initialize)
            {
                _list.Add(1);
                _list.Add(2);
                _list.Add(3);
            }
        }

        public void AddToList(int value)
        {
            if (!ContainsEl(value))
            {
                _list.Add(value);

            }
        }
        public void PrintValues()
        {
            Console.WriteLine($"{this.name} elements:");

            foreach (var item in _list)
            {
                Console.WriteLine(item);
            }
        }
        public void Remove(int number)
        {
            _list.Remove(number);
            Console.WriteLine($"{number} was removed from {this.name}");
        }
        public bool ContainsEl(int number)
        {
            return _list.IndexOf(number) != -1;
        }
        public void Intersection(MySet obj)
        {
            Console.WriteLine($"What {this.name}'s elements intersect with {obj.name}?");
            List<int> intersection = new List<int>();
            foreach (var item in _list)
            {
                if (obj.ContainsEl(item))
                {
                    intersection.Add(item);
                }
            }
            if (intersection.Count == 0)
            {
                Console.WriteLine("No common items");
            }
            else
            {
                foreach (var item in intersection)
                {
                    Console.WriteLine(item);
                }
            }
        }
        public override bool Equals(object obj)
        {
            if (obj is MySet other)
            {
                if (_list.Count != other._list.Count) return false;
                for (int i = 0; i < _list.Count; i++)
                {
                    if (_list[i] != other._list[i])
                    {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        public override string ToString()
        {
            return string.Join(", ", _list);
        }
    }
}