/* -----------------------
     Simple KMIP-Decoder
   ----------------------- */


/*  Computerkommunikation 2019/2020, Prof. Rene Pawlitzek, NTB  */


package KMIP;


import java.util.HashMap;
import java.util.Map;


public class DecoderLoes {
	

	/* valid KMIP request for generating an AES key */
	private static final byte[]  code = javax.xml.bind.DatatypeConverter.parseHexBinary (
			"42007801000001204200770100000038420069010000002042006A02000000040000000100000000" + 
			"42006B0200000004000000000000000042000D0200000004000000010000000042000F01000000D8" + 
			"42005C0500000004000000010000000042007901000000C042005705000000040000000200000000" + 
			"42009101000000A8420008010000003042000A070000001743727970746F6772617068696320416C" + 
			"676F726974686D0042000B05000000040000000300000000420008010000003042000A0700000014" + 
			"43727970746F67726170686963204C656E6774680000000042000B02000000040000008000000000" + 
			"420008010000003042000A070000001843727970746F67726170686963205573616765204D61736B" + 
			"42000B02000000040000000C00000000");
	
	/* String */
	private static final byte[] code2 = javax.xml.bind.DatatypeConverter.parseHexBinary (
			"42000A070000001743727970746F6772617068696320416C" + 
			"676F726974686D00");
	
	/* Tag, Tag */
	private static final byte[] code3 = javax.xml.bind.DatatypeConverter.parseHexBinary (
			"42006A02000000040000000100000000" + 
			"42006B02000000040000000000000000");
	
	/* Structure with Tag, Tag */
	private static final byte[] code4 = javax.xml.bind.DatatypeConverter.parseHexBinary (
			"420069010000002042006A02000000040000000100000000" + 
			"42006B02000000040000000000000000");
	
	/* Structure in Structure */
	private static final byte[] code5 = javax.xml.bind.DatatypeConverter.parseHexBinary (
	     "4200770100000038420069010000002042006A02000000040000000100000000" + 
	     "42006B0200000004000000000000000042000D02000000040000000100000000");
	
	

	private Map<Integer, String>  tagTable        = new HashMap<Integer, String>();
	private Map<Integer, String>  typeTable       = new HashMap<Integer, String>(); 
	private Map<Integer, String>  usageMaskTable  = new HashMap<Integer, String>();
	private Map<Integer, String>  operationTable  = new HashMap<Integer, String>();
	private Map<Integer, String>  objectTypeTable = new HashMap<Integer, String>();
	private Map<Integer, String>  cryptoAlgoTable = new HashMap<Integer, String>();
	
	private Map<Integer, Map<Integer,String>> tagEnumTable     = new HashMap<Integer, Map<Integer, String>>();
	private Map<String, Map<Integer,String>> attrEnumTable = new HashMap<String, Map<Integer, String>>();
	
	
	public DecoderLoes () {
		// init lookup tables
		initTagLookupTable ();
		initTypeLookupTable ();
		initUsageMaskTable ();
		initOperationTable ();
		initObjectTypeTable ();		
		initCryptoAlgoTable ();
		initEnumTable ();
		initAttrEnumTable ();
	} // Decoder
	
	
	private void initTagLookupTable () {
		tagTable.put (0x420078, "Request Message");
		tagTable.put (0x420077, "Request Header");
		tagTable.put (0x420069, "Protocol Version");
		tagTable.put (0x42006A, "Protocol Version Major");
		tagTable.put (0x42006B, "Protocol Version Minor");
		tagTable.put (0x42000D, "Batch Count");
		tagTable.put (0x42000F, "Batch Item");
		tagTable.put (0x42005C, "Operation");
		tagTable.put (0x420079, "Request Payload");
		tagTable.put (0x420057, "Object Type");
		tagTable.put (0x420091, "Template-Attribute");
		tagTable.put (0x420008, "Attribute");
		tagTable.put (0x42000A, "Attribute Name");
		tagTable.put (0x42000B, "Attribute Value");
	} // initTagLookupTable
	
	
	private void initTypeLookupTable () {
		typeTable.put (0x01, "Structure");
		typeTable.put (0x02, "Integer");
		typeTable.put (0x03, "Long Integer");
		typeTable.put (0x04, "Big Integer");
		typeTable.put (0x05, "Enumeration");
		typeTable.put (0x06, "Boolean");
		typeTable.put (0x07, "Text String");
		typeTable.put (0x08, "Byte String");
		typeTable.put (0x09, "Date-Time");
		typeTable.put (0x0A, "Interval");
	} // initTypeLookupTable
	
	
	private void initUsageMaskTable () {
		usageMaskTable.put (0x00000001, "Sign");
		usageMaskTable.put (0x00000002, "Verify");
		usageMaskTable.put (0x00000004, "Encrypt");  
		usageMaskTable.put (0x00000008, "Decrypt");
	} // initUsageMaskTable
	
	
	private void initOperationTable () {
		operationTable.put (0x00000001, "Create");
		operationTable.put (0x00000002, "Create Key Pair");
		operationTable.put (0x00000003, "Register");
		operationTable.put (0x00000004, "Re-key");
	} // initOperationTable
	
	
	private void initObjectTypeTable () {
		objectTypeTable.put (0x00000001, "Certificate");
		objectTypeTable.put (0x00000002, "Symmetric Key");
		objectTypeTable.put (0x00000003, "Public Key");
		objectTypeTable.put (0x00000004, "Private Key");
	} // initObjectTypeTable
	
	
	private void initCryptoAlgoTable () {
		cryptoAlgoTable.put (0x00000001, "DES");
		cryptoAlgoTable.put (0x00000002, "3DES");
		cryptoAlgoTable.put (0x00000003, "AES");
		cryptoAlgoTable.put (0x00000004, "RSA");
	} // initCryptoAlgoTable
	
	
	private void initEnumTable () {
		tagEnumTable.put (0x42005C, operationTable);
		tagEnumTable.put (0x420057, objectTypeTable);
	} // initEnumTable
	
	
	private void initAttrEnumTable () {
		attrEnumTable.put ("Cryptographic Algorithm", cryptoAlgoTable);
	} // initAttrEnumTable
	
	
	private int fromByteArray1 (byte[] bytes, int pos) {
    return (bytes[pos] & 0xFF);
  } // fromByteArray1
	
	
	private int fromByteArray3 (byte[] bytes, int pos) {
    return (bytes[pos] & 0xFF) << 16 | (bytes[pos + 1] & 0xFF) << 8 | (bytes[pos + 2] & 0xFF);
  } // fromByteArray3
	
	
	private int fromByteArray4 (byte[] bytes, int pos) {
    return bytes[pos] << 24 | (bytes[pos + 1] & 0xFF) << 16 | (bytes[pos + 2] & 0xFF) << 8 | (bytes[pos + 3] & 0xFF);
  } // fromByteArray4

	
	private String getEnumValue (int tag, int enumCode) {
		Map<Integer,String> enumTable = tagEnumTable.get(tag);
		if (enumTable != null) {
			String value = enumTable.get(enumCode);
			if (value != null)
				return value;
		} // if
 		return "" + enumCode;
	} // getEnumValue
	
	
	private String getAttrEnumValue (String attributeName, int enumCode) {
		Map<Integer,String> enumTable = attrEnumTable.get (attributeName);
		if (enumTable != null) {
			String value = enumTable.get (enumCode);
			if (value != null)
				return value;
		} // if
		return "" + enumCode;
	} // getAttrEnumValue
	
	
	private String getUsageMask (int value) {
		StringBuffer mask = new StringBuffer ("{");
		for (Integer key : usageMaskTable.keySet()) {
			if ((key & value) != 0) {
				String str = usageMaskTable.get (key);
				mask.append (" ").append (str);
			} // if
		} // for
		mask.append(" }");
		return mask.toString();
	} // getUsageMaks
	
	
	public void run (byte[] code, int pos, int maxLength, String indent) throws Exception {
//  System.out.println ("Pos: " + pos + " Length: " + maxLength);
		String attributeNameValue = null;
		int maxPos = pos + maxLength;
		while (pos < maxPos) {
		
			// tag
		  int tagCode = fromByteArray3 (code, pos);
		  String tagHex = Integer.toHexString(tagCode);
		  String tag = tagTable.get(tagCode);
		  System.out.print (indent + "Tag: (0x" + tagHex + ") " + (tag != null ? tag : "?"));
		  pos += 3;
		
		  // type
		  int typeCode = fromByteArray1 (code, pos);
		  String typeHex = Integer.toHexString(typeCode);
		  String type = typeTable.get(typeCode);
		  System.out.print (", Type: (0x" + typeHex + ") " + (type != null ? type : "?"));
		  pos += 1;
		
		  // length
		  int length = fromByteArray4 (code, pos); 
		  System.out.print (", Length: " + length);
		  pos += 4;
		
		  // value
			switch (typeCode) {
			
			  case 0x01: // Structure
			  	System.out.println ();
				  run (code, pos, length, indent + "    ");  // Recursion
				  pos += length;
				  break;
				  
			  case 0x02: // Integer
				  int intVal = fromByteArray4 (code, pos);
				  int intVal2 = fromByteArray4 (code, pos + 4); // Padding
			  	if ("Cryptographic Usage Mask".equals(attributeNameValue)) {
			  		String tmp = "0b" + Integer.toBinaryString(intVal);
			  		System.out.println (", " + intVal + " = " + tmp + " = " + getUsageMask (intVal));
			  	} else {
				    System.out.println (", Integer Value: " + intVal);
			  	} // if
				  pos += 8;
				  break;
				 
			  case 0x05: // Enumeration
				  int enumCode = fromByteArray4 (code, pos);
				  int enumCode2 = fromByteArray4 (code, pos + 4); // Padding
				  String enumValue = "";
				  if (tagCode == 0x42000b) {  // Attribute Value
				  	enumValue = getAttrEnumValue (attributeNameValue, enumCode);
				  	attributeNameValue = null;
				  } else {
				    enumValue = getEnumValue (tagCode, enumCode);
				  } // if
			    System.out.println (", Enumeration Value: " + enumValue);
				  pos += 8;
				  break;
				  
			  case 0x07: // Text String
				  String textVal = new String (code, pos, length, "UTF-8");
				  System.out.println (", String: " + textVal);
				  if (tagCode == 0x42000a) { // Attribute Name
				  	attributeNameValue = textVal;
				  	// System.out.println ("Stored Attribute Name: " + attributeNameValue);
				  } // if				  
				  pos += ((length + 8 - 1) / 8) * 8;
				  break;
				  
				default:
					System.out.println (", Unknown Type: 0x" + typeHex);
					throw new Exception ();
				 
			 } // switch	  
		} // while
	} // run
	
	
	public static void main (String[] args) {
		try {
      DecoderLoes decoder = new DecoderLoes ();
  		System.out.println ("Decoding ...");    
      decoder.run (code, 0, code.length, "");
  		System.out.println ("Finished");      
		} catch (Exception e) {
			e.printStackTrace();
		} // try
	} // main
	
	
} // Decoder


/* ----- End of File ----- */