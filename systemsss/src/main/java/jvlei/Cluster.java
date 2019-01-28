package jvlei;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Cluster {
	public static void main(String []args)throws IOException{
		int k=10;	
		ComputeTFIDF c=new ComputeTFIDF();
		GetInitPoint g=new GetInitPoint();
		Distance d=new Distance();	
		Map<String,Map<String,Double>> allDocsTFIDF=c.computeTFIDF();
		System.out.println(allDocsTFIDF.size());
		Map<Integer,Map<String,Double>> initPoint=g.getInitPoint(allDocsTFIDF,k);
		//Map<Integer,Map<String,Double>>classfiy=d.clusterNearestPoint(allDocsTFIDF, initPoint);
 		
	}

}
