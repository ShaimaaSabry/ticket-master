package shaimaa.ticketmaster.presentation.api.v1.event;

import shaimaa.ticketmaster.model.Performer;

public record PerformerDto(
        Long id,
        String name
) {
    public static PerformerDto from(Performer performer) {
        return new PerformerDto(performer.getId(), performer.getName());
    }
}
