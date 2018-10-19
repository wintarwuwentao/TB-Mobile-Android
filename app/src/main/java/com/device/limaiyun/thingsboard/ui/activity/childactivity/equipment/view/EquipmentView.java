package com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.view;

import com.device.limaiyun.thingsboard.base.BaseView;
import com.device.limaiyun.thingsboard.bean.DeviceTypesBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public interface EquipmentView extends BaseView {

    void showDeviceTypesTitle(List<DeviceTypesBean> deviceTypesBean);
}
