package com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.model;

import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.DeviceTypesBean;
import com.device.limaiyun.thingsboard.bean.TokenBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.IOException;
import java.util.List;

/**
 * Created by ${Winter} on 2018/10/19.
 */
public class EquipmentModel implements EquipmentPort {
    @Override
    public void getDeviceTypes(String url, final EquipmentListener listener) {
        OkGo.get(url)
                .headers(Configs.X_Authorization, Configs.BEARER + Configs.SPACE + TokenBean.getInstence().getToken())
                .tag(this)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        if (response.code() == 200) {
                            try {
                                String result = response.getRawResponse().body().source().readUtf8();
                                List<DeviceTypesBean> deviceTypesBeans = DeviceTypesBean.arrayDeviceTypesBeanFromData(result);
                                listener.getDeviceTypesSuc(deviceTypesBeans);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else {
                            listener.getDeviceTypesFail();
                        }
                    }

                    @Override
                    public void onCacheSuccess(Response<Object> response) {

                    }

                    @Override
                    public void onError(Response<Object> response) {

                    }

                    @Override
                    public void onFinish() {

                    }

                    @Override
                    public void uploadProgress(Progress progress) {

                    }

                    @Override
                    public void downloadProgress(Progress progress) {

                    }

                    @Override
                    public Object convertResponse(okhttp3.Response response) throws Throwable {
                        return null;
                    }
                });
    }
}
