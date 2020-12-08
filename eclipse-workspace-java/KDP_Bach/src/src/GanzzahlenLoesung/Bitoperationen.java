package src.GanzzahlenLoesung;
public class Bitoperationen {

	public static void main(String[] args) {
		/*
		1. ~-1
		2. -1 | 20
		3. 0x00FF0000 & 0x12345678
		4. 0x00FF0000 | 0x12345678
		5. (binär, in Java ungültig) 0b00110101 & 0b00000001 -> 0x53 & 0x1
		6. 0b0011 0101 & 0b0000 0010 -> 0x35 & 0x02 
		7. 0b0011 0101 & 0b0000 0100 -> 0x35 & 0x04
		8. 0b0011 0101 & (1 << 6) -> 0x35 & (1 << 6) 
		*/
		
		//Achtung Ausgabe in Hexadezimal
		
		System.out.format("0x%x", ~-1); System.out.println();
	
		System.out.format("0x%x", -1 | 20); System.out.println();
		
		System.out.format("0x%x", 0x00FF0000 & 0x12345678); System.out.println();
		
		System.out.format("0x%x", 0x00FF0000 | 0x12345678); System.out.println();
		
		System.out.format("0x%x", 0x53 & 0x1); System.out.println();
		
		System.out.format("0x%x", 0x35 & 0x02); System.out.println();
		
		System.out.format("0x%x", 0x35 & 0x04); System.out.println();
		
		System.out.format("0x%x", (1 << 6)); System.out.println();
		
		System.out.format("0x%x", 0x35 & (1 << 6)); System.out.println();
	}

}
