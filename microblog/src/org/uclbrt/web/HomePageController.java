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
@RequestMapping("/homePage")
public class HomePageController implements SystemConstant {
	@Resource
	private HomePageService homePageService; 

	@RequestMapping(value ="/index.form", method = RequestMethod.GET)
	public String index(ModelMap map,HttpSession session) {
		System.out.println(123);
		UserLogin user = (UserLogin) session.getAttribute("user");
		System.out.println(user);
		if(!EmptyUtil.isNullOrEmpty(user)){
			System.out.println(222);
			//查询该用户的博客列表
			List<Daily> dailyList = homePageService.getDailyListByUserId(user.getId());
			//查询该用户的最新博客
			List<Daily> recentDailyList = homePageService.findUserRecentDaily(user.getId());
			//查询该用户的归档
			List<Map> archivesList = homePageService.getUserArchivesDate(user.getId());
			//查询用户自定义分类列表
			List<Map> userCategoryList = homePageService.getUserCategoryList(user.getId());
	
			
			map.put("dailyList",dailyList);	
			map.put("recentDailyList",recentDailyList);	
			map.put("archivesList",archivesList);	
			map.put("userCategoryList",userCategoryList);	
			return "../jsp/topic/index";	
		}else{
			System.out.println('1');
			//查询所有博客列表
			List<Daily> dailyList = homePageService.getAllDaily();
			//查询最新博客（整个系统的）
			List<Daily> recentDailyList = homePageService.findRecentDaily();
			//查询整个系统的分类
			List<Map> categoryList = homePageService.getCategoryList();
			System.out.println('2');
			map.put("dailyList",dailyList);	
			map.put("recentDailyList",recentDailyList);	
			map.put("categoryList",categoryList);	
			return "../jsp/topic/index";	
		}		
	}
	@RequestMapping(value ="/dailyDetail.form", method = RequestMethod.GET)
	public String daily(int dailyId,ModelMap map,HttpSession session) {
		System.out.println("333"+dailyId);
		UserLogin user = (UserLogin) session.getAttribute("user");
		if(!EmptyUtil.isNullOrEmpty(user)){
			//获取daily
			Daily daily = homePageService.getDailyByUserId(dailyId);
			//获取评论
			List<Comment> commentList = homePageService.getCommentByDailyId(user.getId());
			map.put("daily",daily);	
			map.put("commentList",commentList);	
			return "../jsp/topic/detail";	
		}
		return "../jsp/topic/index";	
	}
	@RequestMapping(value ="/setting.form", method = RequestMethod.GET)
	public String setting(ModelMap map,HttpSession session) {
		//获取用户基本信息
		UserLogin user = (UserLogin) session.getAttribute("user");
		if(!EmptyUtil.isNullOrEmpty(user)){
			//获取userDetail
			UserDetail userDetail = homePageService.findDetailByUserId(user.getId());
			System.out.println(userDetail.toString());
			//获取评论
			List<Comment> commentList = homePageService.getCommentByDailyId(user.getId());
			map.put("userDetail",userDetail);	
			map.put("commentList",commentList);	
			return "../jsp/topic/setting";	
		}
		return "../jsp/topic/setting";	
	}
	@RequestMapping(value ="thumb.form", method = RequestMethod.POST)
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

    //文件上传并生成缩略图  
//    @RequestMapping(value="/thumb",method=RequestMethod.POST)  
//    public String GenerateImage(@RequestParam("image")CommonsMultipartFile file,HttpServletRequest request) throws IOException  
//    {             
//        //根据相对路径获取绝对路径，图片上传后位于元数据中  
//        String realUploadPath=request.getServletContext().getRealPath("/")+"images";          
//                  
//        //获取上传后原图的相对地址  
//        String imageUrl=upload.uploadImage(file, realUploadPath);  
//                  
//        //获取生成的缩略图的相对地址  
//        String thumbImageUrl=thumbnail.generateThumbnail(file, realUploadPath);               
//        return "redirect:/images";  
//    }  
	@RequestMapping(value ="/publishEdit.form", method = RequestMethod.GET)
	public String publishEdit(ModelMap map,HttpSession session) {
		//获取用户基本信息
		UserLogin user = (UserLogin) session.getAttribute("user");
		if(!EmptyUtil.isNullOrEmpty(user)){
			
			return "../jsp/topic/publish-edit";	
		}
		return "../jsp/topic/setting";	
	}

	
	

}
