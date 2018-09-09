import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class lab1{
  public static void main(String[] args) {
    int[] breakfast = new int[7]; //This is the array storage for breakfast for 7 days.
    int[] lunch = new int[7]; //This is the array storage for lunch for 7 days.
    int[] dinner = new int[7]; //This is the array storage for dinner for 7 days.

    readCaloriesFile(breakfast, lunch, dinner); //calling the methods.

				printBLDAverageCalories(breakfast, lunch, dinner);
				System.out.println();

				printDailyCalories(breakfast, lunch, dinner);
  }

  public static void readCaloriesFile(int[] breakfast, int[] lunch, int[] dinner){//method to read the file.
    try {
					Scanner scanner = new Scanner(new File("input.txt")); //this will scan the document input.
					int i = 0;

					while (scanner.hasNextLine()){ //this loop keeps reading the file WHILE has a next line.
						String line = scanner.nextLine();// the String variable keeps rhe line as a string.

						String[] splits = line.split(" ");//the String slipts while it has a space between.
						breakfast[i]=Integer.parseInt(splits[0]); //converts the string into an integer and save it.
						lunch[i]=Integer.parseInt(splits[1]);//converts the string into an integer and save it.
						dinner[i]=Integer.parseInt(splits[2]);//converts the string into an integer and save it.

						i++;
					}
    }

    catch(Exception ex) {
					if(ex instanceof FileNotFoundException)
						System.out.println("File not found");
					else
						System.out.println(ex);
    }
		}

	public static double getWeeklyAvgCalories(int[] weeklyCalories){
		double avg = 0.0;
		for (int i=0; i<7 ;i++) {//for loop designed to sum the arrays per day
			avg = avg + weeklyCalories[i]; //is the sum of every line detected from 0 to 6
		}

		return avg/7;
	}

	public static void printBLDAverageCalories(int[] breakfast, int[] lunch, int[] dinner){
		DecimalFormat df = new DecimalFormat("#.00"); //Decimal format to display two decimal places

		String breakfastAvgCalories = df.format(getWeeklyAvgCalories(breakfast));
		String lunchAvgCalories = df.format(getWeeklyAvgCalories(lunch));
		String dinnerAvgCalories = df.format(getWeeklyAvgCalories(dinner));

		System.out.println("The average consumed per week on breakfast is: " + breakfastAvgCalories);
		System.out.println("The average consumed per week on lunch is: " + lunchAvgCalories);
		System.out.println("The average consumed per week on dinner is: " + dinnerAvgCalories);
	}

	public static void printDailyCalories(int[] breakfast, int[] lunch, int[] dinner){
		int maxCalories = 2250;
		int consumedCalories = 0;
		String[] week ={"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};

		for (int i=0; i<7 ;i++) {//for loop designed to sum the arrays per day
			consumedCalories = breakfast[i] + lunch[i] + dinner[i];

			System.out.println("Your total calories are " + consumedCalories +" on "+ week[i]);
			if(consumedCalories > maxCalories){
				System.out.println("It exceeds the normal amount. Go with a Doctor.");
			} else {
				System.out.println("Stay healthy.");
			}

			System.out.println();
		}
	}
}
