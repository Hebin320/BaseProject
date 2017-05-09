package com.hebin.ui.activity.universal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.hebin.R;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.hebin.base.BaseActivity;
import com.hebin.custom.webview.X5WebView;

import butterknife.ButterKnife;
import butterknife.InjectView;
/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:26
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
public class WebViewActivity extends BaseActivity {


    @InjectView(R.id.webview)
    X5WebView webview;

    public ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> mUploadMessageForAndroid5;
    public final static int FILECHOOSER_RESULTCODE = 1;
    public final static int FILECHOOSER_RESULTCODE_FOR_ANDROID_5 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.inject(this);
        init();
        webview.loadUrl("http://www.baidu.com");
    }

    @Override
    protected void onResume() {
        super.onResume();
        webview.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        webview.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webview.destroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == FILECHOOSER_RESULTCODE) {
            if (null == mUploadMessage)
                return;
            Uri result = intent == null || resultCode != RESULT_OK ? null : intent.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;

        } else if (requestCode == FILECHOOSER_RESULTCODE_FOR_ANDROID_5) {
            if (null == mUploadMessageForAndroid5)
                return;
            Uri result = (intent == null || resultCode != RESULT_OK) ? null : intent.getData();
            if (result != null) {
                mUploadMessageForAndroid5.onReceiveValue(new Uri[]{result});
            } else {
                mUploadMessageForAndroid5.onReceiveValue(new Uri[]{});
            }
            mUploadMessageForAndroid5 = null;
        }
    }


    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            finish();
        }
    }


    private void init() {
        webview.setWebChromeClient(new WebChromeClient() {
            //扩展浏览器上传文件
            //3.0++版本
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
                openFileChooserImpl(uploadMsg);
            }

            //3.0--版本
            public void openFileChooser(ValueCallback<Uri> uploadMsg) {
                openFileChooserImpl(uploadMsg);
            }

            @Override
            public void openFileChooser(ValueCallback<Uri> valueCallback, String s, String s1) {
                openFileChooserImpl(valueCallback);
            }

            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
                openFileChooserImplForAndroid5(valueCallback);
                return true;
            }
        });
    }

    private void openFileChooserImpl(ValueCallback<Uri> uploadMsg) {
        mUploadMessage = uploadMsg;
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
    }

    private void openFileChooserImplForAndroid5(ValueCallback<Uri[]> uploadMsg) {
        mUploadMessageForAndroid5 = uploadMsg;
        Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
        contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
        contentSelectionIntent.setType("image/*");

        Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
        chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
        chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser");
        startActivityForResult(chooserIntent, FILECHOOSER_RESULTCODE_FOR_ANDROID_5);
    }

}
