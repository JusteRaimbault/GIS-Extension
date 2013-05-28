
package org.myworldgis.io.dxf;

import org.kabeja.dxf.*;
import org.kabeja.parser.*;
import org.kabeja.parser.ParseException;

import java.util.List;

/**
 * @author Raimbault Juste <br/> <a href="mailto:juste.raimbault@polytechnique.edu">juste.raimbault@polytechnique.edu</a>
 *
 */
public class DXFFileReader {

	
	
	
	
	public static void test(DXFPolyline pline) {
	    for (int i = 0; i < pline.getVertexCount(); i++) {
			    
	     DXFVertex vertex = pline.getVertex(i);
	     System.out.println(vertex);
	    }
	  }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {


		   Parser parser = ParserBuilder.createDefaultParser();
		   try {
			   String in = "/Users/Juste/Documents/Complex Systems/SustainableDistrict/Data/Langangen/GIS/langangen_roads/langangen_roads.dxf";//dxffile
			   String layerid = "0";
		       //parse
		       parser.parse(in, DXFParser.DEFAULT_ENCODING);
					
		       //get the documnet and the layer
		       DXFDocument doc = parser.getDocument();
		       DXFLayer layer = doc.getDXFLayer(layerid);

		       //get all polylines from the layer
		       List plines = layer.getDXFEntities(DXFConstants.ENTITY_TYPE_POLYLINE);
					
		       //work with the first polyline
		       test((DXFPolyline) plines.get(0));

		      } catch (ParseException e) {
			e.printStackTrace();
		      }	
		  }

		  
		
}
