package com.example.billingserviceprod.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class billServiceProd {

    @Bean
    public Supplier<Bill> billSupplier()
    {
        return ()->{
            etudiant c= new etudiant( new Random().nextLong(4),Math.random()>0.5?"achraf":"adam","achraf@gmail.com");

            Bill b = new Bill(new Random().nextLong(4) ,new Date(),null,new Random().nextLong(4),c);
            return b;

        };
    }
//@Bean
//public Supplier<PageEvent>pageEventSupplier()
//{
//    return ()->new PageEvent(Math.random()>0.5?"p1":"p2",Math.random()>0.5?"u1":"u2",new Date(),new Random().nextInt(9000));
//}

//    @Bean
//    public Supplier<etudiant>pageEtudiantSupplier()
//    {
//        return ()->{
//            etudiant c= new etudiant( new Random().nextLong(4),Math.random()>0.5?"achraf":"adam","achraf@gmail.com");
////
//            return c;
//        };
//    };
}
