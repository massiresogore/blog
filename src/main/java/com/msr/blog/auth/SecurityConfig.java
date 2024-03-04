package com.msr.blog.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomUserDetailSerice customUserDetailSerice;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    };

    /*
    *
    *<div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Earum id iste maiores nulla officiis optio porro, rem
	sequi! Ab corporis dolorem eos incidunt iste, nam necessitatibus nihil temporibus tenetur vero.
</div>
<div>Animi architecto consequuntur, dolores id iste natus nihil nisi odio possimus repellendus saepe sed, similique sit
	ut vitae. Deleniti distinctio earum error hic pariatur ratione recusandae reprehenderit repudiandae tempora
	voluptatem!
</div>
<div>Commodi corporis cumque distinctio enim ex impedit incidunt, itaque iure modi natus necessitatibus nemo nisi
	obcaecati pariatur porro quam quia quidem quis quisquam saepe sapiente tempore totam velit voluptatibus voluptatum!
</div>
<div>Labore, quis quisquam. Eum, modi, perferendis? Ad, architecto at corporis doloremque error exercitationem iure,
	laborum molestias nam natus officia pariatur quaerat sapiente sit soluta vero voluptatibus. Eum fugit quam tenetur.
</div>
<div>Dolorem exercitationem ipsum itaque iure nulla perspiciatis sed? Delectus dignissimos eum facere hic ipsam iste
	iusto laborum nulla odit placeat quae quaerat quas quasi quis, recusandae sint soluta tempore voluptas!
</div>
<div>Accusantium aperiam dolor doloribus ea excepturi maiores molestiae officiis perferendis quae suscipit! Consectetur
	dolor eaque harum laboriosam non odit quia quibusdam quis! Debitis dicta et hic nemo saepe soluta veritatis!
</div>
<div>Amet asperiores assumenda blanditiis commodi, cum deserunt doloremque earum eveniet exercitationem inventore ipsa
	iusto laboriosam minus pariatur perferendis quis ratione repudiandae saepe sapiente suscipit totam veritatis
	voluptatibus. Culpa exercitationem, voluptatum?
</div>
<div>Accusantium adipisci beatae consequuntur cumque doloribus est iste libero non officiis quod quos suscipit, ut
	veritatis! Ab ad aliquam aut beatae consequatur magni, necessitatibus perspiciatis possimus! Ab fugiat maxime quis?
</div>
<div>Aut debitis delectus deleniti enim et eum, eveniet facere impedit ipsa laudantium libero minus, quis, unde?
	Adipisci aliquid, architecto deleniti dignissimos enim est nihil porro quaerat, recusandae repellat sed voluptate.
</div>
<div>Cumque, iure saepe? Consequuntur et eum expedita possimus voluptatum? Commodi cupiditate dolore, ea est
	exercitationem explicabo facere in ipsam laudantium maiores minus molestias pariatur possimus provident quo,
	sapiente, sed tenetur?
</div>
    *
    * <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Earum id iste maiores nulla officiis optio porro, rem
	sequi! Ab corporis dolorem eos incidunt iste, nam necessitatibus nihil temporibus tenetur vero.
</div>
<div>Animi architecto consequuntur, dolores id iste natus nihil nisi odio possimus repellendus saepe sed, similique sit
	ut vitae. Deleniti distinctio earum error hic pariatur ratione recusandae reprehenderit repudiandae tempora
	voluptatem!
</div>
<div>Commodi corporis cumque distinctio enim ex impedit incidunt, itaque iure modi natus necessitatibus nemo nisi
	obcaecati pariatur porro quam quia quidem quis quisquam saepe sapiente tempore totam velit voluptatibus voluptatum!
</div>
<div>Labore, quis quisquam. Eum, modi, perferendis? Ad, architecto at corporis doloremque error exercitationem iure,
	laborum molestias nam natus officia pariatur quaerat sapiente sit soluta vero voluptatibus. Eum fugit quam tenetur.
</div>
<div>Dolorem exercitationem ipsum itaque iure nulla perspiciatis sed? Delectus dignissimos eum facere hic ipsam iste
	iusto laborum nulla odit placeat quae quaerat quas quasi quis, recusandae sint soluta tempore voluptas!
</div>
<div>Accusantium aperiam dolor doloribus ea excepturi maiores molestiae officiis perferendis quae suscipit! Consectetur
	dolor eaque harum laboriosam non odit quia quibusdam quis! Debitis dicta et hic nemo saepe soluta veritatis!
</div>
<div>Amet asperiores assumenda blanditiis commodi, cum deserunt doloremque earum eveniet exercitationem inventore ipsa
	iusto laboriosam minus pariatur perferendis quis ratione repudiandae saepe sapiente suscipit totam veritatis
	voluptatibus. Culpa exercitationem, voluptatum?
</div>
<div>Accusantium adipisci beatae consequuntur cumque doloribus est iste libero non officiis quod quos suscipit, ut
	veritatis! Ab ad aliquam aut beatae consequatur magni, necessitatibus perspiciatis possimus! Ab fugiat maxime quis?
</div>
<div>Aut debitis delectus deleniti enim et eum, eveniet facere impedit ipsa laudantium libero minus, quis, unde?
	Adipisci aliquid, architecto deleniti dignissimos enim est nihil porro quaerat, recusandae repellat sed voluptate.
</div>
<div>Cumque, iure saepe? Consequuntur et eum expedita possimus voluptatum? Commodi cupiditate dolore, ea est
	exercitationem explicabo facere in ipsam laudantium maiores minus molestias pariatur possimus provident quo,
	sapiente, sed tenetur?
</div>
    * */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
//        http.csrf(Customizer.withDefaults())
//                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry)
//                .requestMatchers("/register").permitAll()
//                .requestMatchers("/").permitAll()
//                .and()
//                .formLogin("/login")
//                .loginProcessingUrl("/login")
//
//

        return http
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers(HttpMethod.GET,"/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST,"/auth").permitAll()
                        /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                        //allow everything authenticated*/
                        .anyRequest().authenticated()//Recommand to put this at last

                )
                /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/ /*.requestMatchers(HttpMethod.GET,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        //.requestMatchers(HttpMethod.POST,this.baseUrl+"/users").authenticated()//protecting endpoint
                       //                        .requestMatchers(HttpMethod.POST,this.baseUrl+"/users").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.PUT,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(HttpMethod.DELETE,this.baseUrl+"/users/**").hasAuthority("ROLE_admin")//protecting endpoint
                       //                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()//autorise h2-console
                       //                        //allow everything authenticated*/

                /*     .formLogin(form -> form
                             .loginPage("/user/login")
                             .permitAll()
                     )*/
                .formLogin(Customizer.withDefaults())//default
                /*.formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/user/add")
                )*/
                .logout(Customizer.withDefaults())

//                .headers(AbstractHttpConfigurer::disable)//autorise h2-console
//                .csrf(AbstractHttpConfigurer::disable)
//                //.cors(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults())
                //.httpBasic(Customizer.withDefaults())
                //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                /*.oauth2ResourceServer(oauth2ResourceServer-> oauth2ResourceServer
                        .jwt(Customizer.withDefaults())
                        .authenticationEntryPoint(this.customBearerTokenAuthenticationEntryPoint)
                        .accessDeniedHandler(this.customBearerTokenAccessDeniedHandler)
                )*/
                //.sessionManagement(sessionManagement->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(customUserDetailSerice).passwordEncoder(passwordEncoder());
    }
}
