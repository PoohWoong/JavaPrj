
import java.util.Random;

public class StudySeat {

	public static void main(String[] args) {
		Random rand= new Random();
		int num=24;
		int[] arr= new int[num];
		int[] refarr = new int[num];
		
		long start=System.currentTimeMillis();
		
		for(int i=0;i<num;i++)
			refarr[i]=i+1;
		
		/*int cnt=0;  // ��ġ�¼��� �ٽ� �̱� - ����ð��� �ξ� ��������, �迭���� ����
		��������:
		while(cnt<num){
			arr[cnt]=rand.nextInt(num)+1;
			for(int j=0;j<cnt;j++)
				if(arr[cnt]==arr[j])
					continue ��������;
			cnt++;	
		}*/
		
		for(int i=0; i<num;i++){
			int flag=0;
			arr[i]=refarr[rand.nextInt(num-i)];
			for(int j=0; j<num-i;j++){
				if(arr[i]==refarr[j])
					flag=1;
				else if(flag==1)
					refarr[j-1]=refarr[j];
			}
		}
		
		for(int i=0; i<num;i++)
			System.out.printf("%d. %d��\n",i+1, arr[i]); 
		/*for(int i=0; i<24;i++)  //��ȣ��� ���Դµ�, �̰� 5�� ���� ������
			System.out.printf("%d. %d��\n",i+1, arr[i]%5+1);*/
		
		long end = System.currentTimeMillis();
		System.out.println();
		
		System.out.println("����ð�: "+ (end-start)/1000.0);
		
	}

}
