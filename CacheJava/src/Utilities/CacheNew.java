package Utilities;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.ibm.broker.plugin.MbElement;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbGlobalMap;

public class CacheNew {

	//	DECLARE refMap REFERENCE TO InputRoot.XMLNSC.*[1];
	public static Boolean AddGC(MbElement refMap) {
		
		String strMapName = null;
		String strKey = null;
		String strValue = null;
		MbGlobalMap globalMap = null;
		
		
		try {
			
			refMap = refMap.getFirstChild(); // Map1
			strMapName = refMap.getValueAsString(); // key1 , Value 1,... etc
			
			globalMap = MbGlobalMap.getGlobalMap(strMapName); // fetch from existing cache map
			
			
			MbElement elmEntry = refMap.getNextSibling(); 
			
			while (elmEntry != null) {
			    
				 strKey = elmEntry.getFirstChild().getValueAsString();
				 strValue = elmEntry.getValueAsString();
				elmEntry = elmEntry.getNextSibling();
			}
			
			
		} catch (MbException Mbe) {
			// TODO: handle exception
			System.out.println(Mbe.getMessage());
			Mbe.printStackTrace();
			return Boolean.FALSE;
		}
		
		
		return Boolean.TRUE;
		
		
		
		
	}
	
}
