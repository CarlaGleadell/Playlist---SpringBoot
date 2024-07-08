package com.example.playlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {
    
    @Autowired
    private PlaylistRepository playlistRepository;
    
    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public String showPlaylists(Model model) {
        List<Playlist> playlists = playlistRepository.findAll();
        model.addAttribute("playlists", playlists);
        return "index";
    }

    @GetMapping("/nuevo")
    public String formularioDeRegistrarPlaylist(Model model) {
        Playlist playlist = new Playlist();
        model.addAttribute("playlist", playlist);
        return "crear";
    }

    @PostMapping
    public String guardarPlaylist(@ModelAttribute("playlist") Playlist playlist) {
        playlistService.guardarPlaylist(playlist); 
        return "redirect:/playlists"; 
    }
    
    @GetMapping("/editar/{codigo}")
    public String mostrarFormularioEditar(@PathVariable int codigo, Model model) {
        Playlist playlist = playlistService.obtenerPlaylistPorCodigo(codigo);
        model.addAttribute("playlist", playlist);
        return "editar"; 
    }

    @PostMapping("/editar/{codigo}")
    public String actualizarPlaylist(@PathVariable int codigo, @ModelAttribute("playlist") Playlist playlist) {
        playlistService.actualizarPlaylist(playlist);
        return "redirect:/playlists";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarPlaylist(@PathVariable int codigo) {
        playlistService.eliminarPlaylist(codigo);
        return "redirect:/playlists";
    }
}