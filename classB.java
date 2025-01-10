package Defaults_StaticMethod;

public class classB implements Methods {

	@Override
	public void vechicle() {
		System.out.println("vechicle started");
		
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		Methods.super.start();
	}

	public static void main(String[] args) {
		Methods.gear();//static
		Methods m=new Methods() {
			
			@Override
			public void vechicle() {
				// TODO Auto-generated method stub
				
			}
		} ;{
		m.start();
		m.vechicle();
			

			
			}
		}

}

