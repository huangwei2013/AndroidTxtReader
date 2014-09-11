package com.assets.cn;

import android.os.Bundle; 
import android.app.ListActivity; 
import android.content.Intent;
import android.view.View; 
import android.widget.ArrayAdapter; 
import android.widget.ListView; 

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TxtReaderActivity extends ListActivity {
	
	public static final String ENCODING = "UTF-8";
	private String[] books;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		
		String booksDir = "/sdcard/books";
		books = getBooks(booksDir);
		if(books != null){
			System.out.println("书:"+books.toString());
	        ArrayAdapter<String> adapter=new ArrayAdapter<String>(TxtReaderActivity.this,android.R.layout.simple_list_item_1,books); 
	        //将控件和数组适配器进行绑定 
	        TxtReaderActivity.this.setListAdapter(adapter); 
		}else{
			System.out.println("没有任何书");
		}
	}
    
    @Override 
    protected void onListItemClick(ListView listview,View view,int position,long id) 
    { 
		getBookCharpterList(books[position]);
    } 
    
    private String[] getBooks(String booksDir)
    {
		 if (booksDir == null){
			 return null;
		 }
		 
		 File[] fileList = null;
		 File file = new File(booksDir); 
		 if (!file.exists() || !file.isDirectory() || (file.listFiles() == null) || (file.listFiles().length == 0)) {
			 System.out.println("file is invalid");
			 return null;
		 }
		 
		 fileList = file.listFiles();
		 int mFileSize = file.listFiles().length;
		 List<String> mPathString = new ArrayList<String>();
		 
		 if(mFileSize > 0) {
		     for(int i = 0;i < mFileSize;i++) {
		         mPathString.add(fileList[i].getAbsolutePath());
		     }
		     Collections.sort(mPathString);
		 }
		 System.out.println("file :" + mPathString.toString());
		 String strings[]=new String[mPathString.size()];
		 for(int i=0,j=mPathString.size();i<j;i++){
			 strings[i]=mPathString.get(i);
		 }
		 System.out.println("file strings :" + strings.toString());
		 return strings;
    }
    
    private void getBookCharpterList(String bookDir)
    {
		 if (bookDir == null){
			 return ;
		 }
		 
		 File[] fileList = null;
		 File file = new File(bookDir);
		 if (!file.exists() || (file.isDirectory() && (file.listFiles().length == 0))) {
			 return ;
		 }
		 
		 fileList = file.listFiles();
		 int mFileSize = file.listFiles().length;
		 List<String> mPathString = new ArrayList<String>();
		 
		 if(mFileSize > 0) {
		     for(int i = 0;i < mFileSize;i++) {
		         mPathString.add(fileList[i].getAbsolutePath());
		     }
		     Collections.sort(mPathString);
		 }
		
		 String strings[]=new String[mPathString.size()];
		 for(int i=0,j=mPathString.size();i<j;i++){
			 strings[i]=mPathString.get(i);
		 }
		 
		 
		Intent intent = new Intent();
		intent.setClass(TxtReaderActivity.this, BookCatalogueActivity.class);
		intent.putExtra("charpters", strings);
		startActivity(intent);
    }
	
}