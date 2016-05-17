import java.util.Random;

public class StudyTest {

   public static void main(String[] args) {
      Random rand = new Random();
      
      int[] lotto = new int[6];
      
      for(int i=0; i<6; i++) //값 넣기위해
         lotto[i] = rand.nextInt(45)+1;
      
      for(int k=0; k<6; k++)//출력
         System.out.println("lotto["+k+"]번의 수 : "+ lotto[k]);
      
      System.out.println("");
      
      //중복
      for (int i = 0; i < 5; i++) {
         for (int j = i+1; j <=5; j++) {
            if (lotto[i] == lotto[j]) {
               lotto[i] = rand.nextInt(45)+1;
               System.out.println("lotto["+i+"] 가 중복");
               System.out.println("");
            }
         }
      }
      
      
      for(int i =0; i<6; i++)//출력
         System.out.println("lotto["+i+"]번의 수 : "+ lotto[i]);
      
      System.out.println("");
      
      //정렬하기(오름차순) -버블정렬
      for (int j = 0; j < 5; j++) {
         for (int i = 0; i < 5 - j; i++) {
            if (lotto[i] > lotto[i + 1]) {
               int temp = lotto[i];
               lotto[i] = lotto[i + 1];
               lotto[i + 1] = temp;
            }
         }
      }
      
      
      
            for(int i =0; i<6; i++)//출력
         System.out.println("lotto["+i+"]번의 수 : "+ lotto[i]);
   }

}