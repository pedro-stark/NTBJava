package Prototype.Platform;

//Concrete prototype:
public class ShallowCopy implements Cloneable{
	 
    private String type;
 
    private Windows wind;
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
 
    public Windows getWind() {
        return wind;
    }
 
    public void setWind(Windows wind) {
        this.wind = wind;
    }
 
    public ShallowCopy(String type, Windows wind) {
        this.type = type;
        this.wind = wind;
    }
 
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}