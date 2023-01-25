package com.moudy.language;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";
    Resources resources;
    String current_Device_language, current_app_language;
    TextView tv_english, tv_arabic, tv_forget, tv_Signintocontinue, tv_newuser, tv_SignUp;
    private Button login;
    private View parent_view;
    private TextInputLayout usernamelayout, passwordlayout;
    private TextInputEditText username_ed, password_ed;
    Context context;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        sharedPreferences = getSharedPreferences("MySP", MODE_PRIVATE); //open
        if ((Locale.getDefault().getDisplayLanguage().toString()).equals("العربية") && sharedPreferences.getString("language", "").isEmpty()) {
            allarabic();
        } else if ((Locale.getDefault().getDisplayLanguage().toString()).equalsIgnoreCase("English") && sharedPreferences.getString("language", "").isEmpty()) {
            allenglish();
        }

        if (sharedPreferences.getString("language", "").equals("ar")) {
            allarabic();
            Toast.makeText(context, "ar ", Toast.LENGTH_LONG).show();
        } else if (sharedPreferences.getString("language", "").equals("en")) {
            allenglish();
            Toast.makeText(context, "en ", Toast.LENGTH_LONG).show();

        }
        tv_arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = LocaleHelper.setLocale(MainActivity.this, "ar");
                resources = context.getResources();
                allarabic();
            }


        });
        tv_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = LocaleHelper.setLocale(MainActivity.this, "en");
                resources = context.getResources();
                allenglish();
            }


        });


    }
    private void initViews() {
        login = findViewById(R.id.signin);
        username_ed = findViewById(R.id.username_ed);
        usernamelayout = findViewById(R.id.usernamelay);
        password_ed = findViewById(R.id.ed_pass);
        passwordlayout = findViewById(R.id.passwordil);
        tv_arabic = findViewById(R.id.tv_arabic);
        tv_english = findViewById(R.id.tv_english);
        tv_forget = findViewById(R.id.tv_forget);
        tv_Signintocontinue = findViewById(R.id.tv_Signintocontinue);
        tv_newuser = findViewById(R.id.tv_newuser);
        tv_SignUp = findViewById(R.id.tv_SignUp);
    }
    private void allarabic() {


        current_app_language = "ar";
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language", current_app_language);
        // editor.remove("language");
        editor.commit();

        context = LocaleHelper.setLocale(MainActivity.this, "ar");
        resources = context.getResources();
        usernamelayout.setHint(resources.getString(R.string.email));
        login.setText(resources.getString(R.string.signin));
        tv_forget.setText(resources.getString(R.string.forgetpasswoed));
        passwordlayout.setHint(resources.getString(R.string.Password));
        tv_Signintocontinue.setText(resources.getString(R.string.Signintocontinue));
        tv_newuser.setText(resources.getString(R.string.newuser));
        tv_SignUp.setText(resources.getString(R.string.SignUp));
        passwordlayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        usernamelayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        tv_arabic.setTextColor(getResources().getColor(R.color.green_300));
        tv_english.setTextColor(getResources().getColor(R.color.default_text_view_color));
    }

    private void allenglish() {

        current_app_language = "en";
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language", current_app_language);
        // editor.remove("language");


        editor.commit();
        context = LocaleHelper.setLocale(MainActivity.this, "en");
        resources = context.getResources();

        usernamelayout.setHint(resources.getString(R.string.email));
        login.setText(resources.getString(R.string.signin));
        tv_forget.setText(resources.getString(R.string.forgetpasswoed));
        passwordlayout.setHint(resources.getString(R.string.Password));
        tv_Signintocontinue.setText(resources.getString(R.string.Signintocontinue));
        tv_newuser.setText(resources.getString(R.string.newuser));
        tv_SignUp.setText(resources.getString(R.string.SignUp));
        usernamelayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        passwordlayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        tv_english.setTextColor(getResources().getColor(R.color.green_300));
        tv_arabic.setTextColor(getResources().getColor(R.color.default_text_view_color));
    }



}