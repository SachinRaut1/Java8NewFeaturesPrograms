	package Sream_Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamOperation {


	public static void main(String[] args)
	{
		List<Employee> employees=emplist();

		//stream methods /operations
		//req: get all employee name as list
		List<String> empNames=new ArrayList<>();
		for (Employee emp : employees)
		{
			empNames.add(emp.getName());
		}
		System.out.println(empNames);

		System.out.println(".....................................................................");
	//map()
		//=>Returns a stream consisting of the results of applying the givenfunction to the elements of this stream.
	//with stream
	Stream<Employee> empStream = employees.stream();
	//stream pipeline												//source==>empstream  ]
	List<String> allCityNames = empStream.map(emp ->emp.getCity())            //intermediate operation]-->stream pipeline
	.toList();                                   //terminal operation     ]

	System.out.println(allCityNames);

	System.out.println("........................................................................");

	//filter and //map
	//emp names and age > 25
	//we cannot reuse stream object second time
	//terminal operation will provide a result
	//but an intermidiate operation will not provide resut
	List<String> empNameAge = employees.stream()
			.filter(emp ->emp.getAge() > 25) //IO
			.map(emp ->emp.getName())		//IO
			.toList();						//tO
	System.out.println(empNameAge);

	System.out.println(".........................................................................");

	//print all city names of employee
	//distinct()
	//forEach
	employees.stream()
			.map(emp ->emp.getCity())
			.distinct()
			.toList()
			.forEach(System.out::println);

	System.out.println(".........................................................................");

	//get count of  employee whose salary is > 30k
	//count()
	long countofemp = employees.stream()
				.filter(emp ->emp.getSalary() > 30000)
				.count();
	System.out.println(countofemp);

	System.out.println("......................................................................");

	//get first 3 employee obj as a list
	//limit()

	List<Employee> first3emp = employees.stream()
			.limit(3)
			.toList();
	System.out.println(first3emp);

	System.out.println("......................................................................");
	//skip()
	//skip first 3 employee and i want to collect other employee
	List<Employee> Skipfirst3emp = employees.stream()
			.skip(4) //exclude first 4 employee from the list of object inside stream object
			.toList();      //and process other objects and creates new stream object

	System.out.println(Skipfirst3emp);

	System.out.println("......................................................................");

	//anymatch() =>terminal operation
	//varify any emp < 18
	boolean anyMatch = employees.stream()
	.anyMatch(emp ->emp.getAge() <=23);
	System.out.println(anyMatch);

	//allMatch()
	//every emp join after 2010 or not

	boolean allMatch=employees.stream()
	.allMatch(emp ->emp.getYearOfJoining() < 2021);
	System.out.println(allMatch);

	//any one match return :false
	//no one matching :true
	//nonematch()

	boolean noneMatch = employees.stream()
	.noneMatch(emp ->emp.getSalary() < 10000);
	System.out.println(noneMatch);
	System.out.println("......................................................................");

	//findAny()
	//get one value frome out 	of one value
	Employee empobj = employees.stream()
	.findAny().get();
	System.out.println(empobj);

	//findfirst()
	//it always return first emement from the stream
	Employee empFirst = employees.stream()
	.findFirst().get();
	System.out.println(empFirst);

	System.out.println("......................................................................");

	//sorted()
	//get emp id in sorting order
	List<Integer> sorted = employees.stream()
	.map(emp ->emp.getId())
	.sorted()
	.toList();
	System.out.println(sorted);
	System.out.println("......................................................................");

	//sorted() with comparator
	//define sorting baased on employee Id's
	//sort emp objects

	List<Employee> sortedempObjectlist = employees.stream()
	.sorted((e1,e2)->
	{
		return e1.getId() -e2.getId();
	}).toList();
	System.out.println(sortedempObjectlist);

	System.out.println("......................................................................");

	//min salary emp details
	Employee empsalMIN = employees.stream()
	.min((e1,e2)->(int)(e1.getSalary() -e2.getSalary()))
	.get();
	System.out.println(empsalMIN);

	System.out.println("......................................................................");


	//max salary emmp details
	Employee maxsalary = employees.stream()
	.max((e1,e2)->(int)(e1.getSalary() -e2.getSalary()))
	.get();
	System.out.println(maxsalary);
	
	System.out.println("......................................................................");

	//Average()
	//doubleStream()=stream contain only double value
	
	
	//find average salary out of all the employe
	double AverageSal_asDouble = employees.stream()
	.mapToDouble(employee ->employee.getSalary())
	.average().getAsDouble();
	
	System.out.println("AverageSal_asDouble: "+AverageSal_asDouble);

	//mapTOLong: long stream
	//MapTOInt:integerStream
	double AverageAge = employees.stream()
			.mapToInt(employee ->employee.getAge())
			.average().getAsDouble();
			
			System.out.println("AverageAge :=>"+AverageAge);


			
			System.out.println("................peek.....................................");
			
			//peek() method.
			//out of all employees find whose date of joining > 2021
			//track how many employee processed
			
			List<Employee> empdetails_list = employees.stream()
			.filter(employee -> employee.getYearOfJoining() >2021)
			.peek(System.out::println)
			.toList();
			System.out.println(empdetails_list);

			System.out.println("................collectors.....................................");

			//collect()
			//collectors class  it is simple utility class
			
			//collect all emp names as a list, whose age > 25
			
			List<String> namescollect = employees.stream()
			.filter(employee -> employee.getAge()>25)
			.map(Employee::getName)
			.collect(Collectors.toList());
			
			System.out.println(namescollect);
			
			System.out.println(".....................................................");

			//distinct() 
			//unique department names
			List<String> depart = employees.stream()
			.map(Employee::getDepartment)
			.toList();
			
			System.out.println(depart);
			
			System.out.println("................toMap.....................................");
			//collect employes id and their salary as map
			Map<Integer, Double> empIdandSal = employees.stream()
			.collect(Collectors .toMap(Employee::getId, Employee::getSalary));
			System.out.println(empIdandSal);
			System.out.println("................groupingBy.....................................");	
			//groupingBy()
			//get Avg sal from each department
			Map<String, Double> avgSalDepartwise = employees.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment,
					Collectors.averagingDouble(Employee::getSalary))
					);
			System.out.println(avgSalDepartwise);
			
			System.out.println("................count.....................................");	

			//count()
			//get count of employees genderwise
			
			Map<String, Long> countempgenderwise = employees.stream()
			.collect(Collectors.groupingBy(
					Employee::getGender,
					Collectors.counting()
					));
			System.out.println(countempgenderwise);
			
			System.out.println("...................summing()...........................");

			//summing()
			//sumerizing()
			//summing all employees salary
			
			System.out.println(employees.stream().collect(Collectors.summingDouble(Employee::getSalary)));

			System.out.println(employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary)));
			
			System.out.println("...................maxby()...........................");
			//finding max age of employees
			//maxBy()
			
			Employee maxAgeemp = employees.stream()
					.collect(Collectors.maxBy((e1,e2)->e1.getAge()-e2.getAge()))
			        .get();
			
			System.out.println(maxAgeemp);
			
			System.out.println("...................maxby()...........................");
			//joining()
			//All department names with delimeters
			String concatjoining = employees.stream()
			.map(Employee::getDepartment)
			.collect(Collectors.joining(":::"));
			System.out.println(concatjoining);
			
	}

	private static List<Employee> emplist() {

List<Employee> emplist=new ArrayList<>();

		emplist.add(new Employee(5, "sachin", "pune", 26, "male", "IT", 2021, 45000));
		emplist.add(new Employee(3, "gopal", "sambhajinagar", 24, "male", "transport", 2020, 20000));
		emplist.add(new Employee(1, "sunil", "pune", 28,"male", "IT", 2024,30000));
		emplist.add(new Employee(2, "rohit", "parbhani", 27, "male", "marketing", 2019, 20000));
		emplist.add(new Employee(4, "pranali", "mumbai", 25, "female", "finance", 2021, 45000));
		emplist.add(new Employee(7, "sonali", "lonar", 26, "female", "farmer", 1999, 100000));
		emplist.add(new Employee(10, "gajanan", "mumbai", 30, "male", "sales", 2021, 15000));
		emplist.add(new Employee(9, "kalyani", "sambhajinagar", 27, "female", "IT", 2024, 100000));
		emplist.add(new Employee(6, "sakshi", "thane", 29, "female", "advocate", 2020, 500000));
		emplist.add(new Employee(8, "amruta", "pune", 23, "female", "hr", 2018, 65000));

		return emplist;

	}

}
