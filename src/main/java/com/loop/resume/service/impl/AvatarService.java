package com.loop.resume.service.impl;

import com.loop.resume.common.ServerResponse;
import com.loop.resume.dao.AvatarMapper;
import com.loop.resume.dao.ResumeMapper;
import com.loop.resume.pojo.Avatar;
import com.loop.resume.pojo.Resume;
import com.loop.resume.service.IAvatarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.zip.GZIPOutputStream;

@Service("iAvatarService")
public class AvatarService  implements IAvatarService{

    Logger log = LoggerFactory.getLogger(AvatarService.class);

    @Autowired
    AvatarMapper avatarMapper;

    @Autowired
    ResumeMapper resumeMapper;

    @Override
    public ServerResponse getImg(Integer id) {
        Avatar avatar = avatarMapper.selectByPrimaryKey(id);
        String base64 = new BASE64Encoder().encode(avatar.getImg());

        return ServerResponse.createBySuccess(base64);
    }

    @Override
    public ServerResponse putImg(MultipartFile file) {

        byte[] buffer =null;
        try{
            InputStream is = file.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = is.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            is.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Avatar avatar = new Avatar();
        avatar.setImg(buffer);

        //插入并生成主键
        avatarMapper.insertSelective(avatar);

        //更新resume的头像
        Resume resume = new Resume();
        //todo resume_id应从当前session中获取
        resume.setId(1);
        resume.setAvatar(avatar.getId());
        resumeMapper.updateByPrimaryKeySelective(resume);
        //返回主键给客户端
        return ServerResponse.createBySuccess(avatar.getId());
    }


    public static final String ENCODE = "ISO-8859-1";

    private String byte2Str(byte[] bytes) {
        String dataStr = null;
        try{
            dataStr = new String(bytes, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return dataStr;
    }

    private String compress(String source) {
        String dest=null;
        try{
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            GZIPOutputStream gout = new GZIPOutputStream(bout);
            gout.write(source.getBytes(ENCODE));
            gout.finish();
            gout.close();
            dest = bout.toString(ENCODE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest;
    }

}
