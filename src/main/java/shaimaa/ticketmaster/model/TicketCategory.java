package shaimaa.ticketmaster.model;

import lombok.Getter;

@Getter
public class TicketCategory {
    private Long id;
    private String name;
    private Double price;

    private TicketCategory(
            Long id,
            String name,
            Double price
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static TicketCategory of(Long id, String name, Double price) {
        return new TicketCategory(id, name, price);
    }
}
