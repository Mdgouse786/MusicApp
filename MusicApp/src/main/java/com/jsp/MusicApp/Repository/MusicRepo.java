package com.jsp.MusicApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.MusicApp.Dto.Music;

public interface MusicRepo extends JpaRepository<Music, Integer>{
	
	abstract List<Music> findByArtist(String artist);


}
