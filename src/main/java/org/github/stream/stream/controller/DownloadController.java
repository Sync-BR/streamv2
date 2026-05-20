package org.github.stream.stream.controller;

import org.github.stream.stream.util.RequestUtil;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.http.HttpResponse;

@RestController
public class DownloadController {

    private final RequestUtil util;

    public DownloadController(RequestUtil util) {
        this.util = util;
    }
    @GetMapping("/download-video/{streamId}")
    public ResponseEntity<InputStreamResource> downloadVideo(@PathVariable Long streamId) throws Exception {

        HttpResponse<InputStream> response = util.createResponse(streamId);

        if (response.statusCode() != 200) {
            return ResponseEntity.status(response.statusCode()).build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"filme-" + streamId + ".mp4\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(response.body()));
    }

//    @GetMapping("/download-video")
//    public ResponseEntity<InputStreamResource> downloadVideo() throws Exception {
//
//        HttpResponse<InputStream> response = util.createResponse();
//
//        if (response.statusCode() != 200) {
//            return ResponseEntity.status(response.statusCode()).build();
//        }
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"video.mp4\"")
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(new InputStreamResource(response.body()));
//    }
}