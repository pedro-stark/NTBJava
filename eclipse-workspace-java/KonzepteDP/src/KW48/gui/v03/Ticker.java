package KW48.gui.v03;

import java.awt.EventQueue;

class Ticker extends Thread
{
    private final static long UPDATE_INTERVAL = 10; // Milliseconds
    private UpdateRequest updateReq;

    public Ticker(Clock clock)
    {
        updateReq = new UpdateRequest(clock);
        start();
    }

    public void run()
    {
        try
        {
            while(!isInterrupted())
            {
                EventQueue.invokeLater(updateReq);
            	//updateReq.run();
            	
                Thread.sleep(UPDATE_INTERVAL);
            }
        }
        catch(InterruptedException e)
        {
        }
    }
}