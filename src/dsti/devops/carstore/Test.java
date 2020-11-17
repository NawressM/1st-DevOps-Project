package dsti.devops.carstore;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		 CarCRUD carCRUD = new CarCRUD("jdbc:mysql://localhost:3306/carstore?serverTimezone=UTC","nawress","nm116421M");
		 try {
			 //Test get Car
			 Car newCar = carCRUD.getCar("BY232AZ");
			 
			//Test Delete Car
			carCRUD.deleteCar(newCar) ;
			
			//Test Insert Car
			carCRUD.insertCar(newCar) ;
			
			//Test Update Car
			newCar = new Car("BY232AZ", "RENAULT", "CLIO", 10000);
			carCRUD.updateCar(newCar) ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
