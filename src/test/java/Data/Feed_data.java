package Data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
public class Feed_data {
    public static String jsonData;
    public List<HashMap<String, String>> extractdata() throws IOException {
        jsonData= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/src/test/java/Data/Jsndata.json"), StandardCharsets.UTF_8);
        System.out.println(jsonData);
        ObjectMapper objectMapper=new ObjectMapper();
        List<HashMap<String,String>> tomap = objectMapper.readValue(jsonData, new TypeReference<List<HashMap<String,String>>>() {});
        return tomap;
    }

}
