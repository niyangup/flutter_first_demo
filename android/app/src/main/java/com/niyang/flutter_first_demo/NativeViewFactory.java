package com.niyang.flutter_first_demo;

import android.content.Context;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

import java.util.Map;

class NativeViewFactory extends PlatformViewFactory {
    @NonNull
    private final BinaryMessenger messenger;

    NativeViewFactory(@NonNull BinaryMessenger messenger) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = messenger;
    }

    @NonNull
    @Override
    public PlatformView create(@NonNull Context context, int id, @Nullable Object args) {
        final Map<String, Object> creationParams = (Map<String, Object>) args;
        if (((Map<String, Object>) args).get("url") != null) {
            return new NativeWebView(context, messenger, id, creationParams);
        } else {
            return new NativeView(context, messenger, id, creationParams);
        }

    }
}