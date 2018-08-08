Set wshShell = CreateObject( "WScript.Shell" )
  wshShell.ExpandEnvironmentStrings( "%BBTERM%" )
dim file
  dim fname
  fname =  "print.txt"
  file = "C:\Users\Rabinson\Documents\NetBeansProjects\MinorProject\WRCMinorProject\print.txt"
Set objFSO = CreateObject("Scripting.FileSystemObject")
	Set objFile = objFSO.GetFile(file)
        strPath = objFSO.GetParentFolderName(objFile)
        Set objShell = CreateObject("Shell.Application")
        Set objFolder = objShell.Namespace(strPath) 
        Set objFolderItem = objFolder.ParseName(fname)
        objFolderItem.InvokeVerbEx("Print")
Set objPrinter = CreateObject("WScript.Network")
objPrinter.SetDefaultPrinter "\\servername\printername"