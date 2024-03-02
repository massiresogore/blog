package com.msr.blog.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Utils {
    public  static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

}
