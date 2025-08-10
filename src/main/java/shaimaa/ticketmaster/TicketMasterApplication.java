package shaimaa.ticketmaster;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Ticket Master APIs",
                version = "1.0.0",
                description = "Users search events and book tickets."
        )
)
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
