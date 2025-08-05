package shaimaa.ticketmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TicketMasterApplication {

    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TicketMasterApplication.class);
//        BookingService bookingService  = context.getBean(BookingService.class);
//
//        Runnable run1 =
//                new Runnable(){
//                    public void run(){
//                        bookingService.book("1", new String[]{"1"}, true);
//                    }
//                };
//
//        Runnable run2 = new Runnable() {
//            @Override
//            public void run() {
//                bookingService.book("2", new String[]{"1"}, false);
//            }
//        };
//
//        run1.run();
//        run2.run();
    }
}
