package com.TesDAO;

import com.DAO.basic.*;
import com.DAO.hard.*;
import com.DAO.medium.*;

public class BasicTest {
    public static void main(String[] args) {
        System.out.println("=".repeat(30)+"\n"+"BASIC"+"\n"+"=".repeat(30));
        System.out.println("show all hotel in a given city: "+"\n"+
                ShowAllHotelInGivenCity.showAllHotelInGivenCity("Houston")
        +"\n"+"=".repeat(30));
        System.out.println("show all promotion per season: \n"+
                ShowAllPromotionPerSeason.showAllPromotionPerSeason()+"\n"+"=".repeat(30));
        System.out.println("show all reservation of an client this month this year: \n"+
                ShowAllReservationOfAnClientThisMonthThisYear.showAllReservationOfAnClientThisMonthThisYear(
                        3,2,2023)+"\n"+"=".repeat(30));
        System.out.println("show all reservation of an client this year: "+"\n"+
                ShowAllReservationOfAnClientThisYear.showAllReservationOfAnClientThisYear(3, 2023)
                    +"\n"+"=".repeat(30));
        System.out.println("show all reservation of this client: "+"\n"+
                ShowAllReservationoOfThisClient.showAllReservationOfThisClient(3)
                    +"\n"+"=".repeat(30));
        System.out.println("show all room for type: "+"\n"+
                ShowAllRoomForType.showAllRoomForTypeInHotel("standard", "MacGyver and Sons")
                    +"\n"+"=".repeat(30));
        System.out.println("show all room between this price: "+"\n"+
                ShowAllRoomInBetweenThisPrice.showAllRoomBetweenThisPrice(606,2000)
                +"\n"+ "=".repeat(30));
        System.out.println("show all room per price: "+"\n"+
                ShowAllRoomPerPrice.showAllRoomPerPrice()
                +"\n"+ "=".repeat(30));

        System.out.println("=".repeat(30)+"\n MEDIUM"+"\n"+"=".repeat(30));
        System.out.println("client reservation count: \n"+
                ClientReservationCount.clientReservationCount(3)
                +"\n"+"=".repeat(30));
        System.out.println("free rooms tomorrow: \n"
                +FreeRoomsTomorrow.freeRoomsTomorrow()+ "\n"+"=".repeat(30));
        System.out.println("hotel room counts: \n"+
                HotelRoomsCounts.hotelRoomsCounts()+"\n"+"=".repeat(30));
        System.out.println("reservation count by room type: \n"+
                ReservationCountByRoomType.reservationCountByRoomType()+"\n"+"=".repeat(30));
        System.out.println("unavailable rooms: \n"+
                UnavailableRooms.unavailableRooms()+"\n"+"=".repeat(30));

        System.out.println("=".repeat(30)+"\n HARD"+"\n"+"=".repeat(30));
        System.out.println("free room list: \n"+
                FreeRoomList.freeRoomList("2023/02/04","2023/06/09")+"\n"+"=".repeat(30));
        System.out.println("hotels with available  room in this period: \n"+
                HotelsWithAvailableRoomsInThisPeriod.hotelsWithAvailableRomsInThisPeriod("2023/03/02", "2023/04/05")
                +"\n"+"=".repeat(30));
        System.out.println("total payments by hotel: \n"+
                TotalPaymentsByHotel.getTotalPaymentsByHotel("2023/02/03","2023/04/05")+"\n"+"=".repeat(30));
        System.out.println("total payment by conference by hotel: \n"+
                TotalPaymentsConferenceByHotel.getTotalPaymentsConferenceByHotel("2023/06/07","2023/06/09")
                +"\n"+"=".repeat(30));
        System.out.println("total payments for room rent per hotel: \n"+
                TotalPaymentsForRoomRentPerHotel.getTotalPaymentsForRoomRentPerHotel("2023/02/03","2023/04/05")
                +"\n"+"=".repeat(30));
        System.out.println("total ayments per hotel: \n"+
                TotalPaymentsPerHotel.getTotalPaymentsPerHotel(2023));
    }
}
