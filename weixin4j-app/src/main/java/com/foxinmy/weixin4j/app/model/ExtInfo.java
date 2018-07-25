package com.foxinmy.weixin4j.app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 *
 * @auther: Feng Yapeng
 * @since: 2017/5/5 14:20
 */
public class ExtInfo {

    /**
     * 授权方Appid，可填入商户AppID，以区分不同商户
     */
    private String                           extAppid;
    /**
     * 自定义字段仅允许在这里定义，可在小程序中调用
     */
    private HashMap<String,Object>           ext;
    /**
     * 页面配置
     */
    private HashMap<String,PageConfigInfo> extPages;

    /**
     * 每一项代表对应页面的【路径+文件名】信息，数组的第一项代表小程序的初始页面。小程序中新增/减少页面，都需要对 pages 数组进行修改。
     */
    private List<String> pages;

    /**
     * 用于设置小程序的状态栏、导航条、标题、窗口背景色。
     */
    private  WindowConfigInfo window;
    /**
     * 可以设置各种网络请求的超时时间。
     */
    private NetWorkTimeOutConfig networkTimeout;

    private TabBarConfig tabBar;


    public String getExtAppid() {
        return extAppid;
    }

    public ExtInfo setExtAppid(String extAppid) {
        this.extAppid = extAppid;
        return this;
    }

    public HashMap<String, Object> getExt() {
        return ext;

    }

    public ExtInfo setExt(HashMap<String, Object> ext) {
        this.ext = ext;
        return this;
    }

    public HashMap<String, PageConfigInfo> getExtPages() {
        return extPages;
    }

    public ExtInfo setExtPages(HashMap<String, PageConfigInfo> extPages) {
        this.extPages = extPages;
        return this;
    }

    public List<String> getPages() {
        return pages;
    }

    public ExtInfo setPages(List<String> pages) {
        this.pages = pages;
        return this;
    }

    public WindowConfigInfo getWindow() {
        return window;
    }

    public ExtInfo setWindow(WindowConfigInfo window) {
        this.window = window;
        return this;
    }

    public NetWorkTimeOutConfig getNetworkTimeout() {
        return networkTimeout;
    }

    public ExtInfo setNetworkTimeout(NetWorkTimeOutConfig networkTimeout) {
        this.networkTimeout = networkTimeout;
        return this;
    }

    public TabBarConfig getTabBar() {
        return tabBar;
    }

    public ExtInfo setTabBar(TabBarConfig tabBar) {
        this.tabBar = tabBar;
        return this;
    }

    /**
     * TODO(这个类的作用)
     *
     * @auther: Feng Yapeng
     * @since: 2017/5/5 14:48
     */
    public static class PageConfigInfo extends WindowConfigInfo {


        /*
         * 设置为 true 则页面整体不能上下滚动；只在 page.json 中有效，无法在 app.json 中设置该项
         */
        private Boolean disableScroll;


        public Boolean getDisableScroll() {
            return disableScroll;
        }


        public PageConfigInfo setDisableScroll(Boolean disableScroll) {
            this.disableScroll = disableScroll;
            return this;
        }
    }

    /**
     * 页面配置
     *
     * @auther: Feng Yapeng
     * @since: 2017/5/5 14:33
     */
    public static class WindowConfigInfo {

        /**
         * 导航栏背景颜色，如"#000000"
         */
        private String navigationBarBackgroundColor;
        /**
         * 导航栏标题颜色，仅支持 black/white
         */
        private String navigationBarTextStyle;

        /**
         * 导航栏标题文字内容
         */
        private String  navigationBarTitleText;
        /**
         * 窗口的背景色
         */
        private String  backgroundColor;
        /**
         * 下拉背景字体、loading 图的样式，仅支持 dark/light
         */
        private String  backgroundTextStyle;
        /**
         * 是否开启下拉刷新，详见
         */
        private Boolean enablePullDownRefresh;


        public String getNavigationBarBackgroundColor() {
            return navigationBarBackgroundColor;
        }

        public WindowConfigInfo setNavigationBarBackgroundColor(String navigationBarBackgroundColor) {
            this.navigationBarBackgroundColor = navigationBarBackgroundColor;
            return this;
        }

        public String getNavigationBarTextStyle() {
            return navigationBarTextStyle;
        }

        public WindowConfigInfo setNavigationBarTextStyle(String navigationBarTextStyle) {
            this.navigationBarTextStyle = navigationBarTextStyle;
            return this;
        }

        public String getNavigationBarTitleText() {
            return navigationBarTitleText;
        }

        public WindowConfigInfo setNavigationBarTitleText(String navigationBarTitleText) {
            this.navigationBarTitleText = navigationBarTitleText;
            return this;
        }

        public String getBackgroundColor() {
            return backgroundColor;
        }

        public WindowConfigInfo setBackgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public String getBackgroundTextStyle() {
            return backgroundTextStyle;
        }

        public WindowConfigInfo setBackgroundTextStyle(String backgroundTextStyle) {
            this.backgroundTextStyle = backgroundTextStyle;
            return this;
        }

        public Boolean getEnablePullDownRefresh() {
            return enablePullDownRefresh;
        }

        public WindowConfigInfo setEnablePullDownRefresh(Boolean enablePullDownRefresh) {
            this.enablePullDownRefresh = enablePullDownRefresh;
            return this;
        }


    }

    public static class NetWorkTimeOutConfig{

        /**
         * 	wx.request的超时时间，单位毫秒，默认为：60000
         */
        private Long request;
        /**
         * wx.connectSocket的超时时间，单位毫秒，默认为：60000
         */
        private Long connectSocket;
        /**
         * wx.uploadFile的超时时间，单位毫秒，默认为：60000
         */
        private Long uploadFile;
        /**
         * wx.downloadFile的超时时间，单位毫秒，默认为：60000
         */
        private Long downloadFile;

        public Long getRequest() {
            return request;
        }

        public NetWorkTimeOutConfig setRequest(Long request) {
            this.request = request;
            return this;
        }

        public Long getConnectSocket() {
            return connectSocket;
        }

        public NetWorkTimeOutConfig setConnectSocket(Long connectSocket) {
            this.connectSocket = connectSocket;
            return this;
        }

        public Long getUploadFile() {
            return uploadFile;
        }

        public NetWorkTimeOutConfig setUploadFile(Long uploadFile) {
            this.uploadFile = uploadFile;
            return this;
        }

        public Long getDownloadFile() {
            return downloadFile;
        }

        public NetWorkTimeOutConfig setDownloadFile(Long downloadFile) {
            this.downloadFile = downloadFile;
            return this;
        }
    }

    /**
     *
     */
    public static class TabBarConfig {

        /**
         * tab 上的文字默认颜色
         */
        private String color;
        /**
         * tab 上的文字选中时的颜色
         */
        private String selectedColor;
        /**
         * tab 的背景色
         */
        private String backgroundColor;
        /**
         * tabbar上边框的颜色， 仅支持 black/white
         */
        private String borderStyle;
        /**
         *
         */
        private List<HashMap<String,String>> list;
        /**
         * 可选值 bottom、top
         */
        private String position;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getSelectedColor() {
            return selectedColor;
        }

        public TabBarConfig setSelectedColor(String selectedColor) {
            this.selectedColor = selectedColor;
            return this;
        }

        public String getBackgroundColor() {
            return backgroundColor;
        }

        public TabBarConfig setBackgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public String getBorderStyle() {
            return borderStyle;
        }

        public TabBarConfig setBorderStyle(String borderStyle) {
            this.borderStyle = borderStyle;
            return this;
        }

        public List<HashMap<String, String>> getList() {
            return list;
        }

        /**
         *
         * @param pagePath 页面路径，必须在 pages 中先定义
         * @param text tab 上按钮文字
         * @return
         */
        public TabBarConfig addListItem(String pagePath, String text){
            if(this.getList() == null){
                this.list = new ArrayList<HashMap<String, String>>();
            }
            HashMap<String,String> map = new HashMap<String, String>();
            map.put("pagePath",pagePath);
            map.put("text",text);
            this.list.add(map);
            return this;
        }

        /**
         *
         * @param pagePath  页面路径，必须在 pages 中先定义
         * @param text tab 上按钮文字
         * @param iconPath 图片路径，icon 大小限制为40kb，建议尺寸为 81px * 81px，当 postion 为 top 时，此参数无效
         * @param selectedIconPath 选中时的图片路径，icon 大小限制为40kb，建议尺寸为 81px * 81px ，当 postion 为 top 时，此参数无效
         * @return
         */
        public TabBarConfig addListItem(String pagePath, String text,String iconPath,String selectedIconPath){
            if(this.getList() == null){
                this.list = new ArrayList<HashMap<String, String>>();
            }
            HashMap<String,String> map = new HashMap<String, String>();
            map.put("pagePath",pagePath);
            map.put("text",text);
            map.put("iconPath",iconPath);
            map.put("selectedIconPath",selectedIconPath);
            this.list.add(map);
            return this;
        }

        public String getPosition() {
            return position;
        }

        public void setPositionBottom() {
            this.position = "bottom";
        }
        public void setPositionTop() {
            this.position = "top";
        }
    }
}
