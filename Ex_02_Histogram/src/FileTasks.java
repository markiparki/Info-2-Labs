import java.io.*;

public class FileTasks {

	public static void main(String[] args) {
		File testFile = new File("TestFile");
		
		characterFrequenciesToFile(testFile, new File("Frequencies"), true);
	}

	/**
	 * Counts the appearance (frequencies) of characters in a certain file and prints the results to another one.
	 * @param readFile : The file object of the file we want to create a frequency table from.
	 * @param printFile : The file object we want to print the frequency table to.
	 * @param histogram : If true, the statistics will be shown as a histogram.
	 */
	public static void characterFrequenciesToFile(File readFile, File printFile, boolean histogram) {
		try {
			FileInputStream fis = new FileInputStream(readFile);
			int ascii[] = new int[126];
			String fileContent = "";
			
			//Count all the characters and save the result to the array.
			while (fis.available() > 0) {
				int current = fis.read();
				if(current <= 126)
					ascii[current]++;
			}
			
			if(!histogram) {
				//Make a String out of the results
				for(int i = 0; i < ascii.length; i++) {
					if(ascii[i] > 0 && i != 10) {
						fileContent = fileContent + "" + (char) i + ": " + ascii[i] + "\n";
					}
				}
			}else {
				//Make a String out of the results as a histogram
				for(int i = 0; i < ascii.length; i++) {
					if(ascii[i] > 0 && i != 10) {
						fileContent = fileContent + "" + (char) i + " : " + createStars(ascii[i]) + "\n";
					}
				}
			}
				
			writeStringToFile(fileContent, printFile);

			fis.close();
		} catch (IOException e) {}
	}
	
	/**
	 * Reads and prints the content of a file.
	 * @param file : The object of the file.
	 */
	public static void readFromFileAndPrint(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			int current;
			
			while (fis.available() > 0) {
				current = fis.read();
				System.out.print(current);
			}

			fis.close();
		} catch (IOException e) {}
	}
	
	/**
	 * Prints a single character to a certain file.
	 * @param c : The character to be written.
	 * @param file : The file object of the file.
	 */
	public static void writeCharToFile(char c, File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(c);
			fos.close();
		}catch(IOException io) {}
	}
	
	/**
	 * Writes a String to a File.
	 * @param text : The text that should be written.
	 * @param file : The object of the file.
	 */
	public static void writeStringToFile(String text, File file) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(text);
			bw.close();
		}catch(IOException io) {}
	}
	
	/**
	 * Creates a File to a certain path.
	 * @param path : The complete path including file name.
	 */
	public static void createFile(String path) {
		File newFile = new File(path);
		try {
			if(newFile.createNewFile() == false)
				System.out.println("File already exists.");
				
		}catch(IOException io) {}
	}
	
	/**
	 * Creates a String with a certain amount of '*' (stars) and returns it
	 * @param amount : The amount of stars
	 */
	private static String createStars(int amount) {
		String stars = "";
		for(int i = 0; i < amount; i++)
			stars = stars + "*";
		
		return stars;
	}
}