
package com.example.demo.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));// le indicamos el idioma a utilizar o sintaxis de internacionalizacion
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");// le indicamos el parametro que vamos a utilizar para cambiar de lenguaje
        return lci;
    }
    
    //para registrar el interceptor se sobre escribe el metodo addInterceptor que extiende de la clase que se implemento
    @Override
    public void addInterceptors (InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());// llamando el metodo anterior registramos nuestro interceptor, y asi poder cambiar dinamicamente el lenguaje
        
    }
    
    //mappin url pat por default
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        //aqui resgistramos las vistas que vamos a utilizar en la aplicacion
        registro.addViewController("/").setViewName("index");//para este caso agregamos el pat raiz y le asignamos un nombre
        registro.addViewController("/listaCli").setViewName("clientes");
        registro.addViewController("/listaMatPri").setViewName("materiaPrima");
        registro.addViewController("/listaOrdTra").setViewName("ordenTrabajo");
        registro.addViewController("/prepararOrdenTrabajo").setViewName("prepararOrden");
        registro.addViewController("/login");//mapeo vista login, pero sin pasar por el controller
        registro.addViewController("/Clientes");
        registro.addViewController("/materiaPrima");
        registro.addViewController("/ordenTrabajo");
        registro.addViewController("/agregarOrdenTrabajook");
        registro.addViewController("/errores/403").setViewName("/errores/403");
    }
    
}
