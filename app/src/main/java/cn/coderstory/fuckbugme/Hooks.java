package cn.coderstory.fuckbugme;


import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * flyme6主题无限试用补丁
 * 适配主题美化6.0.7版本
 * hook函数的注释代码为hook方法的原型（by jeb 2.2.7）
 * 因为入口都是混淆的 所以每个app版本都需要单独适配
 * Created by coder on 2017/1/29.
 */

public class Hooks implements IXposedHookLoadPackage {


    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {

        if (loadPackageParam.packageName.equals("com.meizu.customizecenter")) {

            XposedBridge.log("crack by coderstory");

            //device_states | doCheckState
            //6.0.7
            findAndHookMethod("com.meizu.customizecenter.g.ae", loadPackageParam.classLoader, "h", Context.class, XC_MethodReplacement.returnConstant(0));
            //6.1.0 6.2.0
            findAndHookMethod("com.meizu.customizecenter.g.af", loadPackageParam.classLoader, "h", Context.class, XC_MethodReplacement.returnConstant(0));
            //6.3.2 6.4.0
            findAndHookMethod("com.meizu.customizecenter.utils.ah", loadPackageParam.classLoader, "h", Context.class, XC_MethodReplacement.returnConstant(0));
            //6.5.0
            findAndHookMethod("com.meizu.customizecenter.utils.ai", loadPackageParam.classLoader, "h", Context.class, XC_MethodReplacement.returnConstant(0));
            //6.6.1
            findAndHookMethod("com.meizu.customizecenter.utils.ak", loadPackageParam.classLoader, "h", Context.class, XC_MethodReplacement.returnConstant(0));

            //resetToSystemTheme
            // 6.0.7 6.1.0 6.2.0 6.3.2
            findAndHookMethod("com.meizu.customizecenter.common.theme.common.b", loadPackageParam.classLoader, "a", XC_MethodReplacement.returnConstant(true));

            //data/data/com.meizu.customizecenter/font/   system_font
            //6.0.7 6.1.0 6.2.0
            findAndHookMethod("com.meizu.customizecenter.common.font.FontManager", loadPackageParam.classLoader, "a", XC_MethodReplacement.returnConstant(true));
            //6.3.2
            findAndHookMethod("com.meizu.customizecenter.common.font.FontManager", loadPackageParam.classLoader, "b", XC_MethodReplacement.returnConstant(true));
            //6.4.0
            findAndHookMethod("com.meizu.customizecenter.common.font.FontManager", loadPackageParam.classLoader, "e", XC_MethodReplacement.returnConstant(""));
        }
    }


    private static void findAndHookMethod(String p1, ClassLoader lpparam, String p2, Object... parameterTypesAndCallback) {
        try {
            XposedHelpers.findAndHookMethod(p1, lpparam, p2, parameterTypesAndCallback);

        } catch (Throwable localString3) {
            XposedBridge.log(localString3);
        }
    }

    private static void findAndHookConstructor(String p1, ClassLoader lpparam, Object... parameterTypesAndCallback) {
        try {
            XposedHelpers.findAndHookConstructor(p1, lpparam, lpparam, parameterTypesAndCallback);
        } catch (Throwable localString3) {
            XposedBridge.log(localString3);
        }
    }
}
