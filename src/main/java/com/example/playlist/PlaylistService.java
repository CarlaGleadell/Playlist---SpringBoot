package com.example.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
    
    @Autowired
    private PlaylistRepository playlistRepository;

    public void guardarPlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    public Playlist obtenerPlaylistPorCodigo(int codigo) {
        return playlistRepository.findById(codigo).orElse(null);
    }

    public void actualizarPlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    public void eliminarPlaylist(int codigo) {
        playlistRepository.deleteById(codigo);
    }
}