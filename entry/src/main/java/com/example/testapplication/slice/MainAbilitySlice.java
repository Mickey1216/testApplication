package com.example.testapplication.slice;

import com.example.testapplication.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.webengine.WebConfig;
import ohos.agp.components.webengine.WebView;

import java.net.URL;

public class MainAbilitySlice extends AbilitySlice {
    private WebView webview;
    private static final String URL_local = "dataability://com.example.testapplication.DataAbility/resources/rawfile/main/index.html";
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        webview = (WebView) findComponentById(ResourceTable.Id_webview);
        WebConfig webConfig = webview.getWebConfig();
        webConfig.setJavaScriptPermit(true);
        webConfig.setDataAbilityPermit(true);
        webview.load(URL_local);
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
