package dev.playground.service;

import dev.playground.persistence.dto.GroupDto;
import dev.playground.persistence.entity.Group;

import java.util.List;

public interface GroupService {

    List<GroupDto> findAllGroups();
    Group saveGroup(GroupDto groupDto);
    GroupDto findGroupById(Long groupId);
    void updateGroup(GroupDto groupDto);
    void delete(Long groupId);
    List<GroupDto> searchGroups(String query);

}
