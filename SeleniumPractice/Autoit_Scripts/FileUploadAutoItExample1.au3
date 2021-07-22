;open a window     WinWait("[CLASS:className]","","time in seconds"
Local $window = WinWait("[CLASS:#32770]","","10")

;to edit any text first step is foucs the add text
ControlFocus($window,"","ToolbarWindow323");
ControlSetText($window,"","ToolbarWindow323","C:\Users\danishp\Pictures\ironman.jpg")
Sleep(500)