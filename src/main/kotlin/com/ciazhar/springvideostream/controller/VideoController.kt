package com.ciazhar.springvideostream.controller

import com.ciazhar.springvideostream.service.VideoService
import org.springframework.core.io.InputStreamResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

/**
 * Created by ciazhar on 10/12/17.
 *
 * [ Documentation Here ]
 */

@RestController
class VideoController(private val videoService: VideoService){

    @RequestMapping("/video")
    fun stream(@RequestParam("name") id : String, request : HttpServletRequest) : ResponseEntity<InputStreamResource>{
        return videoService.streamSingleVideo(id,request)
    }
}