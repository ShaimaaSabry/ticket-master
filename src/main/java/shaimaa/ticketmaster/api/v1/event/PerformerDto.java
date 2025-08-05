package shaimaa.ticketmaster.api.v1.event;

public record PerformerDto(
        Long id,
        String name
) {
    public static PerformerDto from(shaimaa.ticketmaster.domain.model.Performer performer) {
        return new PerformerDto(performer.getId(), performer.getName());
    }
}
