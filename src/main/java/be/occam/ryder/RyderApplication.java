package be.occam.ryder;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@SpringBootApplication
public class RyderApplication extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// @formatter:off
    	 http
         .antMatcher("/**")
         .authorizeRequests()
           .antMatchers("/", "/login**","/callback/", "/webjars/**", "/error**")
           .permitAll()
         .anyRequest()
           .authenticated();
    }
	
	public static void main(String[] args) {
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.OFF)
                .sources(RyderApplication.class)
                .run(args);
    }

}
