package Command.Loesung;

public class TestCommand {
    public static void main(String[] args) {
            Light  testLight = new Light( );
            LightOnCommand testLOC = new LightOnCommand(testLight);
            LightOffCommand testLFC = new LightOffCommand(testLight);
            Switch testSwitch = new Switch( testLOC,testLFC);       
            testSwitch.flipUp( );
            testSwitch.flipDown( );
            Fan testFan = new Fan( );
            FanOnCommand foc = new FanOnCommand(testFan);
            FanOffCommand ffc = new FanOffCommand(testFan);
            testSwitch.set( foc,ffc);
            testSwitch.flipUp( );
            testSwitch.flipDown( ); 
    }
} 