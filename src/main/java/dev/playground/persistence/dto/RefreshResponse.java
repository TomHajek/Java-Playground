package dev.playground.persistence.dto;

import dev.playground.persistence.entity.Datablock;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshResponse {

    private String lastRefreshedAt;

    public RefreshResponse of(Datablock datablock) {
        RefreshResponse refreshResponse = new RefreshResponse();
        refreshResponse.setLastRefreshedAt(datablock.getLastRefreshAt().toString());
        return refreshResponse;
    }

}
