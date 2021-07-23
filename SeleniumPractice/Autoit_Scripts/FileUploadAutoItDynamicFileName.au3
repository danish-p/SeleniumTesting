;open a window     WinWait("[CLASS:className]","",integer time in seconds
Local $window = WinWait("[CLASS:#32770]","",10)

;to edit any text first step is foucs the add text
ControlFocus($window,"","Edit1");
Sleep(500)
;hardcoded file name
;ControlSetText($window,"","","C:\Users\danishp\Pictures\ironman.jpg")
;take input from user
ControlSetText($window, "", "", "C:\Users\danishp\Pictures\Saved Pictures\My_Favourite"&$CmdLine[1])
Sleep(500)
ControlClick($window,"","Button1")