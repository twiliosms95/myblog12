package com.myblog.myblog12.controller;

import com.myblog.myblog12.payload.PostDto;
import com.myblog.myblog12.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        dto.setMessage("Record is saved");
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/posts/particular?id=1
    @GetMapping("/particular")
    public ResponseEntity<PostDto> getPostById(@RequestParam long id){
        PostDto dto = postService.getPostById(id);
        dto.setMessage("Record is found by id:-"+id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //http://localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=title&sortDir=desc
    @GetMapping
    public List<PostDto> getAllPost(

            @RequestParam(name = "pageNo" ,required = false,defaultValue = "0") int pageNo ,
            @RequestParam(name = "pageSize" ,required = false,defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy" ,required = false,defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDir" ,required = false,defaultValue = "id") String sortDir

    ){
        List<PostDto> postDtos = postService.getAllPost(pageNo,pageSize,sortBy,sortDir);
        return postDtos;
    }

    //http://localhost:8080/api/posts/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post is deleted successfully",HttpStatus.OK);
    }

    //http:localhost:8080/api/post/4
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable long id,@RequestBody PostDto dto){
        PostDto dto1 = postService.updatePost(id, dto);
        dto1.setMessage("Record is updated successfully");
        return new ResponseEntity<>(dto1,HttpStatus.OK);
    }


}
