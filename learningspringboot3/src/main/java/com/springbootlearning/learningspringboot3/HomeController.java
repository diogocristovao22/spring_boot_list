package com.springbootlearning.learningspringboot3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller //Uma anotação do Spring MVC para comunicar que essa classe é um controlador web
public class HomeController {
    
    private final VideoService videoService;

    public HomeController(VideoService videoService) {
        this.videoService = videoService;

    }


    @GetMapping ("/") //Anotação Spring MVC para mapear o HTTP GET para este método
    public String index(Model model) { //Model é utilizado para passar dados ao nosso template
        model.addAttribute("videos", videoService.getVideos());
        return "index"; //Como utilizamos anotação @Controller, o index é o nome do que será renderizado
    }

    @PostMapping("/new-video")
    public String newVideo(@ModelAttribute Video newVideo) {
        videoService.create(newVideo);        
        return "redirect:/";
    }
}