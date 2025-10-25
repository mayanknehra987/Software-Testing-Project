package Assured.restAssuredFramework.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import Assured.restAssuredFramework.pojos.Booking;
import Assured.restAssuredFramework.pojos.BookingDates;
import Assured.restAssuredFramework.pojos.BookingResponse;
import Assured.restAssuredFramework.pojos.Token;
import Assured.restAssuredFramework.pojos.tokenResponse;

public class Payloadmanager {
	//ser and deserlization manage
	static Gson gson;
	public static String createPayloadBookingAsString(){
		Booking booking = new Booking();
		booking.setFirstname("mayank");
		booking.setLastname("nehra1");
		booking.setTotalprice(111);
		booking.setAdditionalneeds("Learning");
		booking.setDepositpaid(true);
		
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2025-02-01");
		bookingdates.setCheckout("2025-04-01");
		
		booking.setBookingdates(bookingdates);
		//convert- java object->json string(byte string)-serialiazation
		gson = new Gson();
		String javaStringPayload = gson.toJson(booking);
		return javaStringPayload;
	}
	public static BookingResponse bookingResponseJava(String responseString){
		gson = new Gson();
		BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
		return bookingResponse;
		
	}
	public static String fullUploadPayloadAsString(){
		Booking booking = new Booking();
		booking.setFirstname("Lokesh");
		booking.setLastname("Braun");
		booking.setTotalprice(1500);
		booking.setAdditionalneeds("Learning");
		booking.setDepositpaid(true);
		
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2024-02-01");
		bookingdates.setCheckout("2024-04-01");
		
		booking.setBookingdates(bookingdates);
		//convert- java object->json string(byte string)-serialiazation
		gson = new Gson();
		String javaStringPayload = gson.toJson(booking);
		return javaStringPayload;
	}
	 
	public static String createTokenAsString(){
		Token token = new Token();
		token.setUsername("admin");
		token.setPassword("password123");
		gson = new Gson();
		String returnToken = gson.toJson(token);
		return returnToken;
	}
	public static tokenResponse getTokenFronJson(String getToken){
		gson = new Gson();
		tokenResponse tokenResponse = gson.fromJson(getToken, tokenResponse.class);
		return tokenResponse;
		
	}
	//create dynamic data
	public String createPayloadBookingAsStringFaker(){
		Faker faker = new Faker();
		Booking booking = new Booking();
		booking.setFirstname(faker.name().firstName());
		booking.setLastname(faker.name().lastName());
		booking.setTotalprice(faker.random().nextInt(100));
		booking.setAdditionalneeds("Learning");
		booking.setDepositpaid(true);
		
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2025-02-01");
		bookingdates.setCheckout("2025-02-01");
		
		booking.setBookingdates(bookingdates);
		//convert- java object->json string(byte string)-serialiazation
		Gson gson = new Gson();
		String javaStringPayload = gson.toJson(booking);
		return javaStringPayload;
	}
	
	
}
