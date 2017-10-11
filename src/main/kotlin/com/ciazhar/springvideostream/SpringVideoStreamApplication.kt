package com.ciazhar.springvideostream

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringVideoStreamApplication{
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringVideoStreamApplication::class.java, *args)
        }
    }
}

