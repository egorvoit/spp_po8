namespace sppLab6z2;

public class Component
{
    public string Name { get; set; }

    public Component(string name)
    {
        Name = name;
    }
    
    public virtual void Add(Component component){}
 
    public virtual void Remove(Component component) { }
 
    public virtual void Print() { }
}

public class Directory : Component 
{
    public List<Component> Components = new List<Component>();
    
    public Directory(string name)
        : base(name)
    {
    }

    public override void Add(Component component)
    {
        Components.Add(component);
    }

    public override void Remove(Component component)
    {
        Components.Remove(component);
    }

    public override void Print()
    {
        Console.WriteLine($"Dir name: {Name}");
        Console.WriteLine($"Contents:");
        foreach (var component in Components)
        {
            component.Print();
        }
    }
    
}

public class File : Component
{
    public int Size { get; set; }
    public string Extension { get; set; } 
    public string Date { get; set; }

    public File(string name, int size, string extension, string date) : base(name)
    {
        Size = size;
        Extension = extension;
        Date = date;
    }

    public override void Print()
    {
        Console.WriteLine($"File: {Name}, Extension: {Extension}, Size: {Size}, Date: {Date}");
    }
}