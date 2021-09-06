package activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.bluebase.quadselvision.R;

import util.ScrollTextView;
import util.Utility;

public class MenuScreen extends AppCompatActivity {
    ImageButton imgbtn_crm;
    String token,login_id;
    boolean networkAvailability=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_screen);

        Intent i=getIntent();
        token=i.getStringExtra("token");
        login_id=i.getStringExtra("login_id");

        System.out.println(token+" ====== "+login_id);

        ScrollTextView scrolltext=findViewById(R.id.scrolltext);
        scrolltext.setText(R.string.footer);
        scrolltext.startScroll();

        networkAvailability= Utility.isConnectingToInternet(MenuScreen.this);

        if(networkAvailability==true){
            findviewids();
        }else{
            Utility.getAlertNetNotConneccted(MenuScreen.this, "Internet Connection");
        }

    }

    private void findviewids() {
        imgbtn_crm=findViewById(R.id.imgbtn_crm);

        imgbtn_crm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),EnquiryList.class);
                i.putExtra("token",token);
                i.putExtra("login_id",login_id);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent MainActivity = new Intent(getBaseContext(), LoginScreen.class);
        MainActivity.addCategory(Intent.CATEGORY_HOME);
        MainActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(MainActivity);
        MenuScreen.this.finish();
    }

}
