package com.assets.cn;


import android.os.Bundle; 
import android.app.ListActivity; 
import android.content.Intent;
import android.view.View; 
import android.widget.ArrayAdapter; 
import android.widget.ListView; 
                                                                                                      
public class BookCatalogueActivity extends ListActivity { 
    //创建数组资源 
    private String[] data={"用户界面开发第一讲","用户界面开发第二讲","用户界面开发第三讲","用户界面开发第四讲","用户界面开发第五讲","用户界面开发第六讲"}; 
    
    @Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        //setContentView(R.layout.activity_list_view01); 
        //创建ArrayAdapter数组适配器，装载数据(只显示一行文本) 
        data = this.getIntent().getStringArrayExtra("charpters");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(BookCatalogueActivity.this,android.R.layout.simple_list_item_1,data); 
        //将控件和数组适配器进行绑定 
        BookCatalogueActivity.this.setListAdapter(adapter); 
    } 
    
    @Override 
    protected void onListItemClick(ListView listview,View view,int position,long id) 
    { 
        //Toast.makeText(BookCatalogueActivity.this,data[position],Toast.LENGTH_SHORT).show(); 
		Intent intent = new Intent();
		intent.setClass(BookCatalogueActivity.this, BookCharpterActivity.class);
		intent.putExtra("charpterPath", data[position]);
		startActivity(intent);
    } 
                                                                                                      
/*    @Override 
    public boolean onCreateOptionsMenu(Menu menu) { 
        getMenuInflater().inflate(R.menu.activity_list_view01, menu); 
        return true; 
    } */
    
}
