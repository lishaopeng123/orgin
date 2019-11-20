package cn.com.spring_thymealf_jpa_crud4.dao;

import cn.com.spring_thymealf_jpa_crud4.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
