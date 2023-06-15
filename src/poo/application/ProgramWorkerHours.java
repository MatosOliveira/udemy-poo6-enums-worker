/**
 * 
 */
package poo.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import poo.entities.Department;
import poo.entities.HourContract;
import poo.entities.Worker;
import poo.entities.enuns.WorkerLevel;

/**
 * @author Matos
 *
 */
public class ProgramWorkerHours {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String department = sc.nextLine();
		
		System.out.println("Enter worker data: ");
		
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("Base salary: ");
		double salary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), salary, new Department(department));
		
		System.out.print("How many contracts to this worker? ");
		int qtde = sc.nextInt();
		
		//Vincula informacoes do contrato ao trabalhador
		for (int i = 1; i <= qtde; i++) {

			System.out.println("Enter contract #" + i + " data: ");
			
			System.out.print("Date (DD/MM/YYYY): ");
			Date dateContract = sdf.parse(sc.next());
			
			System.out.print("Value per hour: ");
			double valueHours = sc.nextDouble();

			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(dateContract, valueHours, hours);
			worker.addContract(contract);

		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();

	}

}
