      public class changeColor() extends TimerTask {
    	    public void run() {
    	        try
    	        {
    	           bridge.setLampState( lamp, "{\"hue\":"+hue+"}" ) ;
    	        }
    	        catch( IOException | HueException e )
    	        {
    	        	 System.out.println( "Error: " + e.getMessage() ) ;
    	        }
    	       hue += 100;
    	    		   if (hue > 65000) {
						hue = 0;
					}
    	    }
    	}