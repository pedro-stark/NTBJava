package KW48.gui.v03;

class UpdateRequest implements Runnable
{
    private Clock clock;

    public UpdateRequest(Clock clock)
    {
        this.clock = clock;
    }

    public void run()
    {
        clock.update();
    }
}