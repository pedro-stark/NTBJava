package src.GanzzahlenLoesung;
/* Basiswechsel

	int[] zahlen = new int[10];
	zahlen[index] = 5;
----
	ArrayList<Integer> zahlen = new ArrayList<>();
	zahlen.add(5);
----

 1235 in Ziffern aufspalten
 - 1235 / 1000 -> 1 Rest 1235 % 1000 -> 235
 - 235 / 100 -> 2 Rest 35
 - 35 / 10 -> 3 rest 5
 - 5 / 1 -> 5
 
 Integer.MAX_VALUE 2'xxx'xxx'xxx -> Start mit 10^9
 leading zeros unterdrücken
*/