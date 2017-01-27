package org.delta.web.ucase.test.handler;

import java.util.Scanner;

import org.delta.web.ucase.single.JUnitDeltaFlightSearch;
import org.delta.web.ucase.single.JUnitDeltaFlightStatus;
import org.delta.web.ucase.single.JUnitDeltaHotelSearch;

/**
 * @author A.Ajjarani
 * 
 * Handler Class - where the Routes are called & executed independently 
 *
 */
public class BSDeltaWebCaseHandler {

	public static void main(String[] args) {

		System.out.println("Press 1 : Parallel Testing");
		System.out.println("Press 2 : Serial Testing");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();

		if( input == 1){
			callParallel();
		} if(input == 2){
			callSerial();
		}


	}

	private static void callSerial() {
		// Business Case 1 : Flight Search		
		JUnitDeltaFlightSearch JUnitDeltaFlightSearchObj = new JUnitDeltaFlightSearch();
		try {
			JUnitDeltaFlightSearchObj.setUp();
			JUnitDeltaFlightSearchObj.testDeltaFlightSearch();
			JUnitDeltaFlightSearchObj.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// Business Case 2 : Flight Status
		JUnitDeltaFlightStatus JUnitDeltaFlightStatusObj = new JUnitDeltaFlightStatus();
		try {
			JUnitDeltaFlightStatusObj.setUp();
			JUnitDeltaFlightStatusObj.testDeltaFlightStatus();
			JUnitDeltaFlightStatusObj.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// Business Case 3 : Hotel Search
		JUnitDeltaHotelSearch JUnitDeltaHotelSearchObj = new JUnitDeltaHotelSearch();
		try {
			JUnitDeltaHotelSearchObj.setUp();
			JUnitDeltaHotelSearchObj.testDeltaHotelSearch();
			JUnitDeltaHotelSearchObj.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void callParallel() {		
		// To Do
	}

}
