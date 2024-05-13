using lab4z1;

CreditBook kapitonov = new CreditBook(1,"Maksim","Kapitonov");
kapitonov.AddSession("S1");
kapitonov.AddTest("S1","SPP","Alexandr","Kroschenko",false);
kapitonov.AddTest("S1","RMS","X","Kozinski",false);
kapitonov.AddTest("S1","EXAM1","ExamF","ExamS",true);
kapitonov.SetScore("S1","SPP",true);
kapitonov.SetScore("S1","RMS",false);
kapitonov.SetScore("S1","EXAM1",10);
kapitonov.PrintAllSession();