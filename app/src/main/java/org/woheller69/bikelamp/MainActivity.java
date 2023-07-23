package org.woheller69.bikelamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume(){
        super.onResume();
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String[] cameraID = cameraManager.getCameraIdList();
            cameraManager.setTorchMode(cameraID[0], true);
        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    protected void onPause(){
        super.onPause();
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String[] cameraID = cameraManager.getCameraIdList();
            cameraManager.setTorchMode(cameraID[0], false);
        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onBackPressed(){}  //disable BACK-button

}