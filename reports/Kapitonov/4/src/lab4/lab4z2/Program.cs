using lab4z2;

MyChar ch1 = new MyChar() { Value = 'a' };
MyChar ch2 = new MyChar() { Value = 'b' };
MyChar ch3 = new MyChar() { Value = 'c' };
MyChar ch4 = new MyChar() { Value = 'd' };
MyChar ch5 = new MyChar() { Value = 'e' };
MyChar ch6 = new MyChar() { Value = 'f' };
MyChar ch7 = new MyChar() { Value = 'g' };

MyWord w1 = new MyWord() { Chars = new List<MyChar>() { ch1, ch2, ch3 } };
MyWord w2 = new MyWord() { Chars = new List<MyChar>() { ch4, ch5, ch6 } };
MyWord w3 = new MyWord() { Chars = new List<MyChar>() { ch7 } };

MyString s1 = new MyString() { MyStrings = new List<MyWord>() { w1, w2, w3 } };

Console.WriteLine(s1);