
实验三 创建自定义布局的AlertDialog


MainAcivity.java


    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
    }
 }
 
 
 
 login_layout.xml
 
 
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="ANDROID APP"
        android:textSize="50dp"
        android:textColor="#ffffff"
        android:background="#fff000"
        android:textStyle="italic"
        />

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="text"
        android:hint="USERNAME"
        android:id="@+id/et_username"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPassword"
        android:hint="PASSWORD"
        android:id="@+id/et_password"/>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="50dp">
        <Button
            android:layout_width="200dp"
            android:layout_height="50dp"
            android:text="CANCLE"/>
        <Button
            android:layout_width="200dp"
            android:layout_height="50dp"
            android:text="LOGIN"/>
    </LinearLayout>

</LinearLayout>



AlertDialogDemo.java

    public class AlertDialogDemo extends AppCompatActivity {
    private EditText et_username,et_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdialog);
    }

    public void login(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录");
        //通过布局填充器获login_layout
        View view = getLayoutInflater().inflate(R.layout.login_layout,null);

        final EditText et_username = (EditText) view.findViewById(R.id.et_username);
        final EditText et_password = (EditText) view.findViewById(R.id.et_password);
        builder.setView(view);
        builder.setCancelable(false);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = et_username.getText().toString().trim();
                String pass = et_password.getText().toString().trim();
                Toast.makeText(AlertDialogDemo.this,name + "正在登录....", Toast.LENGTH_SHORT).show();
            }

        });


        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogDemo.this,"取消登录",Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }
   }
   
   
