package com.amine.tvshows;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amine.tvshows.entities.TvShow;
import com.amine.tvshows.service.TvShowService;

@SpringBootApplication
public class TvShowsApplication implements CommandLineRunner {
@Autowired
TvShowService tvshowService;
public static void main(String[] args) {
SpringApplication.run(TvShowsApplication.class, args);
}
@Override
public void run(String... args) throws Exception {

}}