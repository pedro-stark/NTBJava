package src.Ganzzahlen;
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
		
		//Geben Sie aus mit dem Format-Befehl!
		
		System.out.format("0x%x", ~-1); System.out.println();
		
		//2 bis 8 TODO
	
	}

}
