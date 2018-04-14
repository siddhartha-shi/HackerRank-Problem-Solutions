package iOS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Host {
	public String name;
	public int count;

	public Host(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

public class Q08_HostsAndTheTotalNumberOfRequests {

	public static void main(String[] args) {
		// read the string filename
		List<Host> hosts = new ArrayList<Host>();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.nextLine();
		ArrayList<String> readText = new ArrayList<>();
		BufferedReader reader;
		String line;
		try {
			reader = new BufferedReader(new FileReader(filename + ".txt"));
			while ((line = reader.readLine()) != null) {
				// Add all the words split by a ; to the list
				readText.add(line);
			}

			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> host = new ArrayList<>();
		for (String s : readText) {
			String[] temp = s.split(" -");
			if (temp.length > 0) {
				host.add(temp[0]);
			}
		}

		for (String hostName : host) {
			int occurrences = Collections.frequency(host, hostName);
			if (hosts.isEmpty()) {
				hosts.add(new Host(hostName, occurrences));
			} else {
				boolean flug = true;
				for (Host hhhh : hosts) {
					if (hhhh.getName().equals(hostName)) {
						flug = false;
					}
				}
				if (flug) {
					hosts.add(new Host(hostName, occurrences));
				}
			}
		}

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("records_" + filename + ".txt"));
			for (Host host2 : hosts) {
				writer.write(host2.getName() + " " + host2.getCount());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Given filename = " + filename + ".txt" + ", we process the "
				+ "records in " + filename + ".txt" +" and create an output file " + "named records_" + filename + ".txt"
				+ "\ncontaining the " + "following rows:");

		for (Host h : hosts) {
			System.out.println(h.getName() + " " + h.getCount());
		}
	}
}
