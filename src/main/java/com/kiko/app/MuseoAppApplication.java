package com.kiko.app;

import com.kiko.app.service.DataLoader;
import com.kiko.app.repository.ExposicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MuseoAppApplication {

    @Autowired
    private DataLoader dataLoader;

    @Autowired
    private ExposicionRepository exposicionRepository;

    public static void main(String[] args) {
        SpringApplication.run(MuseoAppApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onAppReady() {
        dataLoader.guardameEnBD();
    }
}
