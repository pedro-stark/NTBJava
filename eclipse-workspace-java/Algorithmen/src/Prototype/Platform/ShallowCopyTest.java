package Prototype.Platform;

//Client test
public class ShallowCopyTest {

	public static void main(String[] args) {
		Windows win = new Windows("Windows NT", "Win");
		ShallowCopy shallowCopy = new ShallowCopy("professional", win);
		//
		Windows mac = new Windows("Macintosh", "Mac OS");
		ShallowCopy shallowCopy1 = new ShallowCopy("Leopard (10.5)", mac);

		try {
			ShallowCopy copy = (ShallowCopy) shallowCopy.clone();
			System.out.println("Original windows: " + shallowCopy);
			System.out.println("Copy Windows: " + copy);
			System.out.println("Original  TYPE: " + shallowCopy.getType());
			System.out.println("Copy  TYPE: " + copy.getType());
			System.out.println("Original  Windows: " + shallowCopy.getWind());
			System.out.println("Copy  Windows: " + copy.getWind());

			// ------------------
			System.out.println("//-------------------\n");
			ShallowCopy copy_Mac = (ShallowCopy) shallowCopy1.clone();
			System.out.println("Original Macintosh: " + shallowCopy1);
			System.out.println("Copy Macintosh: " + copy_Mac);
			System.out.println("Original  TYPE: " + shallowCopy1.getType());
			System.out.println("Copy  TYPE: " + copy_Mac.getType());
			System.out.println("Original  Macintosh: " + shallowCopy1.getWind());
			System.out.println("Copy  Macintosh: " + copy_Mac.getWind());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}