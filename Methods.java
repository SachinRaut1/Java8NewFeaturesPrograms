package Defaults_StaticMethod;

public interface Methods {
	
	void vechicle();
	 default void start() {
		 System.out.println("start the engine");
	}
	 static void gear()
	 {
		 System.out.println("shift the 1st gear");
	 }
	

}
