package com.cd.oa.controller;

import com.cd.oa.entity.Adverstise;
import com.cd.oa.entity.Employee;
import com.cd.oa.entity.UploadFile;
import com.cd.oa.service.AdverstiseService;
import com.cd.oa.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/uploadFile")
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;


    public String uploadPicture(MultipartFile file, HttpServletRequest request){
        File targetFile=null;
        String msg="";//返回存储路径

        Map resultMap=new HashMap<>();
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/static/upload";//存储路径
            String path = request.getSession().getServletContext().getRealPath("static/upload"); //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名


            File file1 =new File(path);
            //如果文件夹不存在则创建
            if(!file1 .exists()  && !file1 .isDirectory()){
                file1 .mkdir();
            }
            targetFile = new File(file1, fileName);

            try {

                file.transferTo(targetFile);
                msg=returnUrl+"/"+fileName;
                resultMap.put("code","0");
                resultMap.put("msg", msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       return msg;
    }

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        Map map2=new HashMap();
        map.put("list",uploadFileService.selectUploadFileByMap(map2));
        return "upload_file_list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Map<String,Object> map){
        return "upload_file_add";
    }

    @RequestMapping("/add")
    public String add(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String url= uploadPicture(file,request);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UploadFile uploadFile=new UploadFile();
        uploadFile.setFileName(request.getParameter("fileName"));
        uploadFile.setFileUrl(url);
        uploadFile.setGmtTime(simpleDateFormat.format(new Date()));
        uploadFile.setOperaterName(((Employee)request.getSession().getAttribute("employee")).getName());
        uploadFile.setOperaterId(((Employee)request.getSession().getAttribute("employee")).getId());
        uploadFileService.add(uploadFile);
        return "redirect:/uploadFile/list";
    }

    @RequestMapping(value = "/toUpdate/{id}")
    public String toUpdate(@PathVariable(value = "id")String id,Map<String,Object> map){
        Map map1=new HashMap();
        map1.put("id",id);
        map.put("uploadFile", uploadFileService.selectUploadFileByMap(map1).get(0));
        return "upload_file_update";
    }

    @RequestMapping("/update/{id}")
    public String update(HttpServletRequest request,@PathVariable(value = "id")Integer id,@RequestParam(value="file",required=false) MultipartFile file){
       UploadFile uploadFile=new UploadFile();
        if (file.isEmpty()){
            uploadFile.setFileUrl(request.getParameter("fileUrl"));
        }else {
            String url = uploadPicture(file, request);
            uploadFile.setFileUrl(url);
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        uploadFile.setId(id);
        uploadFile.setFileName(request.getParameter("fileName"));
        uploadFile.setGmtTime(simpleDateFormat.format(new Date()));
        uploadFile.setOperaterName(((Employee)request.getSession().getAttribute("employee")).getName());
        uploadFile.setOperaterId(((Employee)request.getSession().getAttribute("employee")).getId());
        uploadFileService.update(uploadFile);
        return "redirect:/uploadFile/list";
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id")String id){
        uploadFileService.delete(id);
        return "redirect:/uploadFile/list";
    }

    @RequestMapping("/toDownload/{id}")
    public void toDownload(@PathVariable("id")String id,HttpServletResponse response,HttpServletRequest request) throws IOException {
        Map map2=new HashMap();
        map2.put("id",id);
        UploadFile uploadFile= uploadFileService.selectUploadFileByMap(map2).get(0);
        String url=uploadFile.getFileUrl();
        int i = url.lastIndexOf("/");
        String fileName = url.substring(i + 1);
        URL ul = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) ul.openConnection();
        conn.setConnectTimeout(3 * 1000);
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        InputStream inputStream = conn.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        bos.close();
        byte[] bs =bos.toByteArray();
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        BufferedOutputStream output = null;
        BufferedInputStream input = null;
        try {
            output = new BufferedOutputStream(response.getOutputStream());
            String fileNameDown = new String(fileName.getBytes(), "ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileNameDown);
            output.write(bs);
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                if (input != null)
                try {

                    input.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (output != null)
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

}
