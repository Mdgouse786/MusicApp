package com.jsp.MusicApp.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.MusicApp.Dto.Music;
import com.jsp.MusicApp.Repository.MusicRepo;

@Repository
public class MusicDao {
	@Autowired
	private MusicRepo repo;
	
	public Music uploadSong(Music music) {
		return repo.save(music);
		
	}
	public List<Music > findByArtist(String artist) {
		
		return  repo.findByArtist(artist);
	}
	public List<Music> findAllMusic(){
		return repo.findAll();
	}
	

}
