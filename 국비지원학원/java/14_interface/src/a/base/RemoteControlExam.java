package a.base;


public class RemoteControlExam {

	public static void main(String[] args) {
		RemoteControl tvRemote = new TVRemoteControl();//new RemoteControl
		tvRemote.turnOn();
		tvRemote.setValue(11);
		tvRemote.turnOff();
		
		RemoteControl airRemote = new AirRemoteControl();
		airRemote.turnOn();
		airRemote.setValue(24);
		
		RemoteControl smartTVRemote = new SmartTVRemoteControl();
		smartTVRemote.turnOn();
		smartTVRemote.setValue(9);
		
		Searchable searchRemote = (Searchable)smartTVRemote;
		searchRemote.search("TENET");
		
		if (searchRemote instanceof SmartTVRemoteControl) {
			SmartTVRemoteControl stc = (SmartTVRemoteControl)searchRemote;
			stc.turnOn();
			stc.search("Avengers End Game");
			stc.turnOff();
		}
		
		
	}

}
