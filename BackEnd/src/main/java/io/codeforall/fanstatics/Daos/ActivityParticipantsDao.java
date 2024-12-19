package io.codeforall.fanstatics.Daos;

import io.codeforall.fanstatics.DTO.ActivityDTO;
import io.codeforall.fanstatics.DTO.UserDTO;
import io.codeforall.fanstatics.Daos.Interfaces.ActivityParticipantsDaoInterface;
import io.codeforall.fanstatics.Daos.Interfaces.Dao;
import io.codeforall.fanstatics.Models.Activity;
import io.codeforall.fanstatics.Models.PlannedActivities;
import io.codeforall.fanstatics.Models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActivityParticipantsDao<T> implements ActivityParticipantsDaoInterface<T> {

    @PersistenceContext
    protected EntityManager em;


    @Override
    public List<UserDTO> getUsersInPlannedActivity( Integer plannedActivityId) {
        List<Object[]> result = em.createNativeQuery(
                        "SELECT u.id, u.name, u.email FROM user u " +
                                "JOIN activity_participants ap ON u.id = ap.user_id " +
                                "WHERE ap.planned_activity_id = :plannedActivityId")
                .setParameter("plannedActivityId", plannedActivityId)
                .getResultList();

        List<UserDTO> userDTOs = new ArrayList<>();
        for (Object[] row : result) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId((Integer) row[0]);
            userDTO.setName((String) row[1]);
            userDTO.setEmail((String) row[2]);
            userDTOs.add(userDTO);
        }
        return userDTOs;
/*
        return em.createNativeQuery(
                        "SELECT * FROM user u " +
                                "JOIN activity_participants ap ON u.id = ap.user_id " +
                                "WHERE ap.planned_activity_id = :plannedActivityId",
                        "UserDTO")
                .setParameter("plannedActivityId", plannedActivityId)
                .getResultList();

 */
    }

    @Override
    public List<ActivityDTO> getActivitiesForUser(Integer userId) {
        List<Object[]> result = em.createNativeQuery(
                        "SELECT a.id, a.name " +
                                "FROM activity a " +
                                "JOIN planned_activities pa ON a.id = pa.activity_id " +
                                "JOIN activity_participants ap ON pa.id = ap.planned_activity_id " +
                                "WHERE ap.user_id = :userId")
                .setParameter("userId", userId)
                .getResultList();

        List<ActivityDTO> activityDTOs = new ArrayList<>();
        for (Object[] row : result) {
            ActivityDTO activityDTO = new ActivityDTO();
            activityDTO.setId((Integer) row[0]);
            activityDTO.setName((String) row[1]);
            activityDTOs.add(activityDTO);
        }
        return activityDTOs;

/*
        return em.createNativeQuery(
                        "SELECT * FROM activity a " +
                                "JOIN planned_activities pa ON a.id = pa.activity_id " +
                                "JOIN activity_participants ap ON pa.id = ap.planned_activity_id " +
                                "WHERE ap.user_id = :userId",
                        Activity.class)
                .setParameter("userId", userId)
                .getResultList();

 */
    }

    @Override
    public void addUserToPlannedActivity(Integer userId, Integer plannedActivityId) {

        /*
        INSERT INTO activity_participants (user_id, planned_activity_id)
        VALUES (?, ?);

         */
        em.getTransaction().begin();

        // Fetch the user and planned activity entities
        User user = em.find(User.class, userId);
        PlannedActivities plannedActivities = em.find(PlannedActivities.class, plannedActivityId);

        // Add the planned activity to the user's joined activities
        user.getPlannedActivities().add(plannedActivities);

        // Add the user to the planned activity's participants
        plannedActivities.getUsers().add(user);

        // Persist the changes
        em.merge(user);
        em.merge(plannedActivities);

        em.getTransaction().commit();
    }


    @Override
    public void deleteUserFromPlannedActivity(Integer userId, Integer plannedActivityId) {
        /*
        DELETE FROM activity_participants
        WHERE user_id = ? AND planned_activity_id = ?;

         */

        em.getTransaction().begin();

        em.createNativeQuery("DELETE FROM activity_participants WHERE user_id = :userId AND planned_activity_id = :plannedActivityId")
                .setParameter("userId", userId)
                .setParameter("plannedActivityId", plannedActivityId)
                .executeUpdate();

        em.getTransaction().commit();
    }
}
