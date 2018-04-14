package iOS;

import java.util.LinkedList;
import java.util.Scanner;

public class Q01_SuperStack {
    
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int noCommands = scanner.nextInt();
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < noCommands; ++i)
        {
        	@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
            String[] split = command.split(" ");

            if (split[0].equals("push"))
            {
                int number = Integer.valueOf(split[1]);
                stack.addFirst(number);
            }
            else if (split[0].equals("pop") && stack.size() > 0)
            {
                stack.removeFirst();
            }
            else if (split[0].equals("inc"))
            {
                int count = Integer.valueOf(split[1]);
                int increment = Integer.valueOf(split[2]);

                int lastIndex = stack.size();
                for (int j = lastIndex-count; j < lastIndex; j++)
                {
                	int node = stack.get(j);
                	node += increment;
                	stack.set(j, node);
                }
             }

            PrintTop(stack);
        }
    }

    static void PrintTop(LinkedList<Integer> stack)
    {
        if (stack.size() == 0)
        {
            System.out.println("EMPTY");
        }
        else
        {
            System.out.println(stack.getFirst().toString());
        }
    }
}
