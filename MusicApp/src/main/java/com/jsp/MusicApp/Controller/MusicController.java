package com.jsp.MusicApp.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.MusicApp.Dto.Music;
import com.jsp.MusicApp.Service.MusicService;
import com.jsp.MusicApp.Util.ResponseStructure;

@RestController
@CrossOrigin(origins = "*",methods= {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
public class MusicController {
	@Autowired
	private MusicService musicService;
	
	@PostMapping(consumes = "multipart/form-data")
	public ResponseEntity<ResponseStructure<Music>> saveMusic(@RequestParam MultipartFile audiofile,@RequestParam String song,@RequestParam String title,@RequestParam String artist) throws IOException {
		return musicService.uploadSong(song, title, artist, audiofile);
	}
	@GetMapping("/artist")
	public ResponseEntity<ResponseStructure<List<Music>>> findByArtist(@RequestParam String artist) {
		return musicService.findByArtist(artist);
	}
	@GetMapping("/findAllMusic")
	public ResponseEntity<ResponseStructure<List<Music>>> findAllMusic(){
		return musicService.findAllMusic();
	}

}
