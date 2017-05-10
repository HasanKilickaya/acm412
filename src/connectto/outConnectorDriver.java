package connectto;

import java.util.ArrayList;

public class outConnectorDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ourConnector o=new ourConnector();
		o.insertItem("hello", "first entry");
		ArrayList<datamodel>d=o.getitems();
		
		for(datamodel d2:d)
		{
			System.out.println(d2.topic);
			System.out.println("!!!!!!");
			System.out.println(d2.getContent());
			System.out.println("-------");
			
		}
	}

}
