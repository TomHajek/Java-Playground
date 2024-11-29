package dev.playground.persistence.dto;

import dev.playground.persistence.entity.Datablock;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DatablockDto {

    Integer id;

    @NotBlank(message = "Field is mandatory!")
    String name;

    @NotBlank(message = "Field is mandatory!")
    String address;

    Integer refreshInterval;
    Instant lastRefreshAt;

    public DatablockDto of(Datablock datablock) {
        DatablockDto datablockDto = new DatablockDto();
        datablockDto.setId(datablock.getId());
        datablockDto.setName(datablock.getName());
        datablockDto.setAddress(datablock.getAddress());
        datablockDto.setRefreshInterval(datablock.getRefreshInterval());
        datablockDto.setLastRefreshAt(datablock.getLastRefreshAt());
        return  datablockDto;
    }

}
