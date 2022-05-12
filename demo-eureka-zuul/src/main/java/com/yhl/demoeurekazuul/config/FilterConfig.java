package com.yhl.demoeurekazuul.config;

import com.yhl.demoeurekazuul.filter.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class FilterConfig {
    @Bean
    public MyPreFilter mypreFilter( ) {
        return new MyPreFilter();
    }
    @Bean
    public MyPreFilter2 mypreFilter2(){
        return new MyPreFilter2( );
    }
    @Bean
    public MyRoutingFilter myroutingFilter( ) {
        return new MyRoutingFilter( );
    }
    @Bean
    public MyRoutingFilter2 myroutingFilter2( ){
        return new MyRoutingFilter2();
    }
    @Bean
    public MyErrorFilter myerrorFilter() {
        return new MyErrorFilter();
    }
    @Bean
    public MyPostFilter mypostFilter() {
        return new MyPostFilter();
    }


        }
