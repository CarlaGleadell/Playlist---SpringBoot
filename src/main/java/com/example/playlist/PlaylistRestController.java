package com.example.playlist;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/playlists")
public class PlaylistRestController {
    
    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public Optional<Playlist> getPlaylistById(@PathVariable int codigo) {
        return playlistRepository.findById(codigo);
    }

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @PutMapping("/{codigo}")
    public Playlist updatePlaylist(@PathVariable int codigo, @RequestBody Playlist playlistDetails) {
        Playlist playlist = playlistRepository.findById(codigo).orElseThrow();
        playlist.setTitulo(playlistDetails.getTitulo());
        playlist.setInterprete(playlistDetails.getInterprete());
        playlist.setCantidadTemas(playlistDetails.getCantidadTemas());
        playlist.setDuracionTotal(playlistDetails.getDuracionTotal());
        return playlistRepository.save(playlist);
    }

    @DeleteMapping("/{codigo}")
    public void deletePlaylist(@PathVariable int codigo) {
        playlistRepository.deleteById(codigo);
    }
}