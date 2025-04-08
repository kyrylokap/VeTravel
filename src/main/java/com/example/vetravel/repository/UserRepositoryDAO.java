package com.example.vetravel.repository;
import com.example.vetravel.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryDAO extends JpaRepository<User,Long> {
    public User searchFirstByUsernameAndPassword(String username,String password);
    public User searchFirstById(Long id);
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.prevPassword = u.password, u.password = :newPassword WHERE u.username = :username AND u.password = :oldPassword")
    int updatePassword(String username, String oldPassword, String newPassword);
}
