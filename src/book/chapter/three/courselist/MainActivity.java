package book.chapter.three.courselist;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button btn;//记录单击的按钮
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//将界面设置为横屏
	    if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}
	}

	//单击按钮的事件处理
	public void setCourse(View view){
		btn=(Button)view;//获取被单击的按钮
		
		Builder courseBuilder=new AlertDialog.Builder(this);//创建对话框
		courseBuilder.setTitle("请输入课程名");//设置对话框标题
		
		final EditText editText=new EditText(this);//创建一个文本编辑器
		editText.setText(btn.getText().toString());//设置文本编辑框内容
		
		courseBuilder.setView(editText);//将文本编辑框添加到对话框中
		courseBuilder.setPositiveButton("确定", new OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				btn.setText(editText.getText().toString());//设置课程
			}			
		});//为对话框添加确定按钮
		courseBuilder.create().show();//创建并显示对话框
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
