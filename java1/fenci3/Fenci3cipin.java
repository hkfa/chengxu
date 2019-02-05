package fenci3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.DicAnalysis;

public class Fenci3cipin {
	private List<String> document=new ArrayList<String>();
	private  List<List<String>>documents;
	private    List<Map<String,Integer>>documentWordsTF;
	public Fenci3cipin(List<String>document){
		this.document=document;
	}
	public List<Map<String,Double>> ecal()throws FileNotFoundException{
		this.spiltWord();
		this.calculateIDF();
		this.calculateTF();
		return null;
	
	}
	private void spiltWord(){
		 documents=new ArrayList<List<String>>();
		 List<String> wordDocument=new ArrayList<String>();
		 Map<String,String>wod=new HashMap<String,String>();
		 for(String string:document){
			 Result spiltLine=DicAnalysis.parse(string);
			 List<Term> terms=spiltLine.getTerms();
			 for(Term t:terms){
				 String a=t.getName();
				 String b=t.getNatureStr();
				 wordDocument.add(a+b);
				wod.put(a, b);
			 }			 			 
		 }
		documents.add(wordDocument);
	}
		private void calculateTF()throws FileNotFoundException{
	
		
		 documentWordsTF=new ArrayList<Map<String,Integer>>();
			 Map<String,Integer> countMap = new HashMap<String,Integer>();
			for(List<String> wordDocument:documents ){
				for(String word:wordDocument){
					if(countMap.containsKey(word)){
						countMap.put(word, countMap.get(word)+1);
					}else{
					countMap.put(word, 1);
					}
				}
			}
			documentWordsTF.add(countMap);

		}
		private void calculateIDF(){
			Map<String,Double> a=new HashMap<String,Double>();
			Map<String,Integer> wordAppear=new HashMap<String,Integer>();
			for(Map<String,Integer> b:documentWordsTF){
				for(String word:b.keySet()){
					
				}
				
				
			}
			
			
		}
		private List<Map<String,Double>> calculateTF_IDF(){
			List<Map<String,Double>> tfidfRes = new ArrayList<Map<String,Double>>();
	       // for(Map<String,Integer> docuementTfMap : docuementTfList ) {
	            Map<String,Double> tfIdf = new HashMap<String,Double>();
	         //   for(String word : docuementTfMap.keySet()) {
	            //    double tfidf = idfMap.get(word) * docuementTfMap.get(word);
	            //    tfIdf.put(word, tfidf);
	          //  }
	           // tfidfRes.add(tfIdf);
	     //   }
	        return tfidfRes;
			
		}
		
}

		
	



