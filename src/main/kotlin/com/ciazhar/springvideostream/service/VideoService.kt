package com.ciazhar.springvideostream.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileInputStream
import javax.servlet.http.HttpServletRequest

@Component
class VideoService {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Value("\${video.root}")
    private lateinit var VIDEO_ROOT : String

    fun streamSingleVideo(id : String, request: HttpServletRequest): ResponseEntity<InputStreamResource> {
        val file = File(VIDEO_ROOT+"/"+id)
        logger.info("Video Root : "+file.path)
        val headers = HttpHeaders()
        headers.add("Content-disposition","attachment; filename=\""+file.name+"\"")

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(InputStreamResource(FileInputStream(file)))

    }
}