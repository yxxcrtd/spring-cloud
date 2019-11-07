package com.example.service;

import com.example.domain.Album;
import com.example.utils.JsonResult;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface AlbumService {

    Album findById(Long id);

    JsonResult save(Album album);

    List<Album> findAll(Sort sort);

}
