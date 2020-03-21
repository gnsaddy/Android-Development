package com.addy.newsfragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_two extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Toast.makeText(getContext(),"Fragment onAttach",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("lifyCycle","Fragment onCreate");
        Toast.makeText(getContext(),"Fragment onCreate",Toast.LENGTH_LONG).show();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_fragment_two,container,false);
        WebView webView = (WebView)view.findViewById(R.id.web2);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://kannada.oneindia.com/");
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d("lifyCycle","Fragment onStart");
        Toast.makeText(getContext(),"Fragment onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("lifyCycle","Fragment onDestroyView");
        Toast.makeText(getContext(),"Fragment onDestroyView",Toast.LENGTH_LONG).show();

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("lifyCycle","Fragment onDestroy");
        Toast.makeText(getContext(),"Fragment onDestroy",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("lifyCycle","Fragment onDetach");
        Toast.makeText(getContext(),"Fragment onDetach",Toast.LENGTH_LONG).show();
    }


}
