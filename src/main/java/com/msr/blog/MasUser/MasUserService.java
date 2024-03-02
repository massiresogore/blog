package com.msr.blog.MasUser;

import com.msr.blog.system.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.msr.blog.utils.Utils.passwordEncoder;


@Service
@Transactional
public class MasUserService {

    private final MasUserRepository masUserRepository;

    public MasUserService( MasUserRepository masUserRepository) {
        this.masUserRepository = masUserRepository;
    }

    public MasUser save(MasUser user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.masUserRepository.save(user);
    }

    public List<MasUser> findAll()
    {
        return this.masUserRepository.findAll();
    }

    public MasUser find(Integer id)
    {
        return this.masUserRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Mas user", id));
    }

    public MasUser update(MasUser user, Integer id)
    {
        MasUser retrived = this.find(id);
        retrived.setName(user.getName());
        retrived.setUsername(user.getUsername());
        retrived.setPassword(user.getPassword());

        return this.masUserRepository.save(retrived);
    }

    public void delete(Integer id)
    {
        //Retrive
         this.masUserRepository.findById(id);
         //Delete
         this.masUserRepository.deleteById(id);
    }



}
