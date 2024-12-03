package br.com.bws.jornaldejundiapeba.infrastructure.storage;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    public CloudinaryService() {
    }

    public String uploadImage(MultipartFile file) throws IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("folder", "jornal_de_jundiapeba/images");
        params.put("resource_type", "auto");

        var uploadResult = cloudinary.uploader().upload(file.getBytes(), params);

        return (String) uploadResult.get("url");
    }
}
