using System.Security.Cryptography;

Person person = new Person() { name = "Roman", age = 23};
void ChangePerson(ref Person person)
{
    person.name = "NoName";
    person = new Person() { name = "Bill", age = 123 };
    Console.WriteLine(person.name);
}

ChangePerson(ref person);
Console.WriteLine(person.name);
Console.WriteLine(person.age);



class Person
{
    public string name = "";
    public int age;
}

