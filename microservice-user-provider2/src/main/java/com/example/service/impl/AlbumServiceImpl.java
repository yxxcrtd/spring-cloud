package com.example.service.impl;

import com.example.domain.Album;
import com.example.repository.AlbumRepository;
import com.example.service.AlbumService;
import org.springframework.stereotype.Service;


@Service
public class AlbumServiceImpl implements AlbumService {

    @javax.annotation.Resource
    private AlbumRepository albumRepository;

    public Album findById(Long id) {
        return albumRepository.findById(id).get();
    }

}
