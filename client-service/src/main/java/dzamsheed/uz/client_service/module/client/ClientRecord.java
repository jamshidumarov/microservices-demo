package dzamsheed.uz.client_service.module.client;

import java.util.Date;

public record ClientRecord(
        Integer id,
        String name,
        String phoneNumber,
        String email,
        Date createdAt,
        Date updatedAt,
        Date birthDate
){

    public Client toEntity() {
        return Client
                .builder()
                .id(id())
                .name(name())
                .phoneNumber(phoneNumber())
                .email(email())
                .createdAt(createdAt())
                .updatedAt(updatedAt())
                .birthDate(birthDate())
                .build();
    }
}
