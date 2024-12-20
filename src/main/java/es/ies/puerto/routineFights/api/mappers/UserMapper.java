package es.ies.puerto.routineFights.api.mappers;

import es.ies.puerto.routineFights.api.dto.UserDTO;
import es.ies.puerto.routineFights.model.Activity;
import es.ies.puerto.routineFights.model.Badge;
import es.ies.puerto.routineFights.model.Post;
import es.ies.puerto.routineFights.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "rol.name", target = "rolName")
    @Mapping(source = "posts", target = "postIds", qualifiedByName = "mapPostIds")
    @Mapping(source = "badges", target = "badgeIds", qualifiedByName = "mapBadgeIds")
    @Mapping(source = "activities", target = "activityIds", qualifiedByName = "mapActivityIds")
    UserDTO toDto(User user);

    @Named("mapPostIds")
    default Set<Integer> mapPostIds(Set<Post> posts) {
        Set<Integer> postsIds = new HashSet<>();
        if (posts != null) {
            for (Post post : posts) {
                postsIds.add(post.getId());
            }
        }
        return postsIds;

    }

    @Named("mapBadgeIds")
    default Set<Integer> mapBadgeIds(Set<Badge> badges) {
        Set<Integer> badgesIds = new HashSet<>();
        if (badges != null) {
            for (Badge badge : badges) {
                badgesIds.add(badge.getId());
            }
        }
        return badgesIds;
    }

    @Named("mapActivityIds")
    default Set<Integer> mapActivityIds(Set<Activity> activities) {
        Set<Integer> activitiesIds = new HashSet<>();
        if (activities != null) {
            for (Activity activity : activities) {
                activitiesIds.add(activity.getId());
            }
        }
        return activitiesIds;
    }
}
