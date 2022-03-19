package com.test.test.controller

import com.test.test.model.Content
import com.test.test.model.Test
import com.test.test.repository.ContentRepo
import com.test.test.repository.PoemRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.*
@RestController
@CrossOrigin(origins = arrayOf("*"), allowedHeaders = arrayOf("*"))
class check(@Autowired val poemRepo: PoemRepo,@Autowired val contentRepo: ContentRepo) {
    var a="";
    var b=0;
    @GetMapping("/")
    fun addContent() : MutableList<Content> {
        return contentRepo.findAll();
    }
    @GetMapping("/getone/{id}")
    fun getOne( @PathVariable id:Int ) : Content? {
        contentRepo.findAll().map{
            if(it.id==id){
                return it;
            }
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    fun deleteOne( @PathVariable id:Int ) : Boolean? {
        contentRepo.deleteById(id)
        return true;
    }
    @PostMapping("/update/{id}")
    fun update(@RequestBody content: Content):Boolean{
        contentRepo.save(content);
        return true;
    }
    @GetMapping("/getcontent/{type}")
    fun addContent(@PathVariable type: String) : MutableList<Content> {
        var story= mutableListOf<Content>()
        var poem= mutableListOf<Content>()
        var shayri= mutableListOf<Content>()
        contentRepo.findAll().map {
            if(it.isStory && type=="story"){
                story.add(it);
            }
            if(it.isPoem && type=="poem"){
                poem.add(it);
            }
            if(it.isShayri && type=="shayri"){
                shayri.add(it);
            }
        }
        if(type=="poem")return poem;
        else if(type=="story") return story;
        else return shayri
    }
    @PostMapping("/content")
    fun addContent(@RequestBody content: Content) : Content{
        content.id=contentRepo.findAll().size+2;
        return contentRepo.save(content);
    }
}
