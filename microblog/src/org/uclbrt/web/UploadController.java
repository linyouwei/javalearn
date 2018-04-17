package org.uclbrt.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.uclbrt.entity.Comment;
import org.uclbrt.entity.Daily;
import org.uclbrt.entity.UserDetail;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.service.Upload;
import org.uclbrt.service.HomePageService;
import org.uclbrt.util.EmptyUtil;
import org.uclbrt.util.SystemConstant;

/**
 * 用户登录,注册等功能
 *
 * @author YouWei Lin
 * @since 1.0.0
 */
@Controller
@RequestMapping("/upload")
public class UploadController implements SystemConstant {
	@RequestMapping(value ="/toUploadImg.form", method = RequestMethod.GET)
    public String toUploadimg(){
		System.out.println(123);
        return "../jsp/topic/upload";
    }
	@RequestMapping(value ="/thumb.form", method = RequestMethod.POST)
	public String upload(MultipartFile file,HttpServletRequest request)throws IOException {
		
		System.out.println("33");
		
		String filename = file.getOriginalFilename();
        System.out.println(filename);
        //写入本地磁盘
        InputStream is = file.getInputStream();  
        byte[] bs = new byte[1024];  
        int len;  
        OutputStream os = new FileOutputStream(new File("D:/temp/" + filename));  
        while ((len = is.read(bs)) != -1) {  
            os.write(bs, 0, len);  
        }  
        os.close();  
        is.close();  
        return "../jsp/topic/setting";
//		String path = request.getSession().getServletContext().getRealPath("upload");  
//        String fileName = file.getOriginalFilename();    
//        File dir = new File(path,fileName);          
//        if(!dir.exists()){  
//            dir.mkdirs();  
//        }  
//        //MultipartFile自带的解析方法  
//        file.transferTo(dir);  
//        return "ok!";  	
	}

    
	
	

}
