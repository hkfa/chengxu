package shili;


import java.util.ArrayList;
import java.util.List;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;


public class Ansj {
	int k=3;
	int instanceNumber=150;
	int fieldCount=5;
	int times=1;
	public float[][] data;
	public float[][]classData;
	public ArrayList<ArrayList<Integer>>result;
	public ArrayList<Integer> noises;
	public Ansj(){
		float[][]data=new float[instanceNumber][fieldCount+1];
		float[][]classData=new float[k][fieldCount];
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>> (k);
		ArrayList<Integer>noises=new ArrayList<Integer>();
	}
 
	public void cluster(){
		double t=2.0;
		normalize();
		
		boolean needUpdataInitials=true;
		int times=1;
		
		while(needUpdataInitials){
			needUpdataInitials=false;
			result.clear();
			
			findInitials();
			firstClassify();
			for(int i = 0;i < result.size();i++){
				if(result.get(i).size()<instanceNumber/Math.pow(k, t)){
					needUpdataInitials=true;
					noises.addAll(result.get(i));
				}
			}
			adjust();

		}	
	}
	public void normalize(){
		float[]max=new float[fieldCount];
		for(int i=0;i<instanceNumber;i++){
			for(int j=0;j<fieldCount;j++){
				if(data[i][j] > max[j])
					max[j] = data[i][j];
			}

		}
		for(int i = 0;i < instanceNumber;i++){
			for(int j = 0;j < fieldCount;j++){
				data[i][j] = data[i][j]/max[j];
			}
		}

	}

	public void findInitials(){
		int i,j,a,b;
		i= j = a = b = 0;
		float maxDis = 0;
		int alreadyCls = 2;
		ArrayList<Integer> initials = new ArrayList<Integer>();
		for (; i < instanceNumber; i++){
			j=i+1;
			for(;j<instanceNumber;j++){
				float newDis=calDis(data[i],data[j]);
				if (newDis>maxDis) {
					a = i;
					b = j;
					maxDis = newDis;
				}
			}
		}
		initials.add(a);
		initials.add(b);
		classData[0]=data[a];
		classData[1]=data[b];
		ArrayList<Integer> resultOne = new ArrayList<Integer>();
		ArrayList<Integer> resultTwo = new ArrayList<Integer>();
		resultOne.add(a);
		resultTwo.add(b);
		result.add(resultTwo);
		result.add(resultOne);
		while(alreadyCls<k){
			i = j = 0;
			float maxMin = 0;
			int newClass = -1;
			for (; i < instanceNumber; i++) {
				float min=0;
				float newMin=0;
				for (j = 0; j < alreadyCls; j++) {
					newMin = calDis(data[i], classData[j]);
					if (min == 0 || newMin < min)
						min = newMin;
				}
				if (min > maxMin) {
					maxMin = min;
					newClass = i;
				}
			}
			initials.add(newClass);
			classData[alreadyCls++] = data[newClass];
			ArrayList<Integer> rslt = new ArrayList<Integer>();
			rslt.add(newClass);
			result.add(rslt);

		}
	}





	public float calDis(float[]vector1,float[]vector2){
		double dis=0;
		int i=0;
		for(;i<vector1.length;i++)
			dis += Math.pow(vector2[i] - vector1[i], 2);
			dis = Math.pow(dis, 0.5);
			return (float) dis;
		
	}
	public void firstClassify(){
		for (int i = 0; i < instanceNumber; i++) {
			float min = 0f;
			int clsId = -1;
			for (int j = 0; j < 3; j++){
				float newMin = calDis(classData[j], data[i]);
				if (clsId == -1 || newMin < min) {
					clsId = j;
					min = newMin;

				}
			}
		}

	}
	public void adjust(){
		boolean change=true;
		int times=1;
		while(change){
			change=false;
			for(int i=0;i<k;i++){
				ArrayList<Integer> cls=result.get(i);
				float[]newMean=new float[fieldCount];
				for(Integer index:cls){
					for (int j = 0; j < fieldCount; j++)
						newMean[j] += data[index][j];
				}
				for(int j=0;j<fieldCount;j++){
					newMean[j]=newMean[j]/cls.size();
				}
				if(!compareMean(newMean,classData[i])){
					classData[i]=newMean;
					change=true;
				}
				
			}
		}
		
	}
	
			
	
	public boolean compareMean(float[]a,float[]b){
		if(a.length!=b.length)
			return false;
		for(int i=0;i<a.length;i++){
			if (a[i] > 0 && b[i] > 0 && a[i] != b[i]) {
				return false;
			
		}
			
		}
		return true;

	}

}

