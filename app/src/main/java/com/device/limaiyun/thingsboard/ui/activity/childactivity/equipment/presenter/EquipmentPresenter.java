package com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.presenter;

import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.bean.DeviceTypesBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.model.EquipmentListener;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.model.EquipmentModel;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.model.EquipmentPort;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.view.EquipmentView;
import com.device.limaiyun.thingsboard.utils.env.Constant;

import java.util.List;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class EquipmentPresenter extends BasePresenter implements EquipmentListener {
    private EquipmentView mEquipmentView;
    private EquipmentPort mEquipmentPort;

    public EquipmentPresenter(EquipmentView equipmentView) {
        this.mEquipmentView = equipmentView;
        mEquipmentPort = new EquipmentModel();
    }


    public void getDeviceTypes() {
        mEquipmentPort.getDeviceTypes(Constant.API_SERVE_URL+Constant.API_DEVICE_TYPES,this);
    }

    @Override
    public void getDeviceTypesSuc(List<DeviceTypesBean> deviceTypesBean) {
        mEquipmentView.showDeviceTypesTitle(deviceTypesBean);
    }

    @Override
    public void getDeviceTypesFail() {

    }
}
