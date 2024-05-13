using sppLab6z2;
using Directory = sppLab6z2.Directory;
using File = sppLab6z2.File;

Directory fileSystem = new Directory("FS");
Directory diskC = new Directory("diskC");
Directory myDoc = new Directory("MyDoc");
File sppLab1 = new File("SppLab1",100,".docx","10.07");
File sppLab2 = new File("SppLab1",100,".docx","11.07");
File sppLab3 = new File("SppLab1",100,".docx","12.07");
File csCheats = new File("CS2Cheat",100000,".cheat","10.01");
diskC.Add(csCheats);
diskC.Add(myDoc);
myDoc.Add(sppLab1);
myDoc.Add(sppLab2);
myDoc.Add(sppLab3);
fileSystem.Add(diskC);

fileSystem.Print();