package com.example.testapplication;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.data.resultset.ResultSet;
import ohos.data.rdb.ValuesBucket;
import ohos.data.dataability.DataAbilityPredicates;
import ohos.global.resource.RawFileDescriptor;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.utils.net.Uri;
import ohos.utils.PacMap;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataAbility extends Ability {
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001100, "Demo");

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        HiLog.info(LABEL_LOG, "DataAbility onStart");
    }

    @Override
    public RawFileDescriptor openRawFile(Uri uri, String mode) throws FileNotFoundException {
        if (uri == null) {;
            return super.openRawFile(uri, mode);
        }
        String path = uri.getEncodedPath();
        int splitIndex = path.indexOf('/', 1);
        String providerName = Uri.decode(path.substring(1, splitIndex));
        String rawFilePath = Uri.decode(path.substring(splitIndex + 1));
        RawFileDescriptor rawFileDescriptor = null;
        try {
            rawFileDescriptor = getResourceManager().getRawFileEntry(rawFilePath).openRawFileDescriptor();
        } catch (IOException e) {
            // 异常处理
        }
        return rawFileDescriptor;
    }

    @Override
    public ResultSet query(Uri uri, String[] columns, DataAbilityPredicates predicates) {
        return null;
    }

    @Override
    public int insert(Uri uri, ValuesBucket value) {
        HiLog.info(LABEL_LOG, "DataAbility insert");
        return 999;
    }

    @Override
    public int delete(Uri uri, DataAbilityPredicates predicates) {
        return 0;
    }

    @Override
    public int update(Uri uri, ValuesBucket value, DataAbilityPredicates predicates) {
        return 0;
    }

    @Override
    public FileDescriptor openFile(Uri uri, String mode) {
        return null;
    }

    @Override
    public String[] getFileTypes(Uri uri, String mimeTypeFilter) {
        return new String[0];
    }

    @Override
    public PacMap call(String method, String arg, PacMap extras) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }
}