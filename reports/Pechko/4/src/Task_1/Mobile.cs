using System;
using System.Collections.Generic;

namespace Task1
{
    public class Mobile
    {
        private class Model
        {
            public string Name { get; }
            public string Properties { get; }

            public Model(string name, string properties)
            {
                Name = name;
                Properties = properties;
            }
        }

        private Dictionary<string, List<Model>> models;

        public Mobile()
        {
            models = new Dictionary<string, List<Model>>();
        }

        public void AddModel(string name, string properties)
        {
            if (!models.ContainsKey(name))
            {
                models[name] = new List<Model>();
            }

            models[name].Add(new Model(name, properties));
        }

        public List<string> FindModels(string name)
        {
            if (models.ContainsKey(name))
            {
                List<string> foundModels = new List<string>();
                foreach (var model in models[name])
                {
                    foundModels.Add(model.Properties);
                }
                return foundModels;
            }
            else
            {
                return new List<string>();
            }
        }

        public void PrintAllModels()
        {
            foreach (var entry in models)
            {
                Console.WriteLine($"Model: {entry.Key}");
                foreach (var model in entry.Value)
                {
                    Console.WriteLine($"- {model.Properties}");
                }
                Console.WriteLine();
            }
        }
    }
}

