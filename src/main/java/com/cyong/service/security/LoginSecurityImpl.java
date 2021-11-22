package com.cyong.service.security;

import com.cyong.model.User;
import com.cyong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.security
 * @Author: cyong
 * @CreateTime: 2021-11-22 10:36
 * @Description: 统一进行用户登录验证处理
 */
public class LoginSecurityImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {

        User user = userService.findUserByPhone(phone);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if(user == null){
            throw  new UsernameNotFoundException("用户不存在");
        }
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        return new org.springframework.security.core.userdetails.User(user.getUserNickname(), user.getUserPassword(), authorities);
    }
}
