package com.sqilab.mungai.oauth;

import com.sqilab.mungai.oauth.models.CustomUser;
import com.sqilab.mungai.oauth.repo.UserRepository;
import com.sqilab.mungai.oauth.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class OauthApplication {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserDetailsService userDetailsService;
	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserDetailService service) throws Exception {
		//Setup a default user if db is empty
		if (repository.count()==0){
			CustomUser user=new CustomUser();
			user.setPassword(passwordEncoder.encode("john"));
			user.setFirstName("John");
			user.setLastName("Mungai");
			user.setLocation("Nairobi");
			service.saveUser(user);
		}
		builder.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder);
	}

//	public DataSource createDatasource(){
//
//	}
}
