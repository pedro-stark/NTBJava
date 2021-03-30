package JSON;

import com.fasterxml.jackson.core.io.*;
//import com.fasterxml.jackson.core.io.JsonStringEncoder;
public class Test {

	JsonStringEncoder j;
	
	String json = "abc\"\"def";
	
	public Test() {
		j = new JsonStringEncoder();
		// = j.encodeAsUTF8("{		    \"glossary\": {	        \"title\": \"example glossary\",			\"GlossDiv\": {	            \"title\": \"S\",				\"GlossList\": {	                \"GlossEntry\": {	                    \"ID\": \"SGML\",						\"SortAs\": \"SGML\",						\"GlossTerm\": \"Standard Generalized Markup Language\",						\"Acronym\": \"SGML\",						\"Abbrev\": \"ISO 8879:1986\",						\"GlossDef\": {	                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",							\"GlossSeeAlso\": [\"GML\", \"XML\"]	                    },						\"GlossSee\": \"markup\"	                }	            }	        }	    }	}");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
