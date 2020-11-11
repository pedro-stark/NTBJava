package Prototype.Platform;

import java.io.Serializable;
//Reference type object:
public class Windows implements Serializable {
	 
    private String Version;
 
    private String productID;
 
    public Windows(String Version, String productID) {
        this.Version = Version;
        this.productID = productID;
    }
 
    public String getVersion() {
        return Version;
    }
 
    public void setVersion(String Version) {
        this.Version = Version;
    }
 
    public String getProductID() {
        return productID;
    }
 
    public void setProductID(String productID) {
        this.productID = productID;
    }
 
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", gender='" + gender + '\'' +
//                '}';
//    }
}