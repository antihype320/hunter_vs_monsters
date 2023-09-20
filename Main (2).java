import java.util.Scanner;
import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {
		int[] monsters = new int[] {24, 52, 13, 76, 48};
		System.out.println(Arrays.toString(monsters));
		//массив с монстрами, числа обозначают колличество жизней у монстра
		
		
		while(monsters[0] != 0 | monsters[1] != 0 | monsters[2] != 0 | monsters[3] != 0 | monsters[4] != 0) {
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("Сколько жизней снимет выстрел охотника?");
		    int shot = scanner.nextInt();
		    //пользователь вводит число, которое обозначается вытсрелом охотника
		    
		    Arrays.sort(monsters);
		    String monstersString = Arrays.toString(monsters);
		    //сортируем массив по возрастанию 
		        
		    
		    int index_max = monsters.length - 1;
		    int max = monsters[index_max];
		    //находим число с наибольшим запасом здоровья

		    int rew = max - shot;  //выстрел уменьшает здоровье монстра
		    monsters[index_max] = rew;
		    if(rew <= 0) {
		        monsters[index_max] = 0;
		        System.out.println(Arrays.toString(monsters));
		    }else{
		        System.out.println(Arrays.toString(monsters));   
		    }
		    
		   
		    
	        }   
		System.out.println("Охотник перебил всех монстров.");    
		//конец программы    
		    
		}
		
		
	}

