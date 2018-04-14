package iOS;

import java.util.Scanner;

public class Q04_UsernameDisparity {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner;
		Q04_UsernameDisparity sr = new Q04_UsernameDisparity();
		scanner = new Scanner(System.in);
		int no_cases = scanner.nextInt();
		for (int i = 0; i < no_cases; i++) {
			String to_proc = scanner.next();
			sr.solve(to_proc);
		}
	}
	private void solve(String to_proc) {
            String str=to_proc;
            int len=to_proc.length();
            int count=0;
            int total=0;
            for(int i=1;i<len;i++)
            {
                count=0;
                for(int j=i;j<len;j++)
                {
               //     System.out.println(str.charAt(j)+" , "+str.charAt(j-i));
                    if(str.charAt(j-i)==str.charAt(j))
                    {
                        count++;
                    }
                    else
                    {
                        break;
                    }
                }
                total=total+count;
            }
            System.out.println(total+len);
	}

}
