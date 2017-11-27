package lt.marius.intranet.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

//generuojam slaptazodi
@Component
public class SecurityUtility {
    private static final String SALT = "salt";

    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }

//    @Bean
//    public static String randomPassword(){
//        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        StringBuilder stringBuilder = new StringBuilder();
//        Random random  = new Random();
//        while (stringBuilder.length()<18){
//            int index=(int)(random.nextFloat()*SALTCHARS.length());
//            stringBuilder.append(SALTCHARS.charAt(index));
//        }
//        return stringBuilder.toString();
//    }

}
