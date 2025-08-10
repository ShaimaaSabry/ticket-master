package shaimaa.ticketmaster.presentation.api.v1.event;

import shaimaa.ticketmaster.model.TicketCategory;

record TicketCategoryDto(
        String name,
        Double price
) {
    static TicketCategoryDto from(TicketCategory ticketCategory) {
        return new TicketCategoryDto(
                ticketCategory.getName(),
                ticketCategory.getPrice()
        );
    }
}
