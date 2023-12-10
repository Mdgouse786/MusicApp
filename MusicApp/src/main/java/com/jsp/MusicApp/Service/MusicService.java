package com.jsp.MusicApp.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.StreamUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.MusicApp.Dao.MusicDao;
import com.jsp.MusicApp.Dto.Music;
import com.jsp.MusicApp.Exception.MusicNotFoundException;
import com.jsp.MusicApp.Exceptions.ArtistNotFoundException;
import com.jsp.MusicApp.Exceptions.BodyMissingRequirdParameters;
import com.jsp.MusicApp.Repository.MusicRepo;
import com.jsp.MusicApp.Util.ResponseStructure;

@Service
public class MusicService {

	@Autowired
	private MusicDao dao;
	@Autowired
	private MusicRepo musicRepo;

	public ResponseEntity<ResponseStructure<Music>> uploadSong(String song, String title, String artist,MultipartFile audioFile) throws IOException {

		if (!song.isEmpty() || !title.isEmpty() || !artist.isEmpty()
				|| !audioFile.isEmpty()) {

			Music music = new Music();
//			Music insertMusic=musicRepo.save(music);
			music.setArtist(artist);
			music.setAudiofile(audioFile.getOriginalFilename());
			music.setSong(song);
			music.setTitle(title);

			ResponseStructure<Music> structure = new ResponseStructure<>();
			structure.setMessage("Song uploaded  Successfully.");
			structure.setData(dao.uploadSong(music));
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Music>>(structure, HttpStatus.CREATED);

		} else {
			throw new BodyMissingRequirdParameters("faild to upload song.");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Music>>> findByArtist(String artist){
		List<Music> dbmusic=dao.findByArtist(artist);
		if(dbmusic!=null) {

		       
			ResponseStructure<List<Music>> structure=new ResponseStructure<List<Music>>();
			structure.setData(dbmusic);
			structure.setMessage("Artist found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<List<Music>>>(structure,HttpStatus.FOUND);
		}else {
		throw new ArtistNotFoundException();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<List<Music>>> findAllMusic(){
		List<Music> dbm=dao.findAllMusic();
		if(dbm!=null) {
			ResponseStructure<List<Music>> structure=new ResponseStructure();
			structure.setData(dbm);
			structure.setMessage("Music found successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<List<Music>>>(structure,HttpStatus.FOUND);
		}else {
			throw new MusicNotFoundException("Music not found");
		}
	}

}
	
	
	


