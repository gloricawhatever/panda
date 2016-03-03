package com.elbowcorp.infra.panda.controller;

import com.elbowcorp.infra.panda.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by janghyo on 2016. 3. 3..
 */
@Controller
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = {Throwable.class})
    @RequestMapping(value = "actionFileUpload", method = RequestMethod.POST)
    public ModelAndView actionPtCreate(HttpServletRequest request,
                                       @RequestParam Map<String, String> params,
                                       @RequestParam("file")MultipartFile file) throws Exception {

        fileUploadService.uploadFile(file, "/Users/janghyo/Documents");

        RedirectView rv = new RedirectView("/");
        rv.setExposeModelAttributes(false);
        ModelAndView modelAndView = new ModelAndView(rv);

        return modelAndView;

    }
}
