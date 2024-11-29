package dev.playground.mapper;

import dev.playground.persistence.dto.GroupDto;
import java.util.stream.Collectors;
import dev.playground.persistence.entity.Group;

public class GroupMapper {

    public static Group mapToGroup(GroupDto groupDto) {
        return Group.builder()
                .id(groupDto.getId())
                .title(groupDto.getTitle())
                .photoUrl(groupDto.getPhotoUrl())
                .content(groupDto.getContent())
                .createdBy(groupDto.getCreatedBy())
                .createdOn(groupDto.getCreatedOn())
                .updatedOn(groupDto.getUpdatedOn())
                .build();
    }

    public static GroupDto mapToGroupDto(Group group) {
        return GroupDto.builder()
                .id(group.getId())
                .title(group.getTitle())
                .photoUrl(group.getPhotoUrl())
                .content(group.getContent())
                .createdBy(group.getCreatedBy())
                .createdOn(group.getCreatedOn())
                .updatedOn(group.getUpdatedOn())
                .events(group.getEvents()
                        .stream()
                        .map(EventMapper::mapToEventDto)
                        .collect(Collectors.toList()))
                .build();
    }

}
