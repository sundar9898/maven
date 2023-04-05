package Maven.sundarmaven.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJasondata() throws IOException {
		
		//read jason to string
		String jasonContent =FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Maven//sundarmaven//data//PurchaseOrder.json"),StandardCharsets.UTF_8);
        //string to HashMap jackson databind
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jasonContent,new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;

	}

}
