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

	private Button btn;//��¼�����İ�ť
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//����������Ϊ����
	    if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}
	}

	//������ť���¼�����
	public void setCourse(View view){
		btn=(Button)view;//��ȡ�������İ�ť
		
		Builder courseBuilder=new AlertDialog.Builder(this);//�����Ի���
		courseBuilder.setTitle("������γ���");//���öԻ������
		
		final EditText editText=new EditText(this);//����һ���ı��༭��
		editText.setText(btn.getText().toString());//�����ı��༭������
		
		courseBuilder.setView(editText);//���ı��༭����ӵ��Ի�����
		courseBuilder.setPositiveButton("ȷ��", new OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				btn.setText(editText.getText().toString());//���ÿγ�
			}			
		});//Ϊ�Ի������ȷ����ť
		courseBuilder.create().show();//��������ʾ�Ի���
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
