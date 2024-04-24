package com.dfg.fmodvoicechange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.dfg.fmodvoicechange.databinding.ActivityMainBinding;

import org.fmod.FMOD;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'fmodvoicechange' library on application startup.
    static {
        System.loadLibrary("fmodvoicechange");
    }

    private ActivityMainBinding binding;
    // 播放的路径
    private String path;
    private static final int MODE_NORMAL = 0; // 正常
    private static final int MODE_LUOLI = 1; // 萝莉
    private static final int MODE_DASHU = 2; // 大叔
    private static final int MODE_JINGSONG = 3; // 惊悚
    private static final int MODE_GAOGUAI = 4; // 搞怪
    private static final int MODE_KONGLING = 5; // 空灵

    private native void voiceChangeNative(int mode, String path);
    private  void playerEnd(String msg){
        Toast.makeText(this,""+msg,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        path = "file:///android_asset/derry.mp3";
        FMOD.init(this);
        click();

    }

    public void click(){
        // 原生
        binding.btnYuansheng.setOnClickListener(v -> {
            voiceChangeNative(MODE_NORMAL,path);
        });
        // 萝莉
        binding.btnLuoli.setOnClickListener(v -> {
            voiceChangeNative(MODE_LUOLI,path);
        });
        // 大叔
        binding.btnDashu.setOnClickListener(v -> {
            voiceChangeNative(MODE_DASHU,path);
        });
        // 惊悚
        binding.btnJingsong.setOnClickListener(v -> {
            voiceChangeNative(MODE_JINGSONG,path);
        });
        // 搞怪
        binding.btnGaoguai.setOnClickListener(v -> {
            voiceChangeNative(MODE_GAOGUAI,path);
        });
        // 空灵
        binding.btnKongling.setOnClickListener(v -> {
            voiceChangeNative(MODE_KONGLING,path);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FMOD.close();
    }
}