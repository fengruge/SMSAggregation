package org.dromara.sms4j.core.factory;

//import org.dromara.sms4j.aliyun.service.AlibabaSmsImpl;
//import org.dromara.sms4j.comm.config.SmsConfig;
//import org.dromara.sms4j.comm.enumerate.ConfigType;
//import org.dromara.sms4j.comm.factory.BeanFactory;
//import org.dromara.sms4j.core.SupplierSqlConfig;
//import org.dromara.sms4j.emay.config.EmaySmsConfig;
//import org.dromara.sms4j.aliyun.config.AlibabaSmsConfig;
//import org.dromara.sms4j.api.SmsBlend;
//import org.dromara.sms4j.cloopen.config.CloopenSmsConfig;
//import org.dromara.sms4j.comm.enumerate.SupplierType;
//import org.dromara.sms4j.comm.exception.SmsBlendException;
//import org.dromara.sms4j.core.config.SupplierFactory;
//import org.dromara.sms4j.huawei.config.HuaweiSmsConfig;
//import org.dromara.sms4j.jdcloud.config.JdCloudSmsConfig;
//import org.dromara.sms4j.tencent.config.TencentSmsConfig;
//import org.dromara.sms4j.unisms.config.UniSmsConfig;

import org.dromara.sms4j.api.SmsBlend;
import org.dromara.sms4j.comm.enumerate.SupplierType;
import org.dromara.sms4j.comm.exception.SmsBlendException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SmsFactory
 * <p>构造工厂，用于获取一个厂商的短信实现对象
 * 在调用对应厂商的短信发送方法前，请先确保你的配置已经实现，否则无法发送该厂商对应的短信，一般情况下厂商会回执因缺少的配置所造成的的异常，但不会
 * 以java异常的形式抛出
 *
 * @author :Wind
 * 2023/4/8  15:55
 **/
public abstract class SmsFactory {
    private SmsFactory() {
    }

    private static final Map<SupplierType, SmsBlend> SMS = new ConcurrentHashMap<>();

    public static void register(SupplierType supplierType, SmsBlend smsBlend) {
        SMS.putIfAbsent(supplierType, smsBlend);
    }

    public static SmsBlend getSmsBlend(SupplierType supplierType) {
        SmsBlend smsBlend = SMS.get(supplierType);
        if (smsBlend != null) {
            return smsBlend;
        }
        throw new SmsBlendException("An attempt to construct a SmsBlend object failed. Please check that the enumeration is valid");
    }

    /**
     * createSmsBlend
     * <p>获取各个厂商的实现类
     *
     * @param supplierType 厂商枚举
     * @author :Wind
     */
    @Deprecated
    public static SmsBlend createSmsBlend(SupplierType supplierType) {
        return getSmsBlend(supplierType);
    }

    /**
     * refresh
     * <p>刷新配置，用于切换配置后的刷新，防止因厂商sdk内部的保存导致配置更新不及时
     * 此方法会造成一定的性能损失，不建议经常性调用
     *
     * @author :Wind
     */
//    public static void refresh() {
//        AlibabaSmsConfig.refresh(SupplierFactory.getAlibabaConfig());
//        HuaweiSmsConfig.refresh(SupplierFactory.getHuaweiConfig());
//        UniSmsConfig.refresh(SupplierFactory.getUniConfig());
//        TencentSmsConfig.refresh(SupplierFactory.getTencentConfig());
//        JdCloudSmsConfig.refresh(SupplierFactory.getJdCloudConfig());
//        CloopenSmsConfig.refresh(SupplierFactory.getCloopenConfig());
//        EmaySmsConfig.refresh(SupplierFactory.getEmayConfig());
//    }

    /**
     * refresh
     * <p>根据厂商类型枚举刷新对应厂商的配置，此方法不会刷新全部厂商的配置对象，只会重构所选厂商的对象，性能损失相对较小
     *
     * @param supplierType 厂商类型枚举
     * @author :Wind
     */
//    public static void refresh(SupplierType supplierType) {
//        switch (supplierType) {
//            case ALIBABA:
//                 AlibabaSmsConfig.refresh(SupplierFactory.getAlibabaConfig());
//            case HUAWEI:
//                 HuaweiSmsConfig.refresh(SupplierFactory.getHuaweiConfig());
//            case UNI_SMS:
//                 UniSmsConfig.refresh(SupplierFactory.getUniConfig());
//            case TENCENT:
//                 TencentSmsConfig.refresh(SupplierFactory.getTencentConfig());
//            case JD_CLOUD:
//                 JdCloudSmsConfig.refresh(SupplierFactory.getJdCloudConfig());
//            case CLOOPEN:
//                 CloopenSmsConfig.refresh(SupplierFactory.getCloopenConfig());
//            case EMAY:
//                 EmaySmsConfig.refresh(SupplierFactory.getEmayConfig());
//        }
//        throw new SmsBlendException("An attempt to construct a SmsBlend object failed. Please check that the enumeration is valid");
//    }

    /**
     * refreshSqlConfig
     * <p>重新读取sql配置
     *
     * @author :Wind
     */
//    public static void refreshSqlConfig() {
//        SupplierSqlConfig.refreshSqlConfig();
//    }

}