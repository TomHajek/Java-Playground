package dev.playground.service.impl;

import dev.playground.mapper.GroupMapper;
import dev.playground.persistence.entity.Group;
import dev.playground.persistence.entity.User;
import dev.playground.persistence.repository.GroupRepository;
import dev.playground.persistence.repository.UserRepository;
import dev.playground.persistence.dto.GroupDto;
import dev.playground.security.SecurityUtil;
import dev.playground.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static dev.playground.mapper.GroupMapper.mapToGroup;
import static dev.playground.mapper.GroupMapper.mapToGroupDto;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;


    @Override
    public List<GroupDto> findAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups
                .stream()
                .map((group) -> mapToGroupDto(group))
                .collect(Collectors.toList());
    }

    @Override
    public Group saveGroup(GroupDto groupDto) {
        //using the sessions to tie group to particular user
        String username = SecurityUtil.getSessionUser();
        User user = userRepository.findByUsername(username);
        Group group = mapToGroup(groupDto);
        group.setCreatedBy(user);
        return groupRepository.save(group);
    }

    @Override
    public GroupDto findGroupById(Long groupId) {
        Group group = groupRepository.findById(groupId).get();
        return mapToGroupDto(group);
    }

    @Override
    public void updateGroup(GroupDto groupDto) {
        String username = SecurityUtil.getSessionUser();
        User user = userRepository.findByUsername(username);
        Group group = mapToGroup(groupDto);
        group.setCreatedBy(user);
        groupRepository.save(group);
    }

    @Override
    public void delete(Long groupId) {
        groupRepository.deleteById(groupId);
    }

    @Override
    public List<GroupDto> searchGroups(String query) {
        List<Group> groups = groupRepository.searchGroups(query);
        return groups
                .stream()
                .map(GroupMapper::mapToGroupDto)
                .collect(Collectors.toList());
    }

}
