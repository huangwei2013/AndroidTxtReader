package com.assets.cn;

import java.io.FileInputStream;
import org.apache.http.util.EncodingUtils;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class BookCharpterActivity extends Activity {

	public static final String ENCODING = "UTF-8";
	TextView tv1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		tv1 = (TextView)findViewById(R.id.tv1);
		tv1.setTextColor(Color.BLACK);
		tv1.setTextSize(25.0f);
		
		String charpterPath = this.getIntent().getStringExtra("charpterPath");
		String charpterContent = readFileSdcard(charpterPath);
		tv1.setText(charpterContent);
	}
    
	public String readFileSdcard(String fileName) {

		String res = "";
		try {
			FileInputStream fin = new FileInputStream(fileName);
			int length = fin.available();
			byte[] buffer = new byte[length];
			fin.read(buffer);
			res = EncodingUtils.getString(buffer, "UTF-8");
			fin.close();
		}
		catch (Exception e) {
			res = fileName + "打开失败";
		}
		return res;
	} 
}
