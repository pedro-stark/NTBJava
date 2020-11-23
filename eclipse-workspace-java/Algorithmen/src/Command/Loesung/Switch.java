package Command.Loesung;

class Switch {
    private Command UpCommand, DownCommand;
    public Switch( Command Up, Command Down) {
            UpCommand = Up; // concrete Command registers itself with the invoker 
            DownCommand = Down;
    }
    void flipUp( ) { // invoker calls back concrete Command, which executes the Command on the receiver 
                    UpCommand . execute ( ) ;                           
    }
    void flipDown( ) {
                    DownCommand . execute ( );
    }
    void set(Command up, Command down) {
    	UpCommand = up;
    	DownCommand = down;
    }
}
