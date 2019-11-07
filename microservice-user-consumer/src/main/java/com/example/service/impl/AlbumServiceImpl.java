package com.example.service.impl;

import com.example.domain.Album;
import com.example.repository.AlbumRepository;
import com.example.service.AlbumService;
import com.example.utils.JsonResult;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.example.utils.JsonResult.jsonResultSuccess;


@Service
public class AlbumServiceImpl implements AlbumService {

    @javax.annotation.Resource
    private AlbumRepository albumRepository;

    public Album findById(Long id) {
        return albumRepository.findById(id).get();
    }

    @Transactional
    public JsonResult save(Album album) {
        Album albumDb = albumRepository.save(album);
        return jsonResultSuccess("保存成功！", albumDb);
    }

    public List<Album> findAll(Sort sort) {
        return albumRepository.findAll(sort);
    }

}
