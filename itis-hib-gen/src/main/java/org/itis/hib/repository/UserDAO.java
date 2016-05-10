package org.itis.hib.repository;

import org.itis.hib.genentities.UsersEntity;

import java.util.List;

/**
 * Created by SDS on 22.04.2016.
 */
public interface UserDAO {
    List<UsersEntity> getAllUsers();
    void updateUser(UsersEntity user);
    void deleteUser(UsersEntity user);
}
