import java.util.ArrayList;

public class Exercise19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);

    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }
  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
	  int count = 0;
	  int index = 0;
	  
	  while (count < list.size()) {
		  while (index < list.size()) {
			  if (list.get(count) == list.get(index)) {
				  list.remove(index);
			  }
			  index++;
		  }
		  count++;
	  }
	  return list;
  }
}