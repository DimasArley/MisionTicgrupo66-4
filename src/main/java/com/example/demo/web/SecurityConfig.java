
package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
       
    @Override
    public void configure(AuthenticationManagerBuilder buil) throws Exception{
        buil.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    //concepto de autenticacion(agregar nuevos usuarios)= el usuario presenta las credenciales, es decir, user y contraseña
    // con este metodo creamos objeto un memoria mediante el metodo inMemoryAuthentication
//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                    .password("{noop}123")
//                    .roles("ADMIN", "USER")
//                .and()
//                .withUser("user")
//                    .password("{noop}1234")
//                    .roles("USER")
//                ;
//    }
    
    
    
    //METODO PARA RESTRINGUIR LAS URL DEL SITIO 
    //concepto autorizacion (asegurar las url)=permite a un usuario visualizar una pagina, ejecutar una accion etc.
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/editarEmp/**", "/agregarEmp/**", "/eliminarEmp")// AQUI INDICAMOS LOS PAT A RESTRINGUIR CON /** LE INDICAMOS QUE CUALQUIER PAT QUE ESTE DENTRO TAMBIEN ESTARA RESTRINGUIDO
                    .hasRole("ADMIN")//AQUI INDICAMOS CUAL ES EL USUARIO QUE SI PUEDE INGRESAR A ESTOS PATS (ANTERIORES)
                .antMatchers("/", "/Clientes", "/materiaPrima", "/ordenTrabajo")//INDICAMOS LOS PAT A LOS QUE PUEDEN INGRESAR CUALQUIER USUARIO
                    .hasAnyRole("USER", "ADMIN")//INDICAMOS CUALES ROLES PUEDEN INGRESAR A LA CARPETA RAIZ, CUANDO ES
                .and()// SOLO UN ROL UTILIZAMOS EL METODO hasRole
                    .formLogin()//indicamos que vamos a configurar form el login
                    .loginPage("/login")//indicamos cual es la pagina que vamos a utilizar de loggin
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403")//indicamos cual es nuestra pagina de error.
                ;
    }
    
}
