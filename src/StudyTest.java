import java.util.Random;

public class StudyTest {

   public static void main(String[] args) {
      Random rand = new Random();
      
      int[] lotto = new int[6];
      
      for(int i=0; i<6; i++) //�� �ֱ�����
         lotto[i] = rand.nextInt(45)+1;
      
      for(int k=0; k<6; k++)//���
         System.out.println("lotto["+k+"]���� �� : "+ lotto[k]);
      
      System.out.println("");
      
      //�ߺ�
      for (int i = 0; i < 5; i++) {
         for (int j = i+1; j <=5; j++) {
            if (lotto[i] == lotto[j]) {
               lotto[i] = rand.nextInt(45)+1;
               System.out.println("lotto["+i+"] �� �ߺ�");
               System.out.println("");
            }
         }
      }
      
      
      for(int i =0; i<6; i++)//���
         System.out.println("lotto["+i+"]���� �� : "+ lotto[i]);
      
      System.out.println("");
      
      //�����ϱ�(��������) -��������
      for (int j = 0; j < 5; j++) {
         for (int i = 0; i < 5 - j; i++) {
            if (lotto[i] > lotto[i + 1]) {
               int temp = lotto[i];
               lotto[i] = lotto[i + 1];
               lotto[i + 1] = temp;
            }
         }
      }
      
      
      
            for(int i =0; i<6; i++)//���
         System.out.println("lotto["+i+"]���� �� : "+ lotto[i]);
   }

}