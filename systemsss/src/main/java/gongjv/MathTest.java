package gongjv;


public class MathTest {


	public static void main(String[]args){
		boolean change=true;
		System.out.println("gh");
		while(change){
			System.out.println("hh");
			change=false;//为什么没用
			for(int i=0;i<3;i++){
				if(!(i==2)){
					change=true;//for循环有这么神奇吗?,,当心现在是个死循环!!!!
				}
				System.out.println("chengong");
			}

		}


		//System.out.println(a());


	}
	
}

/*	
 * 
 * 
 * public static double a(){
		double a=3.4;
		double b=3.5;
		double c=0;
		for(int i=0;i<3;i++){		
			c+=a*b;
		}
		return c;
	}
 * 
 * 
 * 	public static int  ClassCount=3;
	public static int FieldCount=2;
 * 
 * 
 * float data[][]=new float[150][5];

		for (int i = 0; i < 4; i++) {

			int clsId = 5;

			data[i][2] = clsId;
			System.out.println(data[i][2]);
		}

 * 
 * 
 * 
 * 
 * double a=50.0;
		double b=2.0;
		double c=Math.pow(a, b);//求平方
		double s=(double)Math.sqrt(a);
		ArrayList<Integer> d=new ArrayList<Integer>();
		int z,x,v;
		z=5;x=4;v=2;
		d.add(z);
		d.add(x);
		d.add(v);
		System.out.println(d);
		d.clear();//清空list中放的东西
		System.out.println(d);

		int [][]classData=new int[][]{{1,2},{3,4}};
		for(int i=0;i<classData.length;i++){
			for(int j=0;j<2;j++){
			//System.out.println(classData[j][i]);}
		}


		for (int j=0; j < 5; j++){
			//System.out.println(i);

		}
	}

 */

