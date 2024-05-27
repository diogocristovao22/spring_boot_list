package com.springbootlearning.learningspringboot3;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //Anotação do Framework Spring denotando uma classe que precisa ser escolhida durante a varredura do componente e adicionanda ao contexto da aplicação
public class VideoService {

  private List<Video> videos = List.of( //Operação usada para rapidamente juntar uma coleção de objetos Video
    new Video("malu","refri","fritas" ,"15/05/2024"));
    
    
 
  public List<Video> getVideos() { //Um método utilitário para retornar a coleção corrente de objetos Video
    return videos;
  }

public Video create(Video newVideo) {
    List<Video> extend = new ArrayList<>(videos);
    extend.add(newVideo);
    this.videos = List.copyOf(extend);
    return newVideo;
  }
  
  
}







