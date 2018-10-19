package com.device.limaiyun.thingsboard.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Winter} on 2018/10/19.
 */
public class DeviceTypesBean {


    /**
     * tenantId : {"entityType":"TENANT","id":"9406eb50-d0f0-11e8-8c05-5fb5a519e7df"}
     * entityType : DEVICE
     * type : 吹塑机
     */

    private TenantIdBean tenantId;
    private String entityType;
    private String type;

    public static List<DeviceTypesBean> arrayDeviceTypesBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<DeviceTypesBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<DeviceTypesBean> arrayDeviceTypesBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<DeviceTypesBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public TenantIdBean getTenantId() {
        return tenantId;
    }

    public void setTenantId(TenantIdBean tenantId) {
        this.tenantId = tenantId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class TenantIdBean {
        /**
         * entityType : TENANT
         * id : 9406eb50-d0f0-11e8-8c05-5fb5a519e7df
         */

        private String entityType;
        private String id;

        public static List<TenantIdBean> arrayTenantIdBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<TenantIdBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<TenantIdBean> arrayTenantIdBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<TenantIdBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getEntityType() {
            return entityType;
        }

        public void setEntityType(String entityType) {
            this.entityType = entityType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
