package special.topic.covid19today.ui.emergency;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import special.topic.covid19today.R;

public class EmergencyFragment extends Fragment {

    private EmergencyViewModel emergencyViewModel;
    private static final int REQUEST_CALL = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_emergency, container, false);


        final ImageView call1422 = root.findViewById(R.id.imageView1);
        call1422.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makePhoneCall1();
            }
        });

        final ImageView call1330= root.findViewById(R.id.imageView2);
        call1330.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makePhoneCall2();
            }
        });

        final ImageView call1506 = root.findViewById(R.id.imageView3);
        call1506.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makePhoneCall3();
            }
        });

        final ImageView call1669 = root.findViewById(R.id.imageView4);
        call1669.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makePhoneCall4();
            }
        });

        return root;
    }



    private void makePhoneCall1(){
        if(ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1422"));
            startActivity(intent);
        }

    }
    private void makePhoneCall2(){
        if(ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1330"));
            startActivity(intent);
        }

    }
    private void makePhoneCall3(){
        if(ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1506"));
            startActivity(intent);
        }

    }
    private void makePhoneCall4(){
        if(ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1669"));
            startActivity(intent);
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if ( requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall1();
                makePhoneCall2();
                makePhoneCall3();
                makePhoneCall4();
            }else {

            }
        }
    }
}
