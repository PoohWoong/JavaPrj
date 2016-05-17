public class StarProgram {

	public static void main(String[] args) {
		for(int y=1;y<=20;y++){
			for(int x=1;x<=20;x++)
				if(y<=10 && y>x-2 && y>-x+12)
					System.out.print("¡Ú");
				else
					System.out.print("¡Û");
			
			System.out.println();
		}
	}
}