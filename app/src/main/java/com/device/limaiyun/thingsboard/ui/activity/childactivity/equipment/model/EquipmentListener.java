package com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.model;

import com.device.limaiyun.thingsboard.bean.DeviceTypesBean;

import java.util.List;

/**
 * Created by ${Winter} on 2018/10/19.
 */
public interface EquipmentListener {
    void getDeviceTypesSuc(List<DeviceTypesBean> deviceTypesBean);
    void getDeviceTypesFail();
}
