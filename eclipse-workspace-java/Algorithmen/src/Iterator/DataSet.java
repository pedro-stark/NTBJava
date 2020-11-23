package Iterator;

import java.util.Iterator;

public class DataSet implements Iterable<String> {
 
 
    private String myData[] = {"1", "2", "3", "4"};
 
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        Iterator<String> iterator = dataSet.iterator();
        while (iterator.hasNext()) {
            String nextValue = iterator.next();
            System.out.println("The next value with Iterator is: " + nextValue);
        }
 
        for (String nextValue : dataSet) {
            System.out.println("The next value with the for Loop is: " + nextValue);
        }
    }
 
 
    @Override
    public Iterator<String> iterator() {
        return new DataSetIterator();
    }
 
    private class DataSetIterator implements Iterator {
        private int position = 0;
 
        public boolean hasNext() {
            if (position < myData.length)
                return true;
            else
                return false;
        }
 
        public String next() {
            if (this.hasNext())
                return myData[position++];
            else
                return null;
        }
 
        @Override
        public void remove() {
        	
        }
    }
 
}